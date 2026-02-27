package IronBattle;

import IronBattle.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();


    public static void main(String[] args) throws FileNotFoundException {
        Character player1 = null;
        Character player2 = null;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== IRON BATTLE MENU ===");
            System.out.println("1) Create Player 1 " + (player1 != null ? "[" + player1.getName() + " Ready]" : "[Not Created]"));
            System.out.println("2) Create Player 2 " + (player2 != null ? "[" + player2.getName() + " Ready]" : "[Not Created]"));
            System.out.println("3) Load Players from CSV (Bonus)");
            System.out.println("4) Start Battle ");
            System.out.println("5) Simulate Random Battle (Bonus) ");
            System.out.println("6) Exit Game ");
            System.out.print("Choose an option: ");


            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    createCharacter(1);
                    break;
                case "2":
                    createCharacter(2);
                    break;
                case "3":

                    List<Character> importedList = importCharactersFromCSV("characters.csv");
                    if (importedList.size() >= 2) {
                        System.out.println("\n--- Characters available in CSV ---");
                        for (int i = 0; i < importedList.size(); i++) {
                            Character c = importedList.get(i);
                            System.out.println((i + 1) + ") " + c.getName() + " [" + c.getClass().getSimpleName() + ", HP: " + c.getHp() + "]");
                        }

                        try {
                            System.out.print("\nSelect Player 1 (Enter number): ");
                            int p1Index = Integer.parseInt(sc.nextLine()) - 1;
                            player1 = importedList.get(p1Index);

                            System.out.print("Select Player 2 (Enter number): ");
                            int p2Index = Integer.parseInt(sc.nextLine()) - 1;
                            player2 = importedList.get(p2Index);

                            System.out.println("Players loaded successfully from CSV!");
                        } catch (Exception e) {
                            System.out.println("Invalid selection! Please try again.");
                        }
                    } else {
                        System.out.println("Not enough characters in the CSV file or file not found.");
                    }
                    break;
                case "4":
                    if (player1 != null && player2 != null) {
                        BattleSimulator battleSimulator = new BattleSimulator();
                        battleSimulator.starter(player1, player2);


                        player1 = null;
                        player2 = null;
                    } else {
                        System.out.println("\nYou must create or load both players before starting the battle!");
                    }
                    break;
                case "5":
                    System.out.println("Ramdom Battle Game");
                    Character randomP1 = createFullyRandomCharacter();
                    Character randomP2 = createFullyRandomCharacter();

                    BattleSimulator battleSimulator = new BattleSimulator();
                    battleSimulator.starter(randomP1, randomP2);
                    break;

                case "6":
                    System.out.println("Exiting game. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }





    }
    private static Character createCharacter(int playerNum) {
        System.out.println("\nSelect Class for Player " + playerNum + ":");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.print("Choice: ");

        int type = -1;
        try {
            type = Integer.parseInt(sc.nextLine());
            if (type != 1 && type != 2) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid class selection. Creation cancelled.");
            return null;
        }

        System.out.print("Enter Character Name: ");
        String name = sc.nextLine();

        if (type == 1) {
            int hp = rand.nextInt(101) + 100;
            int stamina = rand.nextInt(41) + 10;
            int strength =rand.nextInt(10) + 1;
            System.out.println("Player " + playerNum + " (Warrior) created successfully!");
            return new Warrior(name, hp, stamina, strength);
        } else {
            int hp = rand.nextInt(51) + 50;
            int mana = rand.nextInt(41) + 10;
            int intelligence = rand.nextInt(50) + 1;
            System.out.println("Player " + playerNum + " (Wizard) created successfully!");
            return new Wizard(name, hp, mana, intelligence);
        }


    }

    private static Character createFullyRandomCharacter() {
        boolean isWarrior = rand.nextBoolean();

        if (isWarrior) {
            String[] warriorNames = {"Conan", "Arthur", "Leonidas", "Achilles", "Thor"};
            String name = warriorNames[rand.nextInt(warriorNames.length)];
            int hp = rand.nextInt(101) + 100;
            int stamina = rand.nextInt(41) + 10;
            int strength = rand.nextInt(10) + 1;
            return new Warrior(name, hp, stamina, strength);
        } else {
            String[] wizardNames = {"Gandalf", "Merlin", "Dumbledore", "Sauron", "Voldemort"};
            String name = wizardNames[rand.nextInt(wizardNames.length)];
            int hp = rand.nextInt(51) + 50;
            int mana = rand.nextInt(41) + 10;
            int intelligence = rand.nextInt(50) + 1;
            return new Wizard(name, hp, mana, intelligence);
        }
    }

    private static List<Character> importCharactersFromCSV(String filePath) {
        List<Character> importedCharacters = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            // İlk sətri (başlıqları) ötürürük
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 5) {
                    String type = data[0].trim();
                    String name = data[1].trim();
                    int hp = Integer.parseInt(data[2].trim());
                    int resource = Integer.parseInt(data[3].trim());
                    int power = Integer.parseInt(data[4].trim());

                    if (type.equalsIgnoreCase("Warrior")) {
                        importedCharacters.add(new Warrior(name, hp, resource, power));
                    } else if (type.equalsIgnoreCase("Wizard")) {
                        importedCharacters.add(new Wizard(name, hp, resource, power));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage() + "\nMake sure '" + filePath + "' exists in the project root directory.");
        }
        return importedCharacters;
    }
}
