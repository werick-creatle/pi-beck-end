package br.com.gamestore.loja_api.security;

import br.com.gamestore.loja_api.model.Usuario;
import br.com.gamestore.loja_api.repositories.UsuarioRepository;
import br.com.gamestore.loja_api.services.TokenService;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--- INICIO DO FILTRO SECURITY ---");
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            System.out.println("1. Token encontrado no Header: " + tokenJWT.substring(0, 10) + "...");

            try {
                // Tenta validar o token
                DecodedJWT decodedJWT = tokenService.validarToken(tokenJWT);

                if (decodedJWT != null) {
                    String subject = decodedJWT.getSubject();
                    System.out.println("2. Token válido! Login extraído (Subject): " + subject);

                    // Busca o usuário no banco
                    var userDetails = usuarioRepository.findByLogin(subject);

                    if (userDetails != null) {
                        System.out.println("3. Usuário encontrado no banco de dados.");

                        if (userDetails instanceof Usuario) {
                            Usuario usuario = (Usuario) userDetails;

                            // Cria a autenticação considerando as ROLES (getAuthorities)
                            var authentication = new UsernamePasswordAuthenticationToken(
                                    usuario,
                                    null,
                                    usuario.getAuthorities() // <--- IMPORTANTE
                            );

                            // Força a autenticação no Spring Context
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            System.out.println("4. Autenticação setada no Contexto com sucesso para: " + usuario.getLogin());
                            System.out.println("   Autoridades: " + usuario.getAuthorities());
                        }
                    } else {
                        System.out.println("ERRO: Token válido, mas usuário '" + subject + "' NÃO existe no banco (pode ter sido deletado).");
                    }
                } else {
                    System.out.println("ERRO: tokenService.validarToken retornou NULL (Token inválido ou expirado).");
                }
            } catch (Exception e) {
                System.out.println("ERRO CRÍTICO ao validar token: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("AVISO: Nenhum token enviado no Header Authorization.");
        }

        System.out.println("--- FIM DO FILTRO (Passando para o próximo) ---");
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}