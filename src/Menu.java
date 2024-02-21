import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("⚔️ WELCOME TO THE IRONBATTLE! ⚔️ (by Anna de Pablo Puig)");

        while (true) {
            System.out.println("Select game mode:");
            System.out.println("1) Create characters");
            System.out.println("2) Create random characters");
            System.out.println("3) Import characters from CSV file");
            System.out.println("4) Exit");
            System.out.println("Write the number which matches your option: ");
                            
            int choice = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

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
                    importCharacters(scanner);
                    break;
                case 4:
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
        System.out.println("1) \uD83D\uDDE1\uFE0FWarrior");
        System.out.println("2) \uD83E\uDDD9\u200D\uFE0FWizard");
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
            choiceString = "\uD83D\uDDE1\uFE0FWarrior";
        } else {
            choiceString = "\uD83E\uDDD9\u200D\uFE0FWizard";
        }

        System.out.println("✒\uFE0FEnter player's name: ");
        String playerName = scanner.nextLine();
        playerName += " - " + choiceString;

        System.out.println("✒\uFE0FEnter player's health points (between 100-200): ");
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

    private static void importCharacters(Scanner scanner) {
        System.out.println("✒\uFE0FEnter the complete route of the CSV file to import characters from:");
        System.out.println("(Remember that the format of the information passed must be 'name,health,type')");
        String fileName = scanner.nextLine();

        // Read characters from the CSV file
        Character[] characters = readCharactersFromCSV(fileName);

        // Ensure correct number of characters in file
        if (characters.length != 2) {
            System.out.println("Invalid number of characters imported. Please ensure the CSV file contains exactly 2 characters.");
            return;
        }

        BattleSimulator simulator = new BattleSimulator();
        simulator.battle(characters[0], characters[1]);
    }

    private static Character[] readCharactersFromCSV(String fileName) {
        List<Character> characters = new ArrayList<>();

        int staminaOrMana = 0;
        int strengthOrIntelligence = 0;

        // Read CSV file
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(",");

                // Extract name,health,type
                String name = info[0];
                int health = Integer.parseInt(info[1]);
                String type = info[2];

                // Pass info to characters list
                if (health >= 100 && health <= 200 && (type.equals("Warrior") || type.equals("Wizard"))) {
                    characters.add(type.equals("Warrior") ?
                            new Warrior(name, health, staminaOrMana, strengthOrIntelligence) :
                            new Wizard(name, health, staminaOrMana, strengthOrIntelligence));
                } else {
                    System.out.println("Invalid character information: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }

        // Convert to array so it can be used in battle()
        return characters.toArray(new Character[0]);
    }
}
