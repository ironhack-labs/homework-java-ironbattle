import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE IRONBATTLE!");

        while (true) {
            System.out.println("Select game mode:");
            System.out.println("1) Create characters");
            System.out.println("2) Create random characters");
            System.out.println("3) Exit");
            System.out.println("Write the number which matches your option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCharacters(scanner);
                    break;
                case 2:
                    createRandomCharacters();
                    break;
                case 3:
                    System.out.println("You chose to leave the game. Goodbye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createCharacters(Scanner scanner) {
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

    private static void createRandomCharacters() {
        // Generate random values for the first character
        String name1 = (Math.random() < 0.5 ? "Wizard" : "Warrior") + " (p. 1)";
        int health1 = (int) (Math.random() * 101) + 100; // between 100-200
        int manaOrStamina1 = (int) (Math.random() * 51) + 50; // between 50-100
        int strengthOrIntelligence1 = (int) (Math.random() * 11) + 5; // between 5-15

        // Generate random values for the second character
        String name2 = (Math.random() < 0.5 ? "Wizard" : "Warrior") + " (p. 2)";
        int health2 = (int) (Math.random() * 101) + 100; // between 100-200
        int manaOrStamina2 = (int) (Math.random() * 51) + 50; // between 50-100
        int strengthOrIntelligence2 = (int) (Math.random() * 11) + 5; // between 5-15

        // Create the characters
        Character character1;
        Character character2;

        // Create the first character
        if (name1.startsWith("Wizard")) {
            character1 = new Wizard(name1, health1, manaOrStamina1, strengthOrIntelligence1);
        } else {
            character1 = new Warrior(name1, health1, manaOrStamina1, strengthOrIntelligence1);
        }

        // Create the second character
        if (name2.startsWith("Wizard")) {
            character2 = new Wizard(name2, health2, manaOrStamina2, strengthOrIntelligence2);
        } else {
            character2 = new Warrior(name2, health2, manaOrStamina2, strengthOrIntelligence2);
        }

        // Start the battle
        BattleSimulator simulator = new BattleSimulator();
        simulator.battle(character1, character2);
    }
}