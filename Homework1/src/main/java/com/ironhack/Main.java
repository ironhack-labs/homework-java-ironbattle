package com.ironhack;


public class Main {

    public static void main(String[] args) {

        Warrior w1 = new Warrior("Thor", 150, 30, 10);
        Wizard w2 = new Wizard("Merlin", 80, 30, 20);

        int round = 1;

        while (w1.getIsAlive() && w2.getIsAlive()) {

            System.out.println("===== ROUND " + round + " =====");

            w1.attack(w2);
            w2.attack(w1);

            System.out.println(w1.getName() + " HP: " + w1.getHp());
            System.out.println(w2.getName() + " HP: " + w2.getHp());

            round++;
            System.out.println();
        }

        if (w1.getIsAlive())
            System.out.println("Winner: " + w1.getName());
        else if (w2.getIsAlive())
            System.out.println("Winner: " + w2.getName());
        else
            System.out.println("It's a TIE! Restart battle.");
    }
}
