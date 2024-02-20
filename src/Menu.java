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
                    Character player1 = createCharacter(scanner, "1");
                    Character player2 = createCharacter(scanner, "2");
                    BattleSimulator simulator = new BattleSimulator();
                    simulator.battle(player1, player2);
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

    private static Character createCharacter(Scanner scanner, String playerType) {
        System.out.println("Choose character type for Player " + playerType + ":");
        System.out.println("1) Warrior");
        System.out.println("2) Wizard");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Check if choice is correct
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        // Name displays type
        String choiceString;
        if (choice == 1) {
            choiceString = "Warrior";
        } else {
            choiceString = "Wizard";
        }

        System.out.println("Enter player's name: ");
        String playerName = scanner.nextLine();
        playerName += " - " + choiceString;

        System.out.println("Enter player's health points (between 100-200): ");
        int playerHealth = Integer.parseInt(scanner.nextLine());

        int playerStaminaOrMana = 0;
        int playerStrengthOrIntelligence = 0;

        // Return warrior or wizard depending on choice
        return (choice == 1) ?
                new Warrior(playerName + " (p." + playerType + ")", playerHealth, playerStaminaOrMana, playerStrengthOrIntelligence) :
                new Wizard(playerName + " (p." + playerType + ")", playerHealth, playerStaminaOrMana, playerStrengthOrIntelligence);
    }

    private static void createRandomCharacters() {
        // Generate random values for the first character
        String name1 = (Math.random() < 0.5 ? "Wizard" : "Warrior") + " (p. 1)";
        int health1 = (int) (Math.random() * 101) + 100; // between 100-200
        int manaOrStamina1 = 0;
        int strengthOrIntelligence1 = 0;

        // Generate random values for the second character
        String name2 = (Math.random() < 0.5 ? "Wizard" : "Warrior") + " (p. 2)";
        int health2 = (int) (Math.random() * 101) + 100; // between 100-200
        int manaOrStamina2 = 0;
        int strengthOrIntelligence2 = 0;

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

        BattleSimulator simulator = new BattleSimulator();
        simulator.battle(character1, character2);
    }
}
