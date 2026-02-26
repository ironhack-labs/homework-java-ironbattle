package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static Character player1 = null;
    private static Character player2 = null;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = SCANNER.nextLine().trim();

            switch (choice) {
                case "1" -> player1 = createCharacter("Player 1");
                case "2" -> player2 = createCharacter("Player 2");
                case "3" -> startBattleIfReady();
                case "4" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option. Choose 1-4.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== IronBattle Menu ===");
        System.out.println("1) Create/Replace Player 1");
        System.out.println("2) Create/Replace Player 2");
        System.out.println("3) Start Battle");
        System.out.println("4) Exit");

        System.out.println("\nCurrent fighters:");
        System.out.println("Player 1: " + (player1 == null ? "-" : player1.getName() + " " + player1.shortStats()));
        System.out.println("Player 2: " + (player2 == null ? "-" : player2.getName() + " " + player2.shortStats()));
        System.out.print("\nChoose: ");
    }

    private static Character createCharacter(String label) {
        System.out.println("\nCreate " + label);
        System.out.print("Type (W=Warrior, Z=Wizard): ");
        String type = SCANNER.nextLine().trim().toUpperCase();

        System.out.print("Name: ");
        String name = SCANNER.nextLine().trim();
        if (name.isEmpty()) name = label;

        return switch (type) {
            case "W" -> createWarrior(name);
            case "Z" -> createWizard(name);
            default -> {
                System.out.println("Unknown type. Creating Warrior by default.");
                yield createWarrior(name);
            }
        };
    }

    private static Warrior createWarrior(String name) {
        int hp = readIntOrRandom("HP (100-200) [Enter = random]: ", 100, 200);
        int stamina = readIntOrRandom("Stamina (10-50) [Enter = random]: ", 10, 50);
        int strength = readIntOrRandom("Strength (1-10) [Enter = random]: ", 1, 10);

        Warrior w = new Warrior(name, hp, stamina, strength);
        System.out.println("Created: " + w.getName() + " " + w.shortStats());
        return w;
    }

    private static Wizard createWizard(String name) {
        int hp = readIntOrRandom("HP (50-100) [Enter = random]: ", 50, 100);
        int mana = readIntOrRandom("Mana (10-50) [Enter = random]: ", 10, 50);
        int intel = readIntOrRandom("Intelligence (1-50) [Enter = random]: ", 1, 50);

        Wizard z = new Wizard(name, hp, mana, intel);
        System.out.println("Created: " + z.getName() + " " + z.shortStats());
        return z;
    }

    private static int readIntOrRandom(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = SCANNER.nextLine().trim();
            if (s.isEmpty()) {
                return RANDOM.nextInt(max - min + 1) + min;
            }
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("  Must be between " + min + " and " + max + ".");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a number.");
            }
        }
    }

    private static void startBattleIfReady() {
        if (player1 == null || player2 == null) {
            System.out.println("You must create both Player 1 and Player 2 first.");
            return;
        }

        System.out.println("\n=== Battle Start ===");
        System.out.println(player1.getName() + " " + player1.shortStats());
        System.out.println("VS");
        System.out.println(player2.getName() + " " + player2.shortStats());

        // If tie, restart battle until one winner
        int attempt = 1;
        while (true) {
            System.out.println("\n--- Duel attempt #" + attempt + " ---");

            Character c1 = cloneFresh(player1);
            Character c2 = cloneFresh(player2);

            Character winner = duel(c1, c2);
            if (winner != null) {
                System.out.println("\n🏆 WINNER: " + winner.getName() + " (" + winner.shortStats() + ")");
                return;
            }

            System.out.println("\n⚔️  It's a TIE. Restarting duel...\n");
            attempt++;
        }
    }

    // Make fresh copies so restarting a duel resets HP/resources
    private static Character cloneFresh(Character original) {
        if (original instanceof Warrior w) {
            return new Warrior(w.getName(), w.getHp(), w.getStamina(), w.getStrength());
        } else if (original instanceof Wizard z) {
            return new Wizard(z.getName(), z.getHp(), z.getMana(), z.getIntelligence());
        }
        throw new IllegalStateException("Unknown character type.");
    }

    private static Character duel(Character a, Character b) {
        Attacker attackerA = (Attacker) a;
        Attacker attackerB = (Attacker) b;

        int round = 1;

        while (a.isAlive() && b.isAlive()) {
            System.out.println("\nRound " + round);
            System.out.println("Before: " + a.getName() + " hp=" + a.getHp() + " | " + b.getName() + " hp=" + b.getHp());

            // "Attack at the same time":
            // 1) compute by applying a's attack to b
            // 2) compute by applying b's attack to a
            // Even if one kills the other, the other still attacks in this round.
            attackerA.attack(b);
            attackerB.attack(a);

            System.out.println("After:  " + a.getName() + " hp=" + a.getHp() + " | " + b.getName() + " hp=" + b.getHp());

            round++;
        }

        boolean aAlive = a.isAlive();
        boolean bAlive = b.isAlive();

        if (aAlive && !bAlive) return a;
        if (!aAlive && bAlive) return b;

        // both dead => tie
        return null;
    }
}