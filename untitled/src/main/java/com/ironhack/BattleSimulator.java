package com.ironhack;

public class BattleSimulator {

    public static void startBattle(Character c1, Character c2) {

        int round = 1;

        while (c1.isAlive() && c2.isAlive()) {

            System.out.println("\n--- Round " + round + " ---");

            ((Attacker)c1).attack(c2);
            ((Attacker)c2).attack(c1);

            System.out.println(c1.getName() + " HP: " + c1.getHp());
            System.out.println(c2.getName() + " HP: " + c2.getHp());

            round++;
        }

        if (c1.isAlive())
            System.out.println("Winner: " + c1.getName());
        else if (c2.isAlive())
            System.out.println("Winner: " + c2.getName());
        else
            System.out.println("Tie! Restarting battle...");
    }
}
