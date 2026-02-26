package org.ironhack.homework;

import java.util.Scanner;

public class BattleSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Warrior name:");
        String wName = sc.nextLine();
        Warrior warrior = new Warrior(wName, 150, 30, 8);

        System.out.println("Enter Wizard name:");
        String wizName = sc.nextLine();
        Wizard wizard = new Wizard(wizName, 80, 30, 15);

        boolean tie;
        do {
            tie = false;
            warrior.setHp(150);
            wizard.setHp(80);
            warrior.setIsAlive(true);
            wizard.setIsAlive(true);

            while (warrior.getIsAlive() && wizard.getIsAlive()) {
                warrior.attack(wizard);
                wizard.attack(warrior);

                System.out.println(warrior.getName() + " HP: " + warrior.getHp());
                System.out.println(wizard.getName() + " HP: " + wizard.getHp());
                System.out.println("-----------------------");
            }

            if (warrior.getIsAlive() && !wizard.getIsAlive()) {
                System.out.println(warrior.getName() + " wins!");
            } else if (!warrior.getIsAlive() && wizard.getIsAlive()) {
                System.out.println(wizard.getName() + " wins!");
            } else {
                System.out.println("It's a tie! Restarting battle...");
                tie = true;
            }
        } while (tie);

        sc.close();
    }
}