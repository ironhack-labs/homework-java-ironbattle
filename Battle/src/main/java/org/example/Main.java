package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("=================================");
        System.out.println("   WELCOME TO IRON BATTLE!");
        System.out.println("=================================\n");
        while (!exit) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create Battle");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    customBattle(scanner);
                    break;
                case 2:
                    System.out.println("Thanks for playing! Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
    private static void customBattle(Scanner scanner) {
        System.out.println("\n=== CREATE CHARACTER 1 ===");
        Characters character1 = createCharacter(scanner, "Character 1");
        System.out.println("\n=== CREATE CHARACTER 2 ===");
        Characters character2 = createCharacter(scanner, "Character 2");
        startBattle(character1, character2);
    }
    private static Characters createCharacter(Scanner scanner, String prompt) {
        System.out.println("Choose character type:");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        Characters character;
        if (type == 1) {
            character = new Warriors(name);
            System.out.println("Warrior created! HP: " + character.getHp());
        } else {
            character = new Wizards(name);
            System.out.println("Wizard created! HP: " + character.getHp());
        }
        return character;
    }
    private static void startBattle(Characters char1, Characters char2) {
        int battleNumber = 1;
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("BATTLE #" + battleNumber + " BEGINS!");
            System.out.println("=".repeat(50));
            System.out.println(char1.getName() + " (HP: " + char1.getHp() + ") VS " + 
                             char2.getName() + " (HP: " + char2.getHp() + ")");
            System.out.println("=".repeat(50) + "\n");
if (battleNumber > 1) {
                String name1 = char1.getName();
                String name2 = char2.getName();
                if (char1 instanceof Warriors) {
                    char1 = new Warriors(name1);
                } else {
                    char1 = new Wizards(name1);
                }
                if (char2 instanceof Warriors) {
                    char2 = new Warriors(name2);
                } else {
                    char2 = new Wizards(name2);
                }
                System.out.println("Characters reset for new battle!");
                System.out.println(char1.getName() + " HP: " + char1.getHp());
                System.out.println(char2.getName() + " HP: " + char2.getHp());
            }
            int round = 1;
            while (char1.getAlive() && char2.getAlive()) {
                System.out.println("\n--- Round " + round + " ---");
                if (char1 instanceof Attacker) {
                    ((Attacker) char1).attack(char2);
                }
                if (char2 instanceof Attacker) {
                    ((Attacker) char2).attack(char1);
                }
                System.out.println(char1.getName() + " HP: " + char1.getHp() + " | " + 
                                 char2.getName() + " HP: " + char2.getHp());
                round++;
            }
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           BATTLE OVER!");
            System.out.println("=".repeat(50));
            if (!char1.getAlive() && !char2.getAlive()) {
                System.out.println("IT'S A TIE! Both warriors fell!");
                System.out.println("Restarting battle to determine a clear winner...\n");
                battleNumber++;
                continue; // Restart battle
            } else if (char1.getAlive()) {
                System.out.println(" WINNER: " + char1.getName());
                System.out.println("Remaining HP: " + char1.getHp());
            } else {
                System.out.println("WINNER: " + char2.getName() );
                System.out.println("Remaining HP: " + char2.getHp());
            }
            System.out.println("=".repeat(50));
            break;
        }
    }
}
