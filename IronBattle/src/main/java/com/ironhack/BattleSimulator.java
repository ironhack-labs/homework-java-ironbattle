package com.ironhack;


public class BattleSimulator {

    static void main(String[] args) {

        Warrior warrior = new Warrior("Thor", 150, 30, 8);
        Wizard wizard = new Wizard("Gandalf", 80);

        while(true) {
            System.out.println("\n--- New Battle ---");


            while(warrior.isAlive() && wizard.isAlive()) {
                warrior.attack(wizard);
                wizard.attack(warrior);

                System.out.println(warrior.getName() + " HP: " + warrior.getHp() + " Stamina: " + warrior.getStamina());
                System.out.println(wizard.getName() + " HP: " + wizard.getHp() + " Mana: " + wizard.getMana());
                System.out.println("----------------------------");
            }

            if(warrior.isAlive() ^ wizard.isAlive()) {
                Character winner = warrior.isAlive() ? warrior : (Wizard) wizard;
                System.out.println("Winner is: " + winner.getName());
                break;
            } else {
                System.out.println("It's a tie! Restarting battle...");
                warrior.setHp(150);
                wizard.setHp(80);
            }
        }
    }
}