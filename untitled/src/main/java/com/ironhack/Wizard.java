package com.ironhack;

import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;
    private Random random = new Random();

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() { return mana; }
    public int getIntelligence() { return intelligence; }

    public void setMana(int mana) { this.mana = mana; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    @Override
    public void attack(Character target) {

        boolean fireball = random.nextBoolean();

        if (fireball && mana >= 5) {
            target.setHp(target.getHp() - intelligence);
            mana -= 5;
            System.out.println(getName() + " cast FIREBALL for " + intelligence + " damage.");
        }
        else if (mana >= 0) {
            target.setHp(target.getHp() - 2);
            mana += 1;
            System.out.println(getName() + " used STAFF HIT for 2 damage.");
        }
        else {
            mana += 2;
            System.out.println(getName() + " had no mana and recovered.");
        }
    }
}
