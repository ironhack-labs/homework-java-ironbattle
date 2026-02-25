package com.ironhack;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp) {
        super(name, hp);
        this.mana = new Random().nextInt(41)+10;
        this.intelligence= new Random().nextInt(41)+10;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        if (mana >= 5) {
            target.setHp(target.getHp() - intelligence);
            mana -= 5;
            System.out.println(getName() + " casts Fireball on " + target.getName() + " for " + intelligence + " damage!");
        } else if (mana > 0) {
            target.setHp(target.getHp() - 2);
            mana += 1;
            System.out.println(getName() + " hits " + target.getName() + " with staff for 2 damage!");
        } else {
            mana += 2;
            System.out.println(getName() + " has no mana to attack, recovers 2 mana!");
        }

        if (target.getHp() <= 0) {
            target.setAlive(false);
        }
    }
}
