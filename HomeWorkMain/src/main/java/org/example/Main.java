package org.example;

import org.example.entity.BattleSimulator;
import org.example.entity.Character;
import org.example.entity.Warrior;
import org.example.entity.Wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
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

            String choice = SC.nextLine();
            switch (choice) {
                case "1":
                    player1 = createCharacter(1);
                    break;
                case "2":
                    player2 = createCharacter(2);
                    break;
                case "3":
                    // CSV-dən oxumaq
                    List<Character> importedList = importCharactersFromCSV("characters.csv");
                    if (importedList.size() >= 2) {
                        System.out.println("\n--- Characters available in CSV ---");
                        for (int i = 0; i < importedList.size(); i++) {
                            Character c = importedList.get(i);
                            System.out.println((i + 1) + ") " + c.getName() + " [" + c.getClass().getSimpleName() + ", HP: " + c.getHp() + "]");
                        }

                        try {
                            System.out.print("\nSelect Player 1 (Enter number): ");
                            int p1Index = Integer.parseInt(SC.nextLine()) - 1;
                            player1 = importedList.get(p1Index);

                            System.out.print("Select Player 2 (Enter number): ");
                            int p2Index = Integer.parseInt(SC.nextLine()) - 1;
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
                        battleSimulator.startBattle(player1, player2);

                        // Döyüş bitdikdən sonra oyunçuları sıfırlayırıq
                        player1 = null;
                        player2 = null;
                    } else {
                        System.out.println("\nYou must create or load both players before starting the battle!");
                    }
                    break;
                case "5":
                    System.out.println("\n--- Simulating Random Battle ---");
                    Character randomP1 = createFullyRandomCharacter();
                    Character randomP2 = createFullyRandomCharacter();

                    BattleSimulator randomSimulator = new BattleSimulator();
                    randomSimulator.startBattle(randomP1, randomP2);
                    break;
                case "6":
                    System.out.println("Exiting game. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        SC.close();
    }

    private static Character createCharacter(int playerNum) {
        System.out.println("\nSelect Class for Player " + playerNum + ":");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.print("Choice: ");

        int type = -1;
        try {
            type = Integer.parseInt(SC.nextLine());
            if (type != 1 && type != 2) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid class selection. Creation cancelled.");
            return null;
        }

        System.out.print("Enter Character Name: ");
        String name = SC.nextLine();

        if (type == 1) {
            int hp = RANDOM.nextInt(101) + 100;
            int stamina = RANDOM.nextInt(41) + 10;
            int strength = RANDOM.nextInt(10) + 1;
            System.out.println("Player " + playerNum + " (Warrior) created successfully!");
            return new Warrior(name, hp, stamina, strength);
        } else {
            int hp = RANDOM.nextInt(51) + 50;
            int mana = RANDOM.nextInt(41) + 10;
            int intelligence = RANDOM.nextInt(50) + 1;
            System.out.println("Player " + playerNum + " (Wizard) created successfully!");
            return new Wizard(name, hp, mana, intelligence);
        }
    }

    private static Character createFullyRandomCharacter() {
        boolean isWarrior = RANDOM.nextBoolean();

        if (isWarrior) {
            String[] warriorNames = {"Conan", "Arthur", "Leonidas", "Achilles", "Thor"};
            String name = warriorNames[RANDOM.nextInt(warriorNames.length)];
            int hp = RANDOM.nextInt(101) + 100;
            int stamina = RANDOM.nextInt(41) + 10;
            int strength = RANDOM.nextInt(10) + 1;
            return new Warrior(name, hp, stamina, strength);
        } else {
            String[] wizardNames = {"Gandalf", "Merlin", "Dumbledore", "Sauron", "Voldemort"};
            String name = wizardNames[RANDOM.nextInt(wizardNames.length)];
            int hp = RANDOM.nextInt(51) + 50;
            int mana = RANDOM.nextInt(41) + 10;
            int intelligence = RANDOM.nextInt(50) + 1;
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