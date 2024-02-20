
public  class Printer{

    public static void asciiWarriorChar() {
        System.out.println("              . ,");
        System.out.println("            <( .)>");
        System.out.println("             //'");
        System.out.println("            //                |||");
        System.out.println("         __//_   _,,,,,    \\_///|");
        System.out.println("        /___\\\\  (.  __\\_   \\_,_/");
        System.out.println("       / Q--\\'  |_o \\:::)  / |");
        System.out.println("      /.(|_______)\\___/___/-.|");
        System.out.println("      |  / /' \\ _  ~ \\_  /  /");
        System.out.println("      .---/__  \"\"\"\\_/\"\"_/--'");
        System.out.println("            /\\......./");
        System.out.println("           (_/_ _,,_/");
        System.out.println("            ;;;[X];__");
        System.out.println("           /# . ._) . )-----.");
        System.out.println("          /. . . .\\. /   , __>");
        System.out.println("   ((     | . . . .\\|__-( __/");
        System.out.println("           \\ . . . .\\   |__/");
        System.out.println("            ) .--., )  >Xxx");
        System.out.println("            //  _>)/    / X\\");
        System.out.println("           (/  __/     O  X\\");
        System.out.println("            / __/       \\ X\\");
        System.out.println("            |__/         `._\\  ))");
        System.out.println("            Xxx<");
        System.out.println("            / X\\");
        System.out.println("           O  X\\");
        System.out.println("            \\ X\\");
    }


        public static void asciiWizardChar() {
            System.out.println("'             .           .");
            System.out.println("                           o       '   o  .     '   . O");
            System.out.println("                        '   .   ' .   _____  '    .      .");
            System.out.println("                         .     .   .mMMMMMMMm.  '  o  '   .");
            System.out.println("                       '   .     .MMXXXXXXXXXMM.    .   ' ");
            System.out.println("                      .       . /XX77:::::::77XX\\ .   .   .");
            System.out.println("                         o  .  ;X7:::''''''':::7X;   .  '");
            System.out.println("                        '    . |::'.:'        '::| .   .  .");
            System.out.println("                           .   ;:.:.            :;. o   .");
            System.out.println("                        '     . \\'.:            /\\    '   .");
            System.out.println("                           .     `.':.        .'.  '    .");
            System.out.println("                         '   . '  .`-._____.-'   .  . '  .");
            System.out.println("                          ' o   '  .   O   .   '  o    '");
            System.out.println("                           . ' .  ' . '  ' O   . '  '   '");
            System.out.println("                            . .   '    '  .  '   . '  '");
            System.out.println("                             . .'..' . ' ' . . '.  . '");
            System.out.println("                              `.':.'        ':'.'.'");
            System.out.println("                                `\\_  |     _//'");
            System.out.println("                                  \\(  |\\    )/");
            System.out.println("                                  //\\ |_\\  /\\\\");
            System.out.println("                                 (/ /\\(\" )/\\ \\)");
            System.out.println("                                  \\/ (  ) \\/");
            System.out.println("                                     |(  )|");
            System.out.println("                                     | \\( \\");
            System.out.println("                                     |  )  \\");
            System.out.println("                                     |      \\");
            System.out.println("                                     |       \\");
            System.out.println("                                     |        `.__,");
            System.out.println("                                     \\_________.-'");
        }




    public static void asciiRoundStats(Character char1, Character char2) {

        //Validate type and Casting.
        String name1 = char1.getName();
        String name2 = char2.getName();
        int hp1 = char1.getHp();
        int hp2 = char2.getHp();
        boolean att1 = char1.isAlive();
        boolean att2 = char2.isAlive();
        int round = 2;

        // Ajustar la longitud máxima de los nombres y HP para mantener la alineación
        String roundStats = """
    ===========================================
    ==                Round%-4d              ==
    ==       %-12s        %-11s ==
    ==  HP:  %-11d    HP:  %-11d ==
    ==  at1: %-11s    at1: %-11s ==                        \s
    ==                                       ==
    ==                                       ==
    ==                                       ==
    ===========================================
    """.formatted( round, name1, name2, hp1, hp2, String.valueOf(att1), String.valueOf(att2) );

        System.out.println(roundStats);
    }

