import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Character player1;
    static Character player2;

    static BattleEngine engine = new BattleEngine();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== BATTLE SIMULATOR =====");
            System.out.println("1. Create Warrior");
            System.out.println("2. Create Wizard");
            System.out.println("3. Start Battle");
            System.out.println("4. Random Simulation");
            System.out.println("5. Import from CSV");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("[!] Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> createCharacter("Warrior");
                case 2 -> createCharacter("Wizard");
                case 3 -> {
                    if (player1 == null || player2 == null) {
                        System.out.println("\n[!] You must create both characters first!");
                    } else {
                        engine.startBattle(player1, player2);
                    }
                }
                case 4 -> randomSimulation();
                case 5 -> importFromCSV();
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("[!] Invalid option!");
            }
        }
    }

    private static void importFromCSV() {
        System.out.print("Enter the name of the CSV file (e.g., characters.csv): ");
        String fileName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length < 5) {
                    System.out.println("[!] Skipping invalid line: " + line);
                    continue;
                }

                String type = data[0].trim();
                String name = data[1].trim();
                int stat1 = Integer.parseInt(data[2].trim());
                int stat2 = Integer.parseInt(data[3].trim());
                int stat3 = Integer.parseInt(data[4].trim());

                if (type.equalsIgnoreCase("Warrior")) {
                    assignCharacter(new Warrior(name, stat1, stat2, stat3));
                    count++;
                } else if (type.equalsIgnoreCase("Wizard")) {
                    assignCharacter(new Wizard(name, stat1, stat2, stat3));
                    count++;
                } else {
                    System.out.println("[!] Unknown character type: " + type);
                }

                if (count == 2) {
                    System.out.println("Two characters imported. Stopping read process.");
                    break;
                }
            }

            System.out.println("\n*** Import finished successfully! ***");

        } catch (Exception e) {
            System.out.println("[!] Error reading file: " + e.getMessage());
            System.out.println("Make sure the file exists and is in the correct directory.");
        }
    }

    private static int getValidInput(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");
            try {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("[!] Error: Value must be between " + min + " and " + max + "!");
                }
            } catch (Exception e) {
                System.out.println("[!] Error: Please enter a valid number!");
                scanner.nextLine();
            }
        }
        return value;
    }

    private static void createCharacter(String type) {
        System.out.print("Enter name for " + type + ": ");
        String name = scanner.nextLine();

        if (type.equals("Warrior")) {
            int hp = getValidInput("Enter HP", 100, 200);
            int stamina = getValidInput("Enter Stamina", 10, 50);
            int strength = getValidInput("Enter Strength", 1, 10);
            assignCharacter(new Warrior(name, hp, stamina, strength));
        } else if (type.equals("Wizard")) {
            int hp = getValidInput("Enter HP", 50, 100);
            int mana = getValidInput("Enter Mana", 10, 50);
            int intelligence = getValidInput("Enter Intelligence", 1, 50);
            assignCharacter(new Wizard(name, hp, mana, intelligence));
        }

        scanner.nextLine();
        System.out.println("\n*** " + type + " created successfully! ***");
    }

    private static void assignCharacter(Character c) {
        if (player1 == null) {
            player1 = c;
            System.out.println("[Player 1 set to " + c.getName() + " (" + c.getClass().getSimpleName() + ")]");
        } else if (player2 == null) {
            player2 = c;
            System.out.println("[Player 2 set to " + c.getName() + " (" + c.getClass().getSimpleName() + ")]");
        } else {
            System.out.println("[Both slots full! Overwriting Player 1...]");
            player1 = c;
        }
    }

    public static void randomSimulation() {
        Random random = new Random();

        player1 = new Warrior("RandomWarrior",
                100 + random.nextInt(101),
                10 + random.nextInt(41),
                1 + random.nextInt(10));

        player2 = new Wizard("RandomWizard",
                50 + random.nextInt(51),
                10 + random.nextInt(41),
                1 + random.nextInt(50));

        System.out.println("\n[!] Random characters created!");
        engine.startBattle(player1, player2);
    }
}