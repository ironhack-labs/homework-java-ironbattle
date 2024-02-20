import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE IRONBATTLE!");

        System.out.println("Enter warrior's name: ");
        String warriorName = scanner.nextLine();
        System.out.println("Enter warrior's health points: ");
        int warriorHealth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter warrior's stamina points: ");
        int warriorStamina = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter warrior's strength points: ");
        int warriorStrength = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter wizard's name: ");
        String wizardName = scanner.nextLine();
        System.out.println("Enter wizard's health points: ");
        int wizardHealth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter wizard's mana points: ");
        int wizardMana = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter wizard's intelligence points: ");
        int wizardIntelligence = Integer.parseInt(scanner.nextLine());

        Warrior warrior = new Warrior(warriorName, warriorHealth, warriorStamina, warriorStrength);
        Wizard wizard = new Wizard(wizardName, wizardHealth, wizardMana, wizardIntelligence);

        BattleSimulator simulator = new BattleSimulator();
        simulator.battle(warrior, wizard);
    }
}
