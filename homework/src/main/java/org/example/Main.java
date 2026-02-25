package org.example;

import org.example.BattleSimulator;
import org.example.Character;
import org.example.Warrior;
import org.example.Wizard;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Character player1 = null;
        Character player2 = null;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome to the Battle Game!\n");
            System.out.println("1) Create Player 1 " + (player1 != null ? "[" + player1.getName() + " Ready]" : "[Not Created]"));
            System.out.println("2) Create Player 2 " + (player2 != null ? "[" + player2.getName() + " Ready]" : "[Not Created]"));
            System.out.println("3) Start Battle ");
            System.out.println("4) Exit Battle ");
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
                    if (player1 != null && player2 != null) {
                        BattleSimulator battleSimulator = new BattleSimulator();
                        battleSimulator.startBattle(player1, player2);

                        player1 = null;
                        player2 = null;
                    } else {
                        System.out.println("\n create both players before starting the battle!");
                    }
                    break;
                case "4":
                    System.out.println("Exiting battle...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
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
            if (type != 1&&type != 2) throw new NumberFormatException();
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
            System.out.println("Player "+playerNum + "Wizard created successfully!");
            return new Wizard(name, hp, mana, intelligence);
        }
    }
}