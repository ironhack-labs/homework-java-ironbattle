import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE IRONBATTLE!");

        System.out.println("Enter warrior's name: ");
        String warriorName = scanner.nextLine();
        System.out.println("Enter warrior's health points (between 100-200): ");
        int warriorHealth = Integer.parseInt(scanner.nextLine());
        int warriorStamina = 0;
        int warriorStrength = 0;

        System.out.println("Enter wizard's name: ");
        String wizardName = scanner.nextLine();
        System.out.println("Enter wizard's health points (between 100-200): ");
        int wizardHealth = Integer.parseInt(scanner.nextLine());
        int wizardMana = 0;
        int wizardIntelligence = 0;

        Warrior warrior = new Warrior(warriorName, warriorHealth, warriorStamina, warriorStrength);
        Wizard wizard = new Wizard(wizardName, wizardHealth, wizardMana, wizardIntelligence);

        BattleSimulator simulator = new BattleSimulator();
        simulator.battle(warrior, wizard);
    }
}