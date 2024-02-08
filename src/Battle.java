import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Battle!");


        System.out.println("Introduce a name for the warrior: ");
        String warriorName = scanner.nextLine();
        Warrior warrior = new Warrior(warriorName);
        System.out.println(warrior);


        /*
        System.out.println("Introduce a name for the wizard: ");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);
        */


    }
}
