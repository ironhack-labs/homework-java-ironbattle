package org.ironhack;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        boolean winnerFound = false;



        while (!winnerFound) {
            int round = 1;

            Warrior warrior1 = new Warrior("Conan", random.nextInt(100, 201), random.nextInt(10, 51), random.nextInt(1, 11));
            Wizard wizard1 = new Wizard("Gandalf", random.nextInt(50, 101), random.nextInt(10, 51), random.nextInt(1, 51));

            System.out.println("=== Battle Start ===");
            System.out.println(warrior1.getName() + " vs " + wizard1.getName());

            while (warrior1.isAlive() && wizard1.isAlive()) {
                System.out.println("=== Round " + round + " ===");

                wizard1.attack(warrior1);
                warrior1.attack(wizard1);

                System.out.println(warrior1.getName() + " HP: " + warrior1.getHp() + " Stamina: " + warrior1.getStamina());
                System.out.println(wizard1.getName() + " HP: " + wizard1.getHp() + " Mana: " + wizard1.getMana());
                round++;

            }
            if (warrior1.isAlive() && !wizard1.isAlive()) {
                System.out.println(warrior1.getName() + " wins!");
                winnerFound=true;
            } else if (!warrior1.isAlive() && wizard1.isAlive()) {
                System.out.println(wizard1.getName() + " wins!");
                    winnerFound=true;
            } else {
                System.out.println("Restarting battle...");
            }


        }
        System.out.println("=== Battle End ===");
    }
}
