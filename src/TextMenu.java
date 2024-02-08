import java.util.Scanner;

public class TextMenu {
    public static void menu (){
        Scanner scanner = new Scanner(System.in);
        boolean finish = false;
        System.out.println(getIntroMenu());
        while (!finish) {
        }

    }
    private static String getIntroMenu (){
        String intro_menu =
                        "╔══════════════════════════════════════════════╗\n" +
                        "║      Welcome to the RPG Battle Simulator!    ║\n" +
                        "║                                              ║\n" +
                        "║ Get ready for an adrenaline-pumping battle   ║\n" +
                        "║ between two fierce warriors                  ║\n" +
                        "║ Let's find the ultimate victor.              ║\n" +
                        "║                                              ║\n" +
                        "║                                              ║\n" +
                        "║                                              ║\n" +
                        "║                                              ║\n" +
                        "╚══════════════════════════════════════════════╝";
        return intro_menu;
    }
}
