package com.ironhack.service;

import com.ironhack.model.Attacker;
import com.ironhack.model.Character;
import com.ironhack.model.Warrior;
import com.ironhack.model.Wizard;

public class BattleSimulator {

    public static void fight(Character c1, Character c2) {
        System.out.println("====================================");
        System.out.println("Battle: " + c1.getName() + " VS " + c2.getName());
        System.out.println("====================================");

        int round = 1;
        while (c1.isAlive() && c2.isAlive()) {
            System.out.println("----- Round " + round + " -----");

            ((Attacker) c1).attack(c2);
            ((Attacker) c2).attack(c1);

            System.out.println(c1.getName() + " HP: " + c1.getHp());
            System.out.println(c2.getName() + " HP: " + c2.getHp());

            round++;
        }

        if (!c1.isAlive() && !c2.isAlive()) {
            System.out.println("It's a TIE!");
            System.out.println("Restarting battle...");

            fight(resetCharacter(c1), resetCharacter(c2));
        }
        else if (c1.isAlive()) {
            System.out.println("Winner: " + c1.getName());
        }
        else {
            System.out.println("Winner: " + c2.getName());
        }
    }

    private static Character resetCharacter(Character character) {
        if (character instanceof Warrior w) {
            return new Warrior(
                    w.getName(),
                    w.getInitialHp(),
                    w.getInitialStamina(),
                    w.getStrength()
            );
        } else if (character instanceof Wizard wiz) {
            return new Wizard(
                    wiz.getName(),
                    wiz.getInitialHp(),
                    wiz.getInitialMana(),
                    wiz.getIntelligence()
            );
        }
        return null;
    }
}