        public static void asciiWarriorAttack(String nameAttack) {
            switch (nameAttack) {
                case ("heavyAttack"):
                    String heavyAttack =
                            """
                                     ▄  █ ▄███▄   ██       ▄ ▀▄    ▄    \s
                                    █   █ █▀   ▀  █ █       █  █  █     \s
                                    ██▀▀█ ██▄▄    █▄▄█ █     █  ▀█      \s
                                    █   █ █▄   ▄▀ █  █  █    █  █       \s
                                       █  ▀███▀      █   █  █ ▄▀        \s
                                      ▀             █     █▐            \s
                                                   ▀      ▐             \s
                                    ██     ▄▄▄▄▀ ▄▄▄▄▀ ██   ▄█▄    █  █▀\s
                                    █ █ ▀▀▀ █ ▀▀▀ █    █ █  █▀ ▀▄  █▄█  \s
                                    █▄▄█    █     █    █▄▄█ █   ▀  █▀▄  \s
                                    █  █   █     █     █  █ █▄  ▄▀ █  █ \s
                                       █  ▀     ▀         █ ▀███▀    █  \s
                                      █                  █          ▀   \s
                                     ▀                  ▀               \s""";

                    System.out.println(heavyAttack);
                case ("weakAttack"):
                    String weakAttack =
                            """
                                      ▄ ▄   ▄███▄   ██   █  █▀          \s
                                     █   █  █▀   ▀  █ █  █▄█            \s
                                    █ ▄   █ ██▄▄    █▄▄█ █▀▄            \s
                                    █  █  █ █▄   ▄▀ █  █ █  █           \s
                                     █ █ █  ▀███▀      █   █            \s
                                      ▀ ▀             █   ▀             \s
                                                     ▀                  \s
                                    ██     ▄▄▄▄▀ ▄▄▄▄▀ ██   ▄█▄    █  █▀\s
                                    █ █ ▀▀▀ █ ▀▀▀ █    █ █  █▀ ▀▄  █▄█  \s
                                    █▄▄█    █     █    █▄▄█ █   ▀  █▀▄  \s
                                    █  █   █     █     █  █ █▄  ▄▀ █  █ \s
                                       █  ▀     ▀         █ ▀███▀    █  \s
                                      █                  █          ▀   \s
                                     ▀                  ▀               \s""";

                    System.out.println(weakAttack);
            }
        }

        public static void asciiWizardAttack(String nameAttack){

                switch (nameAttack) {
                    case ("fireBall"):
                        String asciiFireBall =
                                """
                                        ▄████  ▄█ █▄▄▄▄ ▄███▄   ███   ██   █    █    \s
                                        █▀   ▀ ██ █  ▄▀ █▀   ▀  █  █  █ █  █    █    \s
                                        █▀▀    ██ █▀▀▌  ██▄▄    █ ▀ ▄ █▄▄█ █    █    \s
                                        █      ▐█ █  █  █▄   ▄▀ █  ▄▀ █  █ ███▄ ███▄ \s
                                         █      ▐   █   ▀███▀   ███      █     ▀    ▀\s
                                          ▀        ▀                    █             \s
                                                                       ▀              \s
                                        ██     ▄▄▄▄▀ ▄▄▄▄▀ ██   ▄█▄    █  █▀          \s
                                        █ █ ▀▀▀ █ ▀▀▀ █    █ █  █▀ ▀▄  █▄█            \s
                                        █▄▄█    █     █    █▄▄█ █   ▀  █▀▄            \s
                                        █  █   █     █     █  █ █▄  ▄▀ █  █           \s
                                           █  ▀     ▀         █ ▀███▀    █            \s
                                          █                  █          ▀             \s
                                         ▀                  ▀                        \s""";

                        System.out.println(asciiFireBall);
                    case ("staffHit"):
                        String asciiStaffHit =
                                """
                                           ▄▄▄▄▄      ▄▄▄▄▀ ██   ▄████  ▄████   ▄  █ ▄█    ▄▄▄▄▀\s
                                          █     ▀▄ ▀▀▀ █    █ █  █▀   ▀ █▀   ▀ █   █ ██ ▀▀▀ █   \s
                                        ▄  ▀▀▀▀▄       █    █▄▄█ █▀▀    █▀▀    ██▀▀█ ██     █   \s
                                         ▀▄▄▄▄▀       █     █  █ █      █      █   █ ▐█    █    \s
                                                     ▀         █  █      █        █   ▐   ▀     \s
                                                              █    ▀      ▀      ▀              \s
                                                             ▀                                  \s
                                        ██     ▄▄▄▄▀ ▄▄▄▄▀ ██   ▄█▄    █  █▀                   \s
                                        █ █ ▀▀▀ █ ▀▀▀ █    █ █  █▀ ▀▄  █▄█                     \s
                                        █▄▄█    █     █    █▄▄█ █   ▀  █▀▄                     \s
                                        █  █   █     █     █  █ █▄  ▄▀ █  █                    \s
                                           █  ▀     ▀         █ ▀███▀    █                     \s
                                          █                  █          ▀                      \s
                                         ▀                  ▀                                  \s""";

                        System.out.println(asciiStaffHit);
                }
            }


        public static void asciiDead(){
            System.out.println("   ▓█████▄ ▓█████ ▄▄▄      ▓█████▄ ");
            System.out.println("   ▒██▀ ██▌▓█   ▀▒████▄    ▒██▀ ██▌");
            System.out.println("   ░██   █▌▒███  ▒██  ▀█▄  ░██   █▌");
            System.out.println("   ░▓█▄   ▌▒▓█  ▄░██▄▄▄▄██ ░▓█▄   ▌");
            System.out.println("   ░▒████▓ ░▒████▒▓█   ▓██▒░▒████▓ ");
            System.out.println("    ▒▒▓  ▒ ░░ ▒░ ░▒▒   ▓▒█░ ▒▒▓  ▒ ");
            System.out.println("    ░ ▒  ▒  ░ ░  ░ ▒   ▒▒ ░ ░ ▒  ▒ ");
            System.out.println("    ░ ░  ░    ░    ░   ▒    ░ ░  ░ ");
            System.out.println("      ░       ░  ░     ░  ░   ░    ");
            System.out.println("    ░                              ");
        }




    public static void countDown(int countDownPosition) {
        switch (countDownPosition) {
            case 3:
                String three =
                        """
                                   ▄▄▄▄▀ ▄  █ █▄▄▄▄ ▄███▄   ▄███▄  \s
                                ▀▀▀ █   █   █ █  ▄▀ █▀   ▀  █▀   ▀ \s
                                    █   ██▀▀█ █▀▀▌  ██▄▄    ██▄▄   \s
                                   █    █   █ █  █  █▄   ▄▀ █▄   ▄▀\s
                                  ▀        █    █   ▀███▀   ▀███▀  \s
                                          ▀    ▀                   \s
                                                                   \s
                                """;

                System.out.println(three);
                break;
            case 2:
                String two =
                        """
                                   ▄▄▄▄▀ ▄ ▄   ████▄\s
                                ▀▀▀ █   █   █  █   █\s
                                    █  █ ▄   █ █   █\s
                                   █   █  █  █ ▀████\s
                                  ▀     █ █ █       \s
                                         ▀ ▀        \s
                                                    \s
                                """;

                System.out.println(two);
                break;
            case 1:
                String one =
                        """
                                ████▄    ▄   ▄███▄  \s
                                █   █     █  █▀   ▀ \s
                                █   █ ██   █ ██▄▄   \s
                                ▀████ █ █  █ █▄   ▄▀\s
                                      █  █ █ ▀███▀  \s
                                      █   ██        \s
                                                    \s
                                """;

                System.out.println(one);
                break;
            default:
                String fight = """
                            ▄████  ▄█   ▄▀   ▄  █    ▄▄▄▄▀
                            █▀   ▀ ██ ▄▀    █   █ ▀▀▀ █  \s
                            █▀▀    ██ █ ▀▄  ██▀▀█     █  \s
                            █      ▐█ █   █ █   █    █   \s
                             █      ▐  ███     █    ▀    \s
                                              ▀          \s
                                                 
                         """;
                System.out.println(fight);
                break;
        }
    }

    public static void asciiWinner() {
        System.out.println(" ▄▀▀▄    ▄▀▀▄  ▄▀▀█▀▄    ▄▀▀▄ ▀▄  ▄▀▀▄ ▀▄  ▄▀▀█▄▄▄▄  ▄▀▀▄▀▀▀▄ ");
        System.out.println("█   █    ▐  █ █   █  █  █  █ █ █ █  █ █ █ ▐  ▄▀   ▐ █   █   █ ");
        System.out.println("▐  █        █ ▐   █  ▐  ▐  █  ▀█ ▐  █  ▀█   █▄▄▄▄▄  ▐  █▀▀█▀  ");
        System.out.println("  █   ▄    █      █       █   █    █   █    █    ▌   ▄▀    █  ");
        System.out.println("   ▀▄▀ ▀▄ ▄▀   ▄▀▀▀▀▀▄  ▄▀   █   ▄▀   █    ▄▀▄▄▄▄   █     █   ");
        System.out.println("         ▀    █       █ █    ▐   █    ▐    █    ▐   ▐     ▐   ");
        System.out.println("              ▐       ▐ ▐        ▐         ▐                ");
    }

}



