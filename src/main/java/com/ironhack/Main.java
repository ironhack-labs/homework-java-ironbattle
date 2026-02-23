package com.ironhack;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Character fighter1;
    static Character fighter2;

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\nFighter 1: " + getFighterInfo(fighter1));
            System.out.println("Fighter 2: " + getFighterInfo(fighter2));
            System.out.println("=== IRONBATTLE ===");
            System.out.println("1. Create Character");
            System.out.println("2. Start Battle");
            System.out.println("3. Random Battle (Bonus)");
            System.out.println("4. Import from CSV (Bonus)");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createCharacter();
                case "2" -> startBattle();
                case "3" -> randomBattle();
                case "4" -> importFromCSV();
                case "5" -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }
    }

//  CREATE
    private static void createCharacter() {
        if (fighter1 != null && fighter2 != null) {System.out.println("Both slots are full!");}
        else {
            System.out.println("1. Warrior");
            System.out.println("2. Wizard");
            System.out.print("Choose type: ");
            String type = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            Character character = null;

            if (type.equals("1")) {
                System.out.print("HP: ");
                int hp = Integer.parseInt(scanner.nextLine());

                System.out.print("Stamina: ");
                int stamina = Integer.parseInt(scanner.nextLine());

                System.out.print("Strength: ");
                int strength = Integer.parseInt(scanner.nextLine());

                character = new Warrior(name, hp, stamina, strength);

            } else if (type.equals("2")) {
                System.out.print("HP: ");
                int hp = Integer.parseInt(scanner.nextLine());

                System.out.print("Mana: ");
                int mana = Integer.parseInt(scanner.nextLine());

                System.out.print("Intelligence: ");
                int intelligence = Integer.parseInt(scanner.nextLine());

                character = new Wizard(name, hp, mana, intelligence);
            }

            if (character == null) {
                System.out.println("Invalid type!");
                return;
            }

            if (fighter1 == null) {
                fighter1 = character;
                System.out.println("Assigned to Fighter 1");
            } else if (fighter2 == null) {
                fighter2 = character;
                System.out.println("Assigned to Fighter 2");
            } else {
                System.out.println("Both slots are full!");
            }
        }
    }

//  BATTLE
    private static void startBattle() {

        if (fighter1 == null || fighter2 == null) {
            System.out.println("You need two fighters!");
            return;
        }

        int initialHp1 = fighter1.getHp();
        int initialHp2 = fighter2.getHp();

        while (true) {

            System.out.println("\n⚔️ Battle starts!");

            while (fighter1.isAlive() && fighter2.isAlive()) {

                System.out.println("\n--- New Round ---");

                ((Attacker) fighter1).attack(fighter2);
                ((Attacker) fighter2).attack(fighter1);

                if (fighter1.getHp() <= 0) fighter1.setAlive(false);
                if (fighter2.getHp() <= 0) fighter2.setAlive(false);

                System.out.println(fighter1.getName() + " HP: " + fighter1.getHp());
                System.out.println(fighter2.getName() + " HP: " + fighter2.getHp());
            }

            if (!fighter1.isAlive() && !fighter2.isAlive()) {
                System.out.println("\n⚔️ It's a tie! Restarting battle...");

                fighter1.setHp(initialHp1);
                fighter2.setHp(initialHp2);
                fighter1.setAlive(true);
                fighter2.setAlive(true);

            } else if (fighter1.isAlive()) {
                System.out.println("\n🏆 Winner: " + fighter1.getName());
                break;
            } else {
                System.out.println("\n🏆 Winner: " + fighter2.getName());
                break;
            }
        }

        fighter1 = null;
        fighter2 = null;
    }

//   BONUS: RANDOM
    private static Character generateRandomCharacter(String name) {

        Random random = new Random();

        if (random.nextBoolean()) {
            // Warrior
            int hp = random.nextInt(100) + 100;
            hp = random.nextInt(101) + 100;

            int stamina = random.nextInt(41) + 10;
            int strength = random.nextInt(10) + 1;

            return new Warrior(name, hp, stamina, strength);

        } else {
            // Wizard
            int hp = random.nextInt(51) + 50;
            int mana = random.nextInt(41) + 10;
            int intelligence = random.nextInt(50) + 1;

            return new Wizard(name, hp, mana, intelligence);
        }
    }

    private static void randomBattle() {

        fighter1 = generateRandomCharacter("Random1");
        fighter2 = generateRandomCharacter("Random2");

        System.out.println("Random fighters created!");
        startBattle();
    }

//  BONUS: CSV
    private static void importFromCSV() {
        System.out.print("Enter CSV file path: ");
        String path = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new java.io.File(path))) {

            int count = 0;

            while (fileScanner.hasNextLine() && count < 2) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(",");

                if (parts.length < 5) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String type = parts[0].trim();
                String name = parts[1].trim();
                int hp = Integer.parseInt(parts[2].trim());
                int stat1 = Integer.parseInt(parts[3].trim());
                int stat2 = Integer.parseInt(parts[4].trim());

                Character character = null;

                if (type.equalsIgnoreCase("warrior")) {
                    character = new Warrior(name, hp, stat1, stat2);
                } else if (type.equalsIgnoreCase("wizard")) {
                    character = new Wizard(name, hp, stat1, stat2);
                } else {
                    System.out.println("Unknown type: " + type);
                    continue;
                }

                if (count == 0) fighter1 = character;
                else fighter2 = character;

                count++;
            }

            if (fighter1 != null && fighter2 != null) {
                System.out.println("Characters imported successfully!");
            } else {
                System.out.println("CSV must contain at least 2 valid rows.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static String getFighterInfo(Character fighter) {

        if (fighter == null) {
            return "Empty";
        }

        String type = fighter.getClass().getSimpleName();

        return fighter.getName() + " (" + type + ", HP: " + fighter.getHp() + ")";
    }
}