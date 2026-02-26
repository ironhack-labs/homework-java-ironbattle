package org.example;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Character player1 = null;
        Character player2 = null;

        while (true) {
            System.out.println("1. Create Player 1");
            System.out.println("2. Create Player 2");
            System.out.println("3. Start Battle");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    player1 = createCharacter(scanner, random);
                    break;

                case 2:
                    player2 = createCharacter(scanner, random);
                    break;
                case 3:
                    if (player1 == null || player2 == null) {
                        System.out.println("Both players must be created first!");
                    } else {
                        BattleSimulator.fight(player1, player2);
                    }
                    break;

                case 4:
                    System.out.println("Exiting game...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static Character createCharacter(Scanner scanner, Random random) {

        System.out.println("Choose character type:");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.print("Your choice: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (type == 1) {

            int hp = random.nextInt(101) + 100;
            int stamina = random.nextInt(41) + 10;
            int strength = random.nextInt(10) + 1;

            Warrior warrior = new Warrior(name, hp, stamina, strength);

            System.out.println("Warrior created!");
            System.out.println("HP: " + hp + " | Stamina: " + stamina + " | Strength: " + strength);

            return warrior;

        } else if (type == 2) {

            int hp = random.nextInt(51) + 50; // 50-100
            int mana = random.nextInt(41) + 10; // 10-50
            int intelligence = random.nextInt(50) + 1; // 1-50

            Wizard wizard = new Wizard(name, hp, mana, intelligence);

            System.out.println("Wizard created!");
            System.out.println("HP: " + hp + " | Mana: " + mana + " | Intelligence: " + intelligence);

            return wizard;

        } else {
            System.out.println("Invalid type!");
            return null;
        }
    }
}
