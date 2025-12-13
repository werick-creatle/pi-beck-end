package br.com.gamestore.loja_api.config;

import br.com.gamestore.loja_api.model.Carrinho;
import br.com.gamestore.loja_api.model.Jogo;
import br.com.gamestore.loja_api.model.Usuario;
import br.com.gamestore.loja_api.model.UsuarioRole;
import br.com.gamestore.loja_api.repositories.JogoRepository;
import br.com.gamestore.loja_api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TestConfig {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {

            // --- 1. POPULAR JOGOS ---
            // (Verifica se o banco já tem jogos, já que o deleteAll() está comentado)
            if (jogoRepository.count() == 0) {
                System.out.println(">>> Populando banco de dados com 24 jogos...");

                // Lista única com todos os 24 jogos (com quantidadeEstoque = 100)






                List<Jogo> jogosParaSalvar = Arrays.asList(
                        new Jogo(null, "Elden Ring", "RPG de ação em mundo aberto com exploração profunda e combates desafiadores.", new BigDecimal("149.99"), "PC", "RPG", "https://upload.wikimedia.org/wikipedia/pt/0/0d/Elden_Ring_capa.jpg", LocalDate.parse("2022-02-25"), 100),
                        new Jogo(null, "Baldurs Gate 3", "RPG tático com narrativa ramificada e combate por turnos baseado em D&D.", new BigDecimal("199.99"), "PC", "RPG", "https://m.media-amazon.com/images/I/71TGuDCUDrL._AC_UF1000,1000_QL80_.jpg", LocalDate.parse("2023-08-03"), 100),
                        new Jogo(null, "Grand Theft Auto V", "Ação e mundo aberto com múltiplos protagonistas e missões intensas em Los Santos.", new BigDecimal("74.99"), "PC", "Ação", "https://s2-techtudo.glbimg.com/0pWnkn7VrikxMEGjFQYWw6JAmC0=/0x0:300x371/600x0/smart/filters:gifv():strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/1/9/8cOmg9TkaB2PgkS1sUjQ/2013-04-02-gta5-capa-rockstar-.jpg", LocalDate.parse("2013-09-17"), 100),
                        new Jogo(null, "Red Dead Redemption 2", "Western épico com história emocional e mundo aberto altamente detalhado.", new BigDecimal("149.99"), "PS5", "Ação", "https://upload.wikimedia.org/wikipedia/pt/e/e7/Red_Dead_Redemption_2.png", LocalDate.parse("2018-10-26"), 100),
                        new Jogo(null, "Cyberpunk 2077", "RPG de ação em uma metrópole futurista com escolhas morais e personalização avançada.", new BigDecimal("74.99"), "PC", "RPG", "https://upload.wikimedia.org/wikipedia/pt/f/f7/Cyberpunk_2077_capa.png", LocalDate.parse("2020-12-10"), 100),
                        new Jogo(null, "The Witcher 3", "RPG de mundo aberto centrado em narrativa adulta, monstros e decisões impactantes.", new BigDecimal("39.99"), "PC", "RPG", "https://upload.wikimedia.org/wikipedia/pt/0/06/TW3_Wild_Hunt.png", LocalDate.parse("2015-05-19"), 100),
                        new Jogo(null, "Hogwarts Legacy", "RPG de ação ambientado no universo de Harry Potter com exploração de Hogwarts.", new BigDecimal("199.99"), "PC", "RPG", "https://upload.wikimedia.org/wikipedia/pt/5/5a/Hogwarts_Legacy_capa.jpeg", LocalDate.parse("2023-02-10"), 100),
                        new Jogo(null, "Resident Evil 4 Remake", "Remake em terceira pessoa com tensão de sobrevivência e ação intensa.", new BigDecimal("149.99"), "PS5", "Survival Horror", "https://img.elo7.com.br/product/main/494956D/quadro-decorativo-games-resident-evil-4-remake-games.jpg", LocalDate.parse("2023-03-24"), 100),
                        new Jogo(null, "Spider-Man (Miles Morales)", "Aventura de ação com movimentação ágil e combate acrobático em Nova York.", new BigDecimal("149.99"), "PS5", "Ação", "https://upload.wikimedia.org/wikipedia/pt/7/74/Spider-Man_Miles_Morales_capa.png", LocalDate.parse("2020-11-12"), 100),
                        new Jogo(null, "Forza Horizon 5", "Simulação arcade de corrida em mundo aberto com clima dinâmico e eventos diversos.", new BigDecimal("299.99"), "Xbox", "Corrida", "https://upload.wikimedia.org/wikipedia/pt/d/dc/Capa_de_Forza_Horizon_5.jpg", LocalDate.parse("2021-11-09"), 100),
                        new Jogo(null, "God of War Ragnarök", "Ação épica com combate visceral e narrativa focada em mitologia nórdica.", new BigDecimal("249.99"), "PS5", "Ação", "https://upload.wikimedia.org/wikipedia/pt/a/a5/God_of_War_Ragnar%C3%B6k_capa.jpg", LocalDate.parse("2022-11-09"), 100),
                        new Jogo(null, "Alan Wake 2 - Standard", "Thriller de terror psicológico com narrativa episódica e atmosfera sombria.", new BigDecimal("250.99"), "PC", "Survival Horror", "https://www.gamereactor.no/media/89/alanwake2_4028943b.jpg", LocalDate.parse("2023-10-27"), 100),
                        new Jogo(null, "Call of Duty: Black Ops 6", "FPS com campanhas cinematográficas e modos multiplayer competitivos.", new BigDecimal("89.99"), "PS5", "FPS", "https://t2.tudocdn.net/724564?w=1200&h=1200", LocalDate.parse("2025-11-10"), 100),
                        new Jogo(null, "Final Fantasy VII", "RPG clássico com história emocional, personagens icônicos e batalhas por turnos (Rebirth referência moderna).", new BigDecimal("199.99"), "PS5", "RPG", "https://image.api.playstation.com/vulcan/ap/rnd/202401/1809/f094b684796f1e7cd2ba10ea62e45f69b52b4782a38e2aa4.png", LocalDate.parse("1997-01-31"), 100),
                        new Jogo(null, "Diablo IV", "Action RPG com loot, dungeons e combate hack-and-slash intenso.", new BigDecimal("299.99"), "PC", "RPG", "https://store-images.s-microsoft.com/image/apps.27418.14058691289303304.7aeef6ea-ac74-41c2-a37d-5c5c1e0eb55d.e73f1084-51de-4266-8084-2f8787ae9c3f", LocalDate.parse("2023-06-06"), 100),
                        new Jogo(null, "Spider-Man Remastered", "Versão remasterizada com gráficos aprimorados e jogabilidade fluida.", new BigDecimal("149.99"), "PC", "Ação", "https://cdn1.epicgames.com/offer/4bc43145bb8245a5b5cc9ea262ffbe0e/EGS_MarvelsSpiderManRemastered_InsomniacGamesNixxesSoftware_S2_1200x1600-76424286902489f4d9639ac9b735c2b2", LocalDate.parse("2022-08-12"), 100),
                        new Jogo(null, "Astro Bot", "Plataforma criativa com fases pequenas, coletáveis e design encantador.", new BigDecimal("49.99"), "PS5", "Plataforma", "https://th.bing.com/th/id/R.28cc649ae8fa49bf84745d9dc66929b8?rik=2B105efGu1enXQ&pid=ImgRaw&r=0", LocalDate.parse("2018-10-02"), 100),
                        new Jogo(null, "Assassin's Creed", "Ação furtiva e exploração histórica em mundos abertos detalhados.", new BigDecimal("249.99"), "PC", "Ação", "https://external-preview.redd.it/new-assassins-creed-shadow-cover-art-revealed-with-new-v0--QWo8Jq9ynnP_jFbcpE64RYnBHThHH2h2eKipRXwnkQ.jpg?auto=webp&s=22e5423341b27dee3d91d3ffe7fd9eabad77d570", LocalDate.parse("2007-11-13"), 100),
                        new Jogo(null, "Doom: The Dark Ages", "FPS acelerado com ação intensa e ritmo frenético em ambientes sombrios.", new BigDecimal("99.99"), "PC", "FPS", "https://image.api.playstation.com/vulcan/ap/rnd/202501/1405/5a9411754439a02d29f43dc71e6a5a953a087111c863d381.png", LocalDate.parse("2025-01-15"), 100),
                        new Jogo(null, "Monster Hunter Wilds", "Ação cooperativa com caça a monstros gigantes e crafting profundo.", new BigDecimal("99.99"), "PS5", "Ação", "https://www.monsterhunter.com/wilds/assets/img/product/MHWilds_normal.png", LocalDate.parse("2024-01-26"), 100),
                        new Jogo(null, "Starfield", "RPG espacial com exploração de planetas, personalização e narrativa sci-fi.", new BigDecimal("299.99"), "PC", "RPG", "https://upload.wikimedia.org/wikipedia/pt/4/43/Capa_do_jogo_Starfield.jpg", LocalDate.parse("2023-09-06"), 100),
                        new Jogo(null, "Hollow Knight: Silksong", "Metroidvania com combate técnico e mundo atmosférico para explorar.", new BigDecimal("49.99"), "PC", "Metroidvania", "https://image.api.playstation.com/vulcan/ap/rnd/202508/2503/d975a2a2d80276d9891d8d3430fb8ec7ed2e4ad807707e76.png", LocalDate.parse("2025-08-22"), 100),
                        new Jogo(null, "Silent Hill f", "Survival horror centrado em atmosfera opressiva e mistério sobrenatural.", new BigDecimal("229.99"), "PS5", "Survival Horror", "https://cdn1.epicgames.com/spt-assets/6d34282a26c544df88ccc57505cdd2f0/silent-hill-f-1q1eg.jpg", LocalDate.parse("2024-11-02"), 100),
                        new Jogo(null, "FC26", "Simulador de futebol com modos de carreira e multiplayer competitivo.", new BigDecimal("349.99"), "PS5", "Esporte", "https://cdn.cdkeys.com/496x700/media/catalog/product/f/c/fc_26_ultimate.png", LocalDate.parse("2025-09-22"), 100),
                        new Jogo(null, "The last of us 2", "Aventura narrativa intensa sobre sobrevivência e relações humanas.", new BigDecimal("159.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/f/f4/The_Last_of_Us_Remastered.png", LocalDate.parse("2020-06-19"), 100),
                        new Jogo(null, "Metal Gear Solid Delta", "Reimaginação stealth com ênfase em infiltração e narrativa cinematográfica.", new BigDecimal("389.99"), "PS5", "Stealth", "https://image.api.playstation.com/vulcan/ap/rnd/202406/0513/826f1fca50b94407783d34055362d0aae870396e5289d427.png", LocalDate.parse("2024-02-15"), 100),
                        new Jogo(null, "Fable (Reboot)", "RPG de ação com humor e escolhas morais em um mundo fantástico.", new BigDecimal("49.99"), "Xbox", "RPG", "https://m.media-amazon.com/images/M/MV5BNzlmODAyODctZDYyNi00M2E0LWFmMmUtZmJmYzAzYzE2MjM3XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg", LocalDate.parse("2025-03-28"), 100),
                        new Jogo(null, "Marvel's Wolverine", "Ação visceral centrada em combate corpo a corpo com protagonista icônico.", new BigDecimal("99.99"), "PS5", "Ação", "https://assets-prd.ignimgs.com/2025/09/29/wolverine-1759178400808.jpg?crop=1%3A1%2Csmart&format=jpg&auto=webp&quality=80", LocalDate.parse("2025-09-29"), 100),
                        new Jogo(null, "Final Fantasy IX Remake", "RPG clássico reimaginado com gráficos modernos e combate renovado.", new BigDecimal("189.99"), "PS5", "RPG", "https://image.api.playstation.com/cdn/UP0082/CUSA08877_00/w5Qz9UKNBvTZBSRZlV2jeG2BLOJ1u7Jw.png", LocalDate.parse("2024-07-12"), 100),
                        new Jogo(null, "Ghost of Tsushima", "Ação samurai com mundo aberto e ênfase em combate com katana.", new BigDecimal("149.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/d/dc/Ghost_of_Tsushima_capa.png", LocalDate.parse("2020-07-17"), 100),
                        new Jogo(null, "Mortal Kombat 1", "Luta 1v1 com fatalities e elenco icônico, reboot da franquia.", new BigDecimal("199.99"), "PS5", "Luta", "https://upload.wikimedia.org/wikipedia/pt/9/9d/Mortal_Kombat_1_PS5_capa_digital.png", LocalDate.parse("2023-09-19"), 100),
                        new Jogo(null, "Minecraft", "Sandbox de construção e sobrevivência com mundos gerados proceduralmente.", new BigDecimal("79.99"), "PC", "Sandbox", "https://upload.wikimedia.org/wikipedia/pt/9/9c/Minecraft_capa.png", LocalDate.parse("2011-11-18"), 100),
                        new Jogo(null, "Valorant", "FPS tático com heróis e habilidades em partidas 5v5 competitivas.", new BigDecimal("0.00"), "PC", "FPS", "https://assets.xboxservices.com/assets/36/b5/36b52fa8-e71b-4435-888a-cecb98d3876a.jpg?n=153142244433_GLP-Page-Hero-0_1083x1222_02.jpg", LocalDate.parse("2020-06-02"), 100),
                        new Jogo(null, "Hades", "Roguelike com combate fluido, narrativa e progressão viciante.", new BigDecimal("49.99"), "PC", "Roguelike", "https://upload.wikimedia.org/wikipedia/pt/8/80/Hades_capa.jpg", LocalDate.parse("2020-09-17"), 100),
                        new Jogo(null, "Control Ultimate Edition", "Ação sobrenatural com design de níveis surreal e poderes telecinéticos.", new BigDecimal("49.99"), "PC", "Ação", "https://i.redd.it/h7qzlwl8jtg51.png", LocalDate.parse("2019-08-27"), 100),
                        new Jogo(null, "Sea of Thieves", "Aventura pirata cooperativa focada em exploração e combates navais.", new BigDecimal("99.99"), "PC", "Aventura", "https://upload.wikimedia.org/wikipedia/pt/9/9d/Sea_of_thieves_box.jpg", LocalDate.parse("2018-03-20"), 100),
                        new Jogo(null, "Hellblade: Senuas", "Aventura sombria que mistura combate e representação intensa de temas psicológicos.", new BigDecimal("49.99"), "PC", "Ação", "https://upload.wikimedia.org/wikipedia/pt/2/28/Hellblade_poster.jpg", LocalDate.parse("2017-08-08"), 100),
                        new Jogo(null, "Disco Elysium", "RPG focado em investigação, diálogos e escolhas filosóficas profundas.", new BigDecimal("79.99"), "PC", "RPG", "https://www.adrenaline.com.br/wp-content/uploads/2023/08/disco-elysium-the-final-cut-capa.jpg", LocalDate.parse("2019-10-15"), 100),
                        new Jogo(null, "Guardians of the Galaxy", "Aventura narrativa baseada em humor e combate em terceira pessoa.", new BigDecimal("79.99"), "PC", "Ação", "https://upload.wikimedia.org/wikipedia/pt/9/91/Guardians_of_the_Galaxy_capa.png", LocalDate.parse("2021-10-26"), 100),
                        new Jogo(null, "Sifu", "Beat 'em up com sistema de envelhecimento que altera gameplay e desafios.", new BigDecimal("99.99"), "PC", "Ação", "https://upload.wikimedia.org/wikipedia/pt/8/88/Sifu_capa.jpg", LocalDate.parse("2022-02-08"), 100),
                        new Jogo(null, "Hitman", "Simulação stealth com contratos e soluções criativas para assassinatos.", new BigDecimal("149.99"), "PC", "Stealth", "https://preview.redd.it/classic-styled-cover-for-the-modern-hitman-games-v0-g8rpjea5s2g81.png?width=600&format=png&auto=webp&s=b3fd10756937aae10ca1c6ecfcbd06a8625d8812", LocalDate.parse("2016-03-11"), 100),
                        new Jogo(null, "Lies of P", "RPG de ação inspirado em Pinóquio com combate punitivo e atmosfera sombria.", new BigDecimal("199.99"), "PC", "RPG", "https://www.europanet.com.br/upload/id_produto/60_____/6001002g.jpg", LocalDate.parse("2023-09-19"), 100),
                        new Jogo(null, "Tekken 8", "Jogo de luta com elenco variado e sistema técnico de combos.", new BigDecimal("249.99"), "PS5", "Luta", "https://upload.wikimedia.org/wikipedia/pt/b/b4/Tekken_8_cover_art.jpg", LocalDate.parse("2023-01-26"), 100),
                        new Jogo(null, "Gran Turismo 7", "Simulação de corrida com foco em realismo e extensa coleção de carros.", new BigDecimal("249.99"), "PS5", "Corrida", "https://upload.wikimedia.org/wikipedia/pt/d/d7/Gran_Turismo_7_capa.png", LocalDate.parse("2022-03-04"), 100),
                        new Jogo(null, "Microsoft Flight Simulator", "Simulador de voo com mapeamento realista do planeta e aeronaves detalhadas.", new BigDecimal("249.99"), "PC", "Simulação", "https://upload.wikimedia.org/wikipedia/pt/8/87/Microsoft_Flight_Simulator_2020.png", LocalDate.parse("2020-08-18"), 100),
                        new Jogo(null, "Gears 5", "Shooter em terceira pessoa com campanha cooperativa e multiplayer robusto.", new BigDecimal("79.99"), "Xbox", "Ação", "https://upload.wikimedia.org/wikipedia/pt/9/96/Gears_5_capa.jpeg", LocalDate.parse("2019-09-10"), 100),
                        new Jogo(null, "Halo Infinite", "FPS sci-fi com campanha e multiplayer que renovam a saga Master Chief.", new BigDecimal("149.99"), "Xbox", "FPS", "https://s2-ge.glbimg.com/hgj24eLzTOm5WcMh2gsJWPYibEU=/0x7:770x979/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2020/q/f/4xh4idQlWaQeyAhyDitQ/halo-infinite-capa-xbox-series-x.png", LocalDate.parse("2021-12-08"), 100),
                        new Jogo(null, "Ghostwire: Tokyo", "Ação sobrenatural com habilidades e exploração de uma Tóquio paranormal.", new BigDecimal("99.99"), "PC", "Ação", "https://upload.wikimedia.org/wikipedia/pt/6/6c/Ghostwire_Tokyo_capa.jpg", LocalDate.parse("2022-03-25"), 100),
                        new Jogo(null, "Deathloop", "FPS com loop temporal onde estratégia e experimentação são essenciais.", new BigDecimal("49.99"), "PC", "FPS", "https://upload.wikimedia.org/wikipedia/pt/e/e4/Deathloop_capa.jpg", LocalDate.parse("2021-09-14"), 100),
                        new Jogo(null, "Fortnite", "Battle royale gratuito com construção, atualizações constantes e eventos ao vivo.", new BigDecimal("0.00"), "PC", "Battle Royale", "https://m.media-amazon.com/images/I/51xv7dybv2L._AC_UF1000,1000_QL80_.jpg", LocalDate.parse("2017-07-25"), 100),
                        new Jogo(null, "Rocket League", "Futebol com carros: partidas rápidas, físicas arcade e competição online.", new BigDecimal("0.00"), "PC", "Esporte", "https://preview.redd.it/season-14-admiral-cover-car-v0-tjhex9ba2umc1.jpeg?auto=webp&s=827015d12ae8754baddfeef5163438d16ed514d4", LocalDate.parse("2015-07-07"), 100),
                        new Jogo(null, "Palworld", "Aventura com captura de criaturas, construção e survival em mundo aberto.", new BigDecimal("69.99"), "PC", "Aventura", "https://assets-prd.ignimgs.com/2024/01/19/palworld-1705691572614.jpg", LocalDate.parse("2024-01-19"), 100),
                        new Jogo(null, "Horizon Zero Dawn", "Ação em mundo aberto com caça a máquinas e protagonista carismática.", new BigDecimal("49.99"), "PS4", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202409/2716/16b33fa9a5c7285ba86a035b4a1c5f8eb430b407eae35ffd.png", LocalDate.parse("2017-02-28"), 100),
                        new Jogo(null, "Devil May Cry 5", "Hack-and-slash estiloso com combos elaborados e personagens carismáticos.", new BigDecimal("79.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/c/cb/Devil_May_Cry_5.jpg", LocalDate.parse("2019-03-08"), 100),
                        new Jogo(null, "No Mans Sky", "Exploração espacial procedimental com foco em descoberta e crafting.", new BigDecimal("99.99"), "PC", "Exploração", "https://upload.wikimedia.org/wikipedia/pt/5/5d/No_man_sky_cover.jpg", LocalDate.parse("2016-08-12"), 100),
                        new Jogo(null, "Metro Exodus", "Shooter narrativo com ênfase em sobrevivência e ambientes pós-apocalípticos.", new BigDecimal("49.99"), "PC", "Ação", "https://store-images.s-microsoft.com/image/apps.17469.65642028844779555.c518e652-fc85-4d6e-99a2-3e9ae1656a91.6cace333-df13-4178-a46d-5938de4654a2", LocalDate.parse("2019-02-15"), 100),
                        new Jogo(null, "It Takes Two", "Aventura cooperativa focada em resolução de puzzles e narrativa colaborativa.", new BigDecimal("99.99"), "PC", "Coop", "https://upload.wikimedia.org/wikipedia/pt/d/dd/It_Takes_Two_capa.jpg", LocalDate.parse("2021-03-26"), 100),
                        new Jogo(null, "A Way Out", "Aventura cooperativa narrativa sobre fuga e parceria entre dois jogadores.", new BigDecimal("59.99"), "PC", "Aventura", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwE-WAhypbIQLGtzV6Vi2xJU-_ZC9UTlyeFA&s", LocalDate.parse("2018-03-23"), 100),
                        new Jogo(null, "Dragons Dogma 2", "RPG de ação com foco em combates dinâmicos e sistema de seguidores (pawns).", new BigDecimal("299.99"), "PS5", "RPG", "https://upload.wikimedia.org/wikipedia/pt/c/c7/Dragon%27s_Dogma_2_cover_art.jpg", LocalDate.parse("2024-03-22"), 100),
                        new Jogo(null, "Persona 5 Royal", "JRPG com estilo, turnos táticos e rotina escolar combinada com dungeon crawling.", new BigDecimal("99.99"), "PS4", "RPG", "https://bdjogos.com.br/capas/16631-persona-5-royal-capa-1.jpg", LocalDate.parse("2020-03-31"), 100),
                        new Jogo(null, "Ghost Recon Wildlands", "Tiro tático em mundo aberto com foco em coop e planejamento de incursões.", new BigDecimal("49.99"), "PC", "Tático", "https://cdn1.epicgames.com/offer/hyacinth/GRW_StorePortrait_1200x1600_1200x1600-78b13dd96e208170ca3ed32b3034fcc2", LocalDate.parse("2017-03-07"), 100),
                        new Jogo(null, "Rainbow Six Siege", "FPS tático orientado a destruição, planejamento e jogo em equipe.", new BigDecimal("49.99"), "PC", "Tático", "https://notadogame.com/uploads/game/cover/250x/5bfdc3009ba9d.jpg", LocalDate.parse("2015-12-01"), 100),
                        new Jogo(null, "Far Cry 6", "FPS de mundo aberto com narrativa centrada em revolução e vilão carismático.", new BigDecimal("99.99"), "PC", "Ação", "https://upload.wikimedia.org/wikipedia/pt/d/df/Far_Cry_6_capa.jpg", LocalDate.parse("2021-10-07"), 100),
                        new Jogo(null, "Dying Light 2", "Parkour e combate em mundo pós-apocalíptico com escolhas que mudam o mundo.", new BigDecimal("149.99"), "PC", "Ação", "https://cdn1.epicgames.com/salesEvent/salesEvent/EGS_DyingLight2StayHuman_Techland_S4_1200x1600-b3d66b4576fd6488b674710e13493435", LocalDate.parse("2022-02-04"), 100),
                        new Jogo(null, "Star Wars Jedi", "Ação em terceira pessoa com combate com sabre de luz e narrativa Jedi.", new BigDecimal("199.99"), "PC", "Ação", "https://cdn.ome.lt/g5KuancFhrfRjhwcfANJl5u3SvY=/770x0/smart/uploads/conteudo/fotos/star-wars-jedi-fallen-order-capa-standar.jpeg", LocalDate.parse("2019-11-15"), 100),
                        new Jogo(null, "Dead Space Remake", "Remake de survival horror com atmosfera claustrofóbica e combate tenso.", new BigDecimal("199.99"), "PC", "Survival Horror", "https://preview.redd.it/i3agvdg9vlr91.jpg?auto=webp&s=11fa3eff9a7b1897f74588119b4f468536be8831", LocalDate.parse("2023-01-27"), 100),
                        new Jogo(null, "Little Nightmares II", "Plataforma atmosférica com puzzles e terror sutil em níveis criativos.", new BigDecimal("69.99"), "PC", "Plataforma", "https://m.media-amazon.com/images/M/MV5BZGRkNWU1YTctNDJkYi00NGI4LWFkMWUtYzJlZjkzYjM3ZWJlXkEyXkFqcGc@._V1_QL75_UY281_CR15,0,190,281_.jpg", LocalDate.parse("2021-02-11"), 100),
                        new Jogo(null, "Stray", "Aventura em terceira pessoa controlando um gato num mundo cyberpunk cheio de mistérios.", new BigDecimal("79.99"), "PC", "Aventura", "https://preview.redd.it/is-there-anywhere-i-can-commission-artwork-of-the-stray-v0-mpcdmptfkl3a1.jpg?width=499&format=pjpg&auto=webp&s=20a02c1a132422f9105d1af00ee4049bb9a59555", LocalDate.parse("2022-07-19"), 100),
                        new Jogo(null, "New World", "MMO de exploração e combate com economia player-driven em mundo aberto.", new BigDecimal("69.99"), "PC", "MMO", "https://upload.wikimedia.org/wikipedia/pt/8/8b/New_World_capa.jpg", LocalDate.parse("2021-09-28"), 100),
                        new Jogo(null, "Rust", "Survival multiplayer focado em PvP, construção e sobrevivência em servidor aberto.", new BigDecimal("69.99"), "PC", "Survival", "https://images.igdb.com/igdb/image/upload/t_cover_big/co6mrg.jpg", LocalDate.parse("2018-02-08"), 100),
                        new Jogo(null, "Fall Guys", "Party game multiplayer com minigames e corridas caóticas para muitos jogadores.", new BigDecimal("0.00"), "PC", "Party", "https://cdn1.epicgames.com/offer/50118b7f954e450f8823df1614b24e80/FGSS04_KeyArt_OfferImagePortrait_1200x1600_1200x1600-4bd46574e78464352e1f2c55714701f7", LocalDate.parse("2020-08-04"), 100),
                        new Jogo(null, "Cs2", "FPS competitivo com ênfase em precisão, economia e trabalho em equipe (Counter-Strike 2).", new BigDecimal("69.99"), "PC", "FPS", "https://upload.wikimedia.org/wikipedia/en/f/f2/CS2_Cover_Art.jpg", LocalDate.parse("2023-09-27"), 100),
                        new Jogo(null, "Business tour", "Jogo de tabuleiro digital com elementos de estratégia e multiplayer casual.", new BigDecimal("9.99"), "PC", "Tabuleiro", "https://cdn1.epicgames.com/spt-assets/04abfea7c3ed4387addbda6e3eb4da6e/business-tour--board-game-with-online-multiplayer-5v4jl.png", LocalDate.parse("2022-06-15"), 100),
                        new Jogo(null, "Liars Bar", "Jogo social de dedução e bluff com rounds rápidos e interação entre jogadores.", new BigDecimal("14.99"), "PC", "Party", "https://www.gamingfurever.com/media/reviews/photos/original/9c/a9/3d/LiarsBar-1-24-1734041424.png", LocalDate.parse("2023-05-10"), 100),
                        new Jogo(null, "Micro Work", "Jogo casual com desafios rápidos e progressão por tarefas curtas.", new BigDecimal("24.99"), "PC", "Casual", "https://notadogame.com/uploads/game/cover/250x/631ecafd04ce3.jpg", LocalDate.parse("2021-11-01"), 100),
                        new Jogo(null, "The Legend of Zelda", "Aventura épica em mundo aberto com exploração, puzzles e história clássica.", new BigDecimal("299.99"), "Nintendo Switch", "Aventura", "https://upload.wikimedia.org/wikipedia/pt/0/0f/Legend_of_Zelda_Breath_of_the_Wild_capa.png", LocalDate.parse("2017-03-03"), 100),
                        new Jogo(null, "Bloodborne", "Ação sombria estilo souls com combate punitivo e ambientação gótica.", new BigDecimal("149.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/2/29/Bloodborne_capa.png", LocalDate.parse("2015-03-24"), 100),
                        new Jogo(null, "Metroid Prime", "Aventura de tiro em primeira pessoa com exploração e upgrades clássicos.", new BigDecimal("149.99"), "Nintendo GameCube", "Aventura", "https://upload.wikimedia.org/wikipedia/pt/d/df/Metroid_Prime_capa.png", LocalDate.parse("2002-11-17"), 100),
                        new Jogo(null, "Super Mario Galaxy", "Plataforma 3D inovadora com gravidade criativa e design de fases memorável.", new BigDecimal("129.99"), "Wii", "Plataforma", "https://upload.wikimedia.org/wikipedia/pt/b/b1/Super_Mario_Galaxy_capa.png", LocalDate.parse("2007-11-01"), 100),
                        new Jogo(null, "Portal 2", "Puzzle em primeira pessoa com humor ácido e mecânicas de portais inteligentes.", new BigDecimal("5.99"), "PC", "Puzzle", "https://upload.wikimedia.org/wikipedia/pt/f/f9/Portal2cover.jpg", LocalDate.parse("2011-04-19"), 100),
                        new Jogo(null, "Persona 4 Golden", "JRPG com vida escolar, amizades e turnos táticos em dungeons cheias de personalidade.", new BigDecimal("49.99"), "PS Vita", "RPG", "https://bdjogos.com.br/capas/7530-min-persona-4-golden-capa-1.webp", LocalDate.parse("2012-06-14"), 100),
                        new Jogo(null, "Chrono Trigger", "RPG clássico com viagem no tempo, múltiplos finais e sistema de batalha fluido.", new BigDecimal("29.99"), "SNES", "RPG", "https://i.pinimg.com/736x/fb/9d/2f/fb9d2ff13be36fcd41bc9a3051dbb205.jpg", LocalDate.parse("1995-03-11"), 100),
                        new Jogo(null, "Half-Life 2", "FPS narrativo que revolucionou interatividade e física em jogos.", new BigDecimal("9.99"), "PC", "FPS", "https://upload.wikimedia.org/wikipedia/pt/thumb/2/25/Half-Life_2_cover.jpg/250px-Half-Life_2_cover.jpg", LocalDate.parse("2004-11-16"), 100),
                        new Jogo(null, "Celeste", "Plataforma desafiadora com design de níveis preciso e história emocional.", new BigDecimal("19.99"), "PC", "Plataforma", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMeD8fm87iT5ZjaWvFvsenh4JTI76D7lth6w&s", LocalDate.parse("2018-01-25"), 100),
                        new Jogo(null, "Returnal", "Roguelike de ação em terceira pessoa com narrativa cíclica e atmosfera sci-fi.", new BigDecimal("89.99"), "PS5", "Roguelike", "https://image.api.playstation.com/vulcan/ap/rnd/202011/1621/fYZQHZ42eXXUt7c6D5YjLrq5.png", LocalDate.parse("2021-04-30"), 100),
                        new Jogo(null, "Slay the Spire", "Deckbuilder roguelike com combinação estratégica de cartas e builds únicas.", new BigDecimal("29.99"), "PC", "Roguelike", "https://products.eneba.games/resized-products/bseLiuqzcPV5_1CDAS2FBaEAEHjmHSVBlqmnJoJs4MM_350x200_1x-0.jpeg", LocalDate.parse("2019-01-23"), 100),
                        new Jogo(null, "Civilization VI", "Turn-based strategy onde você guia uma civilização através dos tempos.", new BigDecimal("39.99"), "PC", "Estratégia", "https://upload.wikimedia.org/wikipedia/pt/3/3b/Civilization_VI_cover_art.jpg", LocalDate.parse("2016-10-21"), 100),
                        new Jogo(null, "Street Fighter 6", "Jogo de luta moderno com sistemas acessíveis e profundidade competitiva.", new BigDecimal("199.99"), "PS5", "Luta", "https://upload.wikimedia.org/wikipedia/pt/9/94/Street_Fighter_6_box_art.jpg", LocalDate.parse("2023-06-02"), 100),
                        new Jogo(null, "Inside", "Plataforma/puzzle com atmosfera sombria e narrativa ambiental intrigante.", new BigDecimal("9.99"), "PC", "Puzzle", "https://cdn1.epicgames.com/offer/13bb5776b9e1424d84ce42d9ba61c0ca/EGS_INSIDE_Playdead_S2_1200x1600-2753b8f312f8e0ac33f7a3d37c1eb242", LocalDate.parse("2016-06-29"), 100),
                        new Jogo(null, "Dragon Ball", "Jogo de luta baseado em famosa franquia com ataques espetaculares e personagens icônicos.", new BigDecimal("349.99"), "PS5", "Luta", "https://upload.wikimedia.org/wikipedia/pt/e/e4/Dragon_Ball_Z_Kakarot_logo.png", LocalDate.parse("2020-01-17"), 100),
                        new Jogo(null, "Demon Slayer", "Jogo de ação inspirado no anime com combates coreografados e cenários icônicos.", new BigDecimal("149.99"), "PS5", "Ação", "https://meups.com.br/wp-content/uploads/2021/10/Jogo-de-Demon-Slayer-4.jpg", LocalDate.parse("2021-10-15"), 100),
                        new Jogo(null, "God of War", "Ação narrativa centrada em combate visceral e mitologia nórdica/greco-romana.", new BigDecimal("129.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/8/82/God_of_War_2018_capa.png", LocalDate.parse("2018-04-20"), 100),
                        new Jogo(null, "Naruto", "Jogo de ação/aventura baseado na popular franquia de anime com lutas estilizadas.", new BigDecimal("199.99"), "PS4", "Luta", "https://bdjogos.com.br/capas/25543-naruto-ultimate-ninja-storm-capa-1.webp", LocalDate.parse("2019-03-29"), 100),
                        new Jogo(null, "Transformice", "Multiplayer casual focado em cooperação e minigames divertidos.", new BigDecimal("14.99"), "PC", "Casual", "https://notadogame.com/uploads/game/cover/250x/66da2ec3ccba7.jpg", LocalDate.parse("2010-05-01"), 100),
                        new Jogo(null, "Unturned", "Survival em blocos com foco em crafting, exploração e servidores PvP.", new BigDecimal("0.00"), "PC", "Survival", "https://preview.redd.it/unturned-cover-logo-and-background-v0-5kkdfir7z0m81.png?width=640&crop=smart&auto=webp&s=558d811d9d939fc254546cc4e3db86bff2c10b99", LocalDate.parse("2017-07-07"), 100),
                        new Jogo(null, "Animal Crossing", "Sim social relaxante com construção de vila, interação e eventos sazonais.", new BigDecimal("199.99"), "Nintendo Switch", "Simulação", "https://upload.wikimedia.org/wikipedia/pt/4/4a/Animal_Crossing_capa.png", LocalDate.parse("2020-03-20"), 100),
                        new Jogo(null, "Sekiro: Shadows Die Twice", "Ação desafiante com combate preciso e foco em parry e postura.", new BigDecimal("189.99"), "PS4", "Ação", "https://upload.wikimedia.org/wikipedia/pt/7/7b/Sekiro_Shadows_Die_Twice_capa.png", LocalDate.parse("2019-03-22"), 100),
                        new Jogo(null, "Divinity: Original Sin 2", "RPG tático com coop e liberdade total para abordagens criativas.", new BigDecimal("119.99"), "PC", "RPG", "https://image.api.playstation.com/cdn/UP3526/CUSA12611_00/A2Mt96jRTqaw5EtIwCHkUZXGpvqIZmSF.png", LocalDate.parse("2017-09-14"), 100),
                        new Jogo(null, "Outer Wilds", "Exploração espacial em loop temporal com foco em descoberta e mistério.", new BigDecimal("74.99"), "PC", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202208/1623/Zofebh60Ue7Zt5sC10UAtU3D.png", LocalDate.parse("2019-05-28"), 100),
                        new Jogo(null, "Roblox", "Plataforma de criação e jogos feitos por usuários com enorme variedade de experiências.", new BigDecimal("0.00"), "PC", "Plataforma", "https://i.pinimg.com/236x/26/f4/60/26f460a6a936754124c40b668a2026e4.jpg?nii=t", LocalDate.parse("2006-09-01"), 100),






                        // novos jogos XBOX
                        new Jogo(null, "Killing Floor 3", "Ação cooperativa intensa contra hordas mutantes em arenas cheias de tensão e estratégia.", new BigDecimal("24.99"), "Xbox", "Ação", "https://cdn1.epicgames.com/spt-assets/909dbdb5fabb4002bc0d3f0382be5361/killing-floor-3-odzi5.jpg", LocalDate.parse("2025-02-10"), 100),

                        new Jogo(null, "Mafia: The Old Country", "Drama criminal com escolhas duras, intrigas familiares e um mundo mafioso cheio de estilo.", new BigDecimal("299.99"), "Xbox", "Drama", "https://m.media-amazon.com/images/M/MV5BYzNjOWUxNjAtZTBhMi00ZjM3LTg5YWQtZTk1MzE5YjkzNTE2XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg", LocalDate.parse("2025-02-11"), 100),

                        new Jogo(null, "FragPunk", "Hero-shooter veloz com poderes únicos, partidas dinâmicas e reviravoltas em cada rodada.", new BigDecimal("20.99"), "Xbox", "Ação", "https://cdn1.epicgames.com/spt-assets/d66803a6d719483f8659cbffdf5c8204/fragpunk-q2ata.jpg", LocalDate.parse("2025-02-12"), 100),

                        new Jogo(null, "Echoes of the End", "Aventura narrativa com magia, mistério e decisões que transformam a jornada da protagonista.", new BigDecimal("239.99"), "Xbox", "Aventura", "https://m.media-amazon.com/images/M/MV5BMDI4ZGY3OTktZmM0NC00M2I2LWJlMzktYjczNDdkMmZmMzFjXkEyXkFqcGc@._V1_.jpg", LocalDate.parse("2025-02-13"), 100),

                        new Jogo(null, "Metal Eden", "Ação futurista com combates brutais e um mundo metálico dominado por máquinas hostis.", new BigDecimal("119.99"), "Xbox", "Ação", "https://upload.wikimedia.org/wikipedia/en/thumb/3/37/Metal_Eden_cover.png/250px-Metal_Eden_cover.png", LocalDate.parse("2025-02-14"), 100),

                        new Jogo(null, "Styx: Blades of Greed", "Furtividade tática com humor ácido, infiltração precisa e escolhas que moldam cada missão.", new BigDecimal("299.99"), "Xbox", "Stealth", "https://image.api.playstation.com/vulcan/ap/rnd/202509/0808/ed252cada24d0c52d87c1f41f75b7b02fdde36460254387e.jpg", LocalDate.parse("2025-02-15"), 100),

                        new Jogo(null, "RoboCop: Rogue City – Unfinished Business", "Tiro policial com decisões morais, lei nas ruas e uma Detroit tomada pelo crime.", new BigDecimal("179.99"), "Xbox", "Ação", "https://upload.wikimedia.org/wikipedia/pt/2/2e/RoboCop_Rogue_City.jpg", LocalDate.parse("2025-02-16"), 100),

                        new Jogo(null, "RENNSPORT", "Corridas realistas com física detalhada, precisão milimétrica e disputas de alta velocidade.", new BigDecimal("299.99"), "Xbox", "Corrida", "https://www.rennsport.gg/wp-content/uploads/2025/08/cover_1-1-V2-748x1024.png", LocalDate.parse("2025-02-17"), 100),

                        new Jogo(null, "Ninja Gaiden 4", "Ação frenética com combates desafiadores, combos acrobáticos e uma narrativa cheia de honra.", new BigDecimal("329.99"), "Xbox", "Ação", "https://cms-assets.xboxservices.com/assets/c2/3f/c23f3b16-039d-4478-ad8d-48a853609693.jpg?n=4990200040_Product-Placement-0_2_780x1170.jpg", LocalDate.parse("2025-02-18"), 100),

                        new Jogo(null, "The Outer Worlds 2", "RPG espacial com humor satírico, escolhas importantes e facções cheias de personalidade.", new BigDecimal("419.99"), "Xbox", "RPG", "https://upload.wikimedia.org/wikipedia/en/d/d9/The_Outer_Worlds_2_cover_art.png", LocalDate.parse("2025-02-19"), 100),

                        new Jogo(null, "Like a Dragon: Pirate Yakuza in Hawaii", "Ação excêntrica com humor absurdo, batalhas estilosas e viagens caóticas pelas ilhas.", new BigDecimal("359.99"), "Xbox", "Ação", "https://cdn.awsli.com.br/600x700/2739/2739953/produto/308581671/ladpyih_vertical_cover-a7ryen8k51.jpg", LocalDate.parse("2025-02-20"), 100),

                        new Jogo(null, "Civilization VII", "Estratégia por turnos com decisões históricas, expansão de impérios e diplomacia profunda.", new BigDecimal("299.99"), "Xbox", "Estratégia", "https://meups.com.br/wp-content/uploads/2025/03/Civilization-VII-1.png", LocalDate.parse("2025-02-21"), 100),

                        new Jogo(null, "Judas", "FPS narrativo com escolhas intensas, relações complicadas e tensão a cada zona explorada.", new BigDecimal("359.99"), "Xbox", "FPS", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzWQey3w3iSqNq_ypc2DvrbTOpWsykKcfqGA&s", LocalDate.parse("2025-02-23"), 100),

                        new Jogo(null, "MindsEye", "Thriller futurista com mistérios conspiratórios, ação cinemática e decisões psicológicas.", new BigDecimal("389.99"), "Xbox", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202503/1215/627007fb0f5fff02265c0ca5bc14f1edc80174276d30ed0b.png", LocalDate.parse("2025-02-24"), 100),

                        new Jogo(null, "Pipistrello and the Cursed Yoyo", "Aventura leve com humor criativo, quebra-cabeças mágicos e um yoyo encantado cheio de truques.", new BigDecimal("149.99"), "Xbox", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202503/1118/4d78b379dc808231cbb67911fecf85d21fece22ef9e3662c.jpg", LocalDate.parse("2025-02-25"), 100),

                        new Jogo(null, "Judas (Edição Deluxe)", "Ação narrativa imersiva, dilemas morais e conteúdo extra que aprofunda o universo do jogo.", new BigDecimal("449.99"), "Xbox", "FPS", "https://upload.wikimedia.org/wikipedia/pt/9/9b/Judas_capa.jpg", LocalDate.parse("2025-02-26"), 100),

                        new Jogo(null, "State of Decay 3", "Sobrevivência estratégica com decisões difíceis, comunidades frágeis e um mundo brutal.", new BigDecimal("399.99"), "Xbox", "Sobrevivência", "https://notadogame.com/uploads/game/cover/250x/5f1c629bd2d6e.jpg", LocalDate.parse("2025-02-27"), 100),

                        new Jogo(null, "Gears of War: Reloaded (Remaster)", "Ação tática com combates pesados, narrativa militar intensa e cenários devastados pela guerra.", new BigDecimal("299.99"), "Xbox", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202504/2818/6222f35e03490b9ab85092005f6c4843af9f18fba47bdab9.png", LocalDate.parse("2025-02-28"), 100),

                        new Jogo(null, "Civilization VII Expansion", "Expansão estratégica com novas civilizações e mecânicas adicionais.", new BigDecimal("199.99"), "Xbox", "Estratégia", "https://assets.2k.com/1a6ngf98576c/4OxRFSWejBQcdZlNXQb52L/c972995d2a04d605e5204a007ebf46f1/Desktop_Retail_FOBs_425x535_Founders.png", LocalDate.parse("2025-02-27"), 100),

                        new Jogo(null, "High on Life 2", "Ação com humor insano, armas falantes e decisões absurdas em um universo totalmente caótico.", new BigDecimal("279.99"), "Xbox", "Ação", "https://m.media-amazon.com/images/I/81QBqz+bqRL._UF1000,1000_QL80_.jpg", LocalDate.parse("2025-02-27"), 100),







                        //jogos playstation
                        new Jogo(null, "Ghost of Yōtei", "Aventura samurai exclusiva do PS5, com combate intenso e narrativa cinematográfica no Monte Yōtei.", new BigDecimal("399.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202504/2116/395b45219557497b6580e4ce372f8dea604ee5dd16f45da5.png", LocalDate.parse("2025-05-01"), 100),

                        new Jogo(null, "Digimon Story: Time Stranger", "JRPG com viagens no tempo, batalhas estratégicas e evolução clássica dos Digimon.", new BigDecimal("299.99"), "PS5", "RPG", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnOxa-tTCWekWIFfZRFdrGusiiVNOoznXiMQ&s", LocalDate.parse("2025-05-02"), 100),

                        new Jogo(null, "Days Gone Remastered", "Versão aprimorada do clássico de sobrevivência com gráficos atualizados e melhorias de desempenho.", new BigDecimal("259.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202502/1302/ce619ea43efc092af9e013b5dcb5c904987a7dab1a68b262.jpg", LocalDate.parse("2025-05-03"), 100),

                        new Jogo(null, "The Midnight Walk", "Aventura sombria com mistério psicológico e exploração guiada pela atmosfera do desconhecido.", new BigDecimal("349.99"), "PS5", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202409/1110/5bdf8506e4446c202b8ebf1f4b7b648149a6a07c5d8aae77.jpg", LocalDate.parse("2025-05-04"), 100),

                        new Jogo(null, "Stellar Blade", "Ação sci-fi intensa com combate fluido, chefes colossais e visual futurista de tirar o fôlego.", new BigDecimal("399.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202401/2211/52f53150c45b4e602695bec1a4ce855e4613c0626081ab20.jpg", LocalDate.parse("2025-04-05"), 100),

                        new Jogo(null, "Mafia: The Old Country", "Drama criminal com escolhas duras, intrigas familiares e uma ambientação mafiosa impecável.", new BigDecimal("299.99"), "PS5", "Drama", "https://m.media-amazon.com/images/M/MV5BYzNjOWUxNjAtZTBhMi00ZjM3LTg5YWQtZTk1MzE5YjkzNTE2XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg", LocalDate.parse("2025-04-06"), 100),

                        new Jogo(null, "Lost Soul Aside", "RPG de ação estiloso com combate veloz, cenários fantásticos e narrativa épica.", new BigDecimal("429.99"), "PS5", "RPG", "https://m.media-amazon.com/images/M/MV5BZTgyMjljYjEtNjc0OC00MGM3LTlmMjQtYTYzMWIzNjAzNjgyXkEyXkFqcGc@._V1_.jpg", LocalDate.parse("2025-04-07"), 100),

                        new Jogo(null, "Hell is Us", "Aventura narrativa em um mundo devastado, focada em mistério, emoção e combate tenso.", new BigDecimal("339.99"), "PS5", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202505/1909/3e387e59545ff37d4312cef4c0d25d6eee3156e003b3eded.jpg", LocalDate.parse("2025-07-05"), 100),

                        new Jogo(null, "Octopath Traveler 0", "JRPG por turnos com oito protagonistas, múltiplos caminhos e visual clássico moderno.", new BigDecimal("299.99"), "PS5", "RPG", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk3NezRctGBWe-6DfnOZYyixy2wLq5yUhSKw&s", LocalDate.parse("2025-06-21"), 100),

                        new Jogo(null, "Killing Floor 3", "Coop frenético contra hordas mutantes com armas devastadoras e progressão estratégica.", new BigDecimal("249.99"), "PS5", "Ação", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3l6iqfhwTIP1kxBXEY5ugI3fH2vuW8tB-eg&s", LocalDate.parse("2025-02-10"), 100),

                        new Jogo(null, "Metal Eden", "Ação futurista intensa com máquinas hostis e um mundo metálico brutal.", new BigDecimal("119.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202501/1516/5a59526a26d03ce67695c0856e6816a0e9a5f5e0127e4868.png", LocalDate.parse("2025-05-11"), 100),

                        new Jogo(null, "Ninja Gaiden 4", "Hack-and-slash insano com combates acrobáticos e desafios de alta dificuldade.", new BigDecimal("329.99"), "PS5", "Ação", "https://cdn.awsli.com.br/600x700/2739/2739953/produto/356601380/26832-ninja-gaiden-4-capa-1-gjna7qcqlc.webp", LocalDate.parse("2025-09-10"), 100),

                        new Jogo(null, "RENNSPORT", "Simulação de corrida realista com física avançada e competições de alta precisão.", new BigDecimal("299.99"), "PS5", "Corrida", "https://www.rennsport.gg/wp-content/uploads/2025/08/cover_1-1-V2-748x1024.png", LocalDate.parse("2025-07-05"), 100),

                        new Jogo(null, "RoboCop: Rogue City – Unfinished Business", "FPS policial com moralidade, combate tático e uma Detroit dominada pelo crime.", new BigDecimal("179.99"), "PS5", "FPS", "https://cdn1.epicgames.com/offer/3a5c77a536854024add2714cbd0fa865/EGS_RoboCopRogueCity_Teyon_S2_1200x1600-3e666124c2088c599e35700623bef464", LocalDate.parse("2025-02-27"), 100),

                        new Jogo(null, "FragPunk", "Hero shooter tático com cartas de mutação, ação rápida e habilidades únicas por herói.", new BigDecimal("20.99"), "PS5", "Ação", "https://cdn1.epicgames.com/spt-assets/d66803a6d719483f8659cbffdf5c8204/fragpunk-q2ata.jpg", LocalDate.parse("2025-04-05"), 100),

                        new Jogo(null, "Blades of Fire", "Ação fantasia com combates elementais, monstros lendários e um mundo épico.", new BigDecimal("349.99"), "PS5", "Ação", "https://upload.wikimedia.org/wikipedia/en/7/7b/Blades_of_Fire_cover_art.jpg", LocalDate.parse("2025-05-28"), 100),

                        new Jogo(null, "MindsEye", "Thriller futurista com conspirações, ação cinematográfica e escolhas psicológicas.", new BigDecimal("389.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202503/1215/627007fb0f5fff02265c0ca5bc14f1edc80174276d30ed0b.png", LocalDate.parse("2025-09-04"), 100),

                        new Jogo(null, "Pipistrello and the Cursed Yoyo", "Aventura criativa com humor leve, quebra-cabeças mágicos e um ioiô encantado.", new BigDecimal("149.99"), "PS5", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202503/1118/4d78b379dc808231cbb67911fecf85d21fece22ef9e3662c.jpg", LocalDate.parse("2025-03-14"), 100),

                        new Jogo(null, "Octopath Traveler 0: Deluxe Edition", "Edição premium com conteúdos extras, artes exclusivas e itens adicionais.", new BigDecimal("449.99"), "PS5", "RPG", "https://image.api.playstation.com/vulcan/ap/rnd/202505/2109/667049fe0b016e1c9e3172dd1b0df28c8babfda5ab281a3b.png", LocalDate.parse("2025-07-02"), 100),

                        new Jogo(null, "Tides of Annihilation", "Ação sombria em um mundo consumido por forças ancestrais, exclusivo para PS5.", new BigDecimal("359.99"), "PS5", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202501/2008/9e421ef33a521be60004a66fbbfd0f064e77130cbf42ba0c.png", LocalDate.parse("2025-12-05"), 100),








                        //Novos jogos lançamentos

                        new Jogo(null, "Elden Ring: Nightreign", "Expansão sombria e cooperativa dentro do universo brutal de Elden Ring, trazendo novos chefes e áreas amaldiçoadas.", new BigDecimal("399.99"), "PC / PS5 / Xbox Series", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202501/2901/9ff4b9fde2b7dce20fa282961454b7a81695d598eb5c7404.png", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Monster Hunter Wilds", "RPG de ação em mundo aberto com ecossistemas vivos, criaturas colossais e caçadas dinâmicas.", new BigDecimal("349.99"), "PC / PS5 / Xbox Series", "RPG", "https://upload.wikimedia.org/wikipedia/en/thumb/5/52/Monster_Hunter_Wilds_cover.png/250px-Monster_Hunter_Wilds_cover.png", LocalDate.parse("2026-10-02"), 100),

                        new Jogo(null, "Doom: The Dark Ages", "FPS medieval frenético, com brutalidade extrema, armas colossais e monstros infernais.", new BigDecimal("299.99"), "PC / PS5 / Xbox Series", "FPS", "https://image.api.playstation.com/vulcan/ap/rnd/202501/1405/5a9411754439a02d29f43dc71e6a5a953a087111c863d381.png", LocalDate.parse("2026-10-03"), 100),

                        new Jogo(null, "WWE 2K25", "Simulação de wrestling com novos modos, arenas e movimentos realistas.", new BigDecimal("299.99"), "PC / PS5 / Xbox Series", "Esporte", "https://assets.2k.com/1a6ngf98576c/p5GhY4Jg8w4ZD5oSY0gTL/01a0a23f86c88d21b54f2b7f1ea231bc/W2K_KEY_DlxEd_KA_Vert_20x24_BLEED_216_F1.jpg", LocalDate.parse("2026-10-04"), 100),

                        new Jogo(null, "High on Life 2", "Ação insana com armas falantes, humor absurdo e mundos extraterrestres vibrantes.", new BigDecimal("279.99"), "PC / PS5 / Xbox Series", "Ação", "https://m.media-amazon.com/images/I/81QBqz+bqRL._UF1000,1000_QL80_.jpg", LocalDate.parse("2026-10-05"), 100),

                        new Jogo(null, "Metal Eden", "FPS sci-fi com parkour, cidades futuristas e combate veloz contra máquinas hostis.", new BigDecimal("249.99"), "PC / PS5 / Xbox Series", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202501/1516/5a59526a26d03ce67695c0856e6816a0e9a5f5e0127e4868.png", LocalDate.parse("2026-10-05"), 100),

                        new Jogo(null, "Marvel Cosmic Invasion", "Beat ’em up colorido com heróis Marvel, combos devastadores e ação cooperativa.", new BigDecimal("219.99"), "PC / PS5 / Xbox Series", "Ação", "https://upload.wikimedia.org/wikipedia/pt/thumb/7/72/Marvel_Cosmic_Invasion_cover_art.jpg/250px-Marvel_Cosmic_Invasion_cover_art.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Lost Soul Aside", "RPG de ação estiloso com combate ágil, monstros gigantes e estética cinematográfica.", new BigDecimal("399.99"), "PC / PS5 / Xbox Series", "RPG", "https://m.media-amazon.com/images/M/MV5BZTgyMjljYjEtNjc0OC00MGM3LTlmMjQtYTYzMWIzNjAzNjgyXkEyXkFqcGc@._V1_.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "NASCAR 25", "Simulação de corrida intensa com física aprimorada e campeonatos oficiais.", new BigDecimal("259.99"), "PC / PS5 / Xbox Series", "Corrida", "https://upload.wikimedia.org/wikipedia/en/thumb/1/1b/NASCAR_25_Cover_Art.jpg/250px-NASCAR_25_Cover_Art.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Hell is Us", "Aventura narrativa em um país devastado por guerra e criaturas misteriosas.", new BigDecimal("289.99"), "PC / PS5 / Xbox Series", "Aventura", "https://image.api.playstation.com/vulcan/ap/rnd/202505/1909/3e387e59545ff37d4312cef4c0d25d6eee3156e003b3eded.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Borderlands 4", "Looter-shooter caótico com humor, armas absurdas e cooperativo frenético.", new BigDecimal("349.99"), "PC / PS5 / Xbox Series", "Ação", "https://cdn1.epicgames.com/spt-assets/20d989fc07a447b2af3c59e4fd5f49c7/borderlands-4-fnnpo.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Shinobi: Art of Vengeance", "Plataforma ninja retrô com combate rápido e estética clássica modernizada.", new BigDecimal("149.99"), "PC / PS5 / Xbox Series", "Ação", "https://upload.wikimedia.org/wikipedia/en/0/0e/Shinobi_Art_of_Vengeance_Cover.webp", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "F1 25", "Simulação de Fórmula 1 com gráficos realistas e performance de nova geração.", new BigDecimal("349.99"), "PC / PS5 / Xbox Series", "Corrida", "https://image.api.playstation.com/vulcan/ap/rnd/202505/1521/73fc6fb9bad1b2e74180c166f0c7af9d3940e0d6a6e01525.png", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Assassin’s Creed Shadows", "Aventura no Japão feudal com ninjas, samurais e mundo aberto detalhado.", new BigDecimal("399.99"), "PC / PS5 / Xbox Series", "Ação", "https://image.api.playstation.com/vulcan/ap/rnd/202404/1815/33f39cad34ac468a040ffed5a43149fb4329ec6c73326838.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "EA Sports FC 26", "Simulação de futebol com IA aprimorada, ligas oficiais e jogabilidade refinada.", new BigDecimal("349.99"), "PC / PS5 / Xbox Series", "Esporte", "https://cdn1.epicgames.com/offer/1d4d85b1051e41ee8f1a099e99d59f3f/EGS_EASPORTSFC26StandardEdition_EACANADA_S2_1200x1600-effee280c00b9890a0c5249d4b0e5c97", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Cronos: The New Dawn", "RPG de fantasia com exploração, criaturas míticas e batalhas estratégicas.", new BigDecimal("269.99"), "PC / PS5 / Xbox Series", "RPG", "https://image.api.playstation.com/vulcan/ap/rnd/202410/1511/b60b574c32546f9b5d263b1b38a541abe35e250797f18bde.jpg", LocalDate.parse("2026-10-01"), 100),

                        new Jogo(null, "Tony Hawk’s Pro Skater 3+4 (Remaster)", "Skate clássico com visuais modernos, trilha icônica e manobras lendárias.", new BigDecimal("299.99"), "PS5", "Esporte", "https://image.api.playstation.com/vulcan/ap/rnd/202502/2101/322f386a7ffa30527e27e60a04e80016fa6c692dd339962a.jpg", LocalDate.parse("2026-10-01"), 100)




                );













                jogoRepository.saveAll(jogosParaSalvar);
                System.out.println(">>> BANCO DE DADOS POPULADO COM 24 JOGOS! <<<");
            } else {
                System.out.println(">>> BANCO DE JOGOS JÁ POSSUI DADOS. <<<");
            }

            // --- 2. CRIAR USUÁRIO ADMIN ---
            System.out.println(">>> Verificando/Criando usuário ADMIN padrão...");
            if (usuarioRepository.findByLogin("admin@gamestore.com") == null) {
                String senhaAdminCriptografada = passwordEncoder.encode("admin1G23");

                // Cria o admin com carrinho nulo (como eu fiz no AuthController)
                Usuario admin = new Usuario(
                        null,
                        "admin@gamestore.com",
                        senhaAdminCriptografada,
                        UsuarioRole.ADMIN,
                        "Administrador da Loja",
                        LocalDate.parse("2000-01-01"),
                        null
                );

                // Cria e "amarra" o carrinho
                Carrinho carrinhoAdmin = new Carrinho(admin);
                admin.setCarrinho(carrinhoAdmin);

                usuarioRepository.save(admin);
                System.out.println("Usuário administrador cadastrado com sucesso (Login: admin@gamestore.com, Senha: admin1G23)");
            } else {
                System.out.println("Usuário admin (admin@gamestore.com) já existe");
            }
        };
    }
}