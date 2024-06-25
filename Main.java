import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Warrior: ");
        String warriorName = scanner.nextLine();
        Warrior warrior = new Warrior(warriorName);

        System.out.println("Enter name for Wizard: ");
        String wizardName = scanner.nextLine();
        Wizard wizard = new Wizard(wizardName);

        System.out.println("\nBattle Start!");

        while (warrior.isAlive() && wizard.isAlive()) {
            System.out.println("\n" + warrior.getName() + " Hp: " + warrior.getHp() + ", Stamina: " + warrior.getStamina()) ;
            System.out.println(wizard.getName() + " Hp: " + wizard.getHp() + ", Mana: " + wizard.getMana());

            warrior.attack(wizard);
            wizard.attack(warrior);

        }

        if (warrior.isAlive() && !wizard.isAlive()) {
            System.out.println("\n" + warrior.getName() + "wins!");
        } else if (!warrior.isAlive() && wizard.isAlive()) {
            System.out.println("\nIt's a tie! Restarting battle...\n");
            main(args);
        }
    }
}