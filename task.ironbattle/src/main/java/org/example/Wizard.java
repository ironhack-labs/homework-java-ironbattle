package org.example;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;
    Random rand = new Random();

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50);
        this.mana = 10 + rand.nextInt(41);
        this.intelligence = 1 + rand.nextInt(50);
    }



    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        boolean fireball = rand.nextBoolean();
        int damage = 0;
        String attackType = "";
        if (fireball && mana >= 5) {
            damage = intelligence;
            mana -= 5;
            attackType = "Fireball";
        } else if (!fireball && mana > 0) {
            damage = 2;
            mana += 1;
            attackType = "Staff Hit";
        } else if (mana < 5) {
            if (mana > 0) {
                damage = 2;
                attackType = "Staff Hit (low mana)";
            }
            mana += 1;

        } else {
            mana += 2;
            attackType = "No Attack (resting)";
        }
        target.setHp(target.getHp() - damage);
        if (damage > 0) {
            System.out.println(getName() + " used " + attackType + " on " + target.getName() + " causing " + damage + " damage!");
        } else {
            System.out.println(getName() + " could not attack and is resting this turn.");
        }
        if (target.getHp() <= 0) {
            target.setIsAlive(false);
            target.setHp(0);
            System.out.println(target.getName() + " has been defeated!");
        }
    }
}
