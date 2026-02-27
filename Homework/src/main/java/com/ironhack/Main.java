package com.ironhack;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== WELCOME TO IRONHACK BATTLE ! ===");


        // Character creation

        System.out.println("---PLAYER 1---");
        System.out.print("Enter Wizard name : ");
        String name1 = scanner.nextLine();
        System.out.println("Enter Wizard HP (must be between 50-100): ");
        int wizHp = scanner.nextInt();
        while (wizHp < 50 || wizHp > 100) {
            System.out.println("Invalid input! HP must be between 50 and 100.");
            System.out.print("Try again: ");
            wizHp = scanner.nextInt();
        }

        System.out.print("Enter Wizard Mana (must be between 10-50) :");
        int wizMana = scanner.nextInt();
        while (wizMana < 10 || wizMana > 50) {
            System.out.println("Invalid input! MANA must be between 10 and 50.");
            System.out.print("Try again: ");
            wizMana = scanner.nextInt();
        }

        System.out.print("Enter Wizard Intelligence (must be between 1-50):");
        int wizIntelligence = scanner.nextInt();
        while (wizIntelligence < 1 || wizIntelligence > 50) {
            System.out.println("Invalid input! INTELLIGENCE must be between 1 and 50.");
            System.out.print("Try again: ");
            wizIntelligence = scanner.nextInt();
        }


        scanner.nextLine();
        System.out.println("---PLAYER 2---");

        System.out.print("Enter Warrior name: ");
        String name2 = scanner.nextLine();

        System.out.print("Enter Warrior HP (must be between 100-200): ");
        int warHp = scanner.nextInt();
        while (warHp < 100 || warHp > 200) {
            System.out.println("Invalid input! HP must be between 100 and 200.");
            System.out.print("Try again: ");
            warHp = scanner.nextInt();
        }

        System.out.print("Enter Warrior Stamina (must be between 10-50): ");
        int warStamina = scanner.nextInt();
        while (warStamina < 10 || warStamina > 50) {
            System.out.println("Invalid input! STAMINA must be between 10 and 50.");
            System.out.print("Try again: ");
            warStamina = scanner.nextInt();
        }

        System.out.print("Enter Warrior Strength (must be between 1-10): ");
        int warStrength = scanner.nextInt();
        while (warStrength < 1 || warStrength > 10) {
            System.out.println("Invalid input! Strength must be between 1 and 10.");
            System.out.print("Try again: ");
            warStrength = scanner.nextInt();
        }


        Wizard wizard = new Wizard(name1, wizHp, wizMana, wizIntelligence);
        Warrior warrior = new Warrior(name2, warHp, warStamina, warStrength);




        // Starting game
        System.out.println("\n=== FIGHT STARTS! ===");

        // if someone dies
        while (warrior.isAlive() && wizard.isAlive()) {
            System.out.println("-------------------------");

            // Attacks
            wizard.attack(warrior);
            warrior.attack(wizard);

            System.out.println("Round results:");

            // healths:
            System.out.println(wizard.getName() + " wizard HP: " + wizard.getHp());
            System.out.println(warrior.getName() + " warrior HP: " + warrior.getHp());
        }

        // round results
        System.out.println("\n=== K.O :GAME OVER===");
        if (wizard.getHp() == warrior.getHp()) {
            System.out.println("TIE. NO WINNER.");
        } else if (wizard.getHp() <= 0 && warrior.getHp() > 0){
            System.out.println("WINNER IS WARRIOR: " + warrior.getName());
        } else {
            System.out.println("WINNER IS WIZARD: " + wizard.getName());
        }
    }
}

