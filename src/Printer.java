
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




    public static void asciiRoundStats(Character char1, Character char2, int Round) {
        //Validate type and Casting.

        String name1 = char1.getName();
        String name2 = char2.getName();
        int hp1 = char1.getHp();
        int hp2 = char2.getHp();
        boolean  char1IsAlive = char1.isAlive();
        boolean char2IsAlive = char2.isAlive();
        int att1 = char1 instanceof Warrior ? ((Warrior) char1).getStamina() : char1 instanceof Wizard ? (((Wizard) char1).getMana()): 0;
        int att2 = char2 instanceof Warrior ? ((Warrior) char2).getStamina() : char2 instanceof Wizard ? (((Wizard) char2).getMana()): 0;
        int att3 = char1 instanceof Warrior ? ((Warrior) char1).getStrength() : char1 instanceof Wizard ? (((Wizard) char1).getIntelligence()) : 0;
        int att4 = char2 instanceof Warrior ? ((Warrior) char2).getStrength() : char2 instanceof Wizard ? (((Wizard) char2).getIntelligence()) : 0;

        String roundStats = """
    ===========================================
    ||               Round %-4d              ||
    ||  %-12s         %-12s    ||
    ||  HP:    %-11d  HP:    %-10d||
    ||  atr1:  %-11d  atr1:  %-10d||                      \s
    ||  atr2:  %-11d  atr2:  %-10d||       \s
    ||  alive: %-10b   alive: %-10b||                                    \s
    ||                                       ||
    ===========================================
    """.formatted( Round, name1, name2, hp1, hp2, att1, att2, att3, att4, char1IsAlive, char2IsAlive);

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
                    break;
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
                    break;
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
                        break;
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
                        break;
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



