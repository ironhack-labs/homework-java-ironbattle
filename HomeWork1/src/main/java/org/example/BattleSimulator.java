package org.example;

public class BattleSimulator {

    public static void fight(Character c1, Character c2){

        while (true) {
//            Wizard wizard1=(Wizard) wizard;
//            Warrior warrior1=(Warrior) warrior;

            int round = 1;

            while (c1.isAlive() && c2.isAlive()) {

                System.out.println("===== ROUND " + round + " =====");

                c1.attack(c2);
                c2.attack(c1);

                round++;
            }

            if (!c1.isAlive() && !c2.isAlive()) {
                System.out.println("It's a TIE! Restarting battle...");


            }
            else if (c1.isAlive()) {
                System.out.println(c1.getName() + " WINS!");
                break;
            }
            else {
                System.out.println(c2.getName() + " WINS!");
                break;
            }
        }
    }

}
