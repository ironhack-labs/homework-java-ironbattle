package org.ironhack.homework;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;
    private Random rand = new Random();

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    @Override
    public void attack(Character target) {
        int damage = 0;
        boolean fireball = rand.nextBoolean();

        if (fireball && mana >= 5) {
            damage = intelligence;
            mana -= 5;
            System.out.println(getName() + " casts Fireball causing " + damage + " damage!");
        } else if (!fireball && mana > 0) {
            damage = 2;
            mana += 1;
            System.out.println(getName() + " hits with Staff causing " + damage + " damage!");
        } else if (mana > 0) {
            damage = 2;
            mana += 1;
            System.out.println(getName() + " hits with Staff causing " + damage + " damage!");
        } else {
            damage = 0;
            mana += 2;
            System.out.println(getName() + " is out of mana! Recovering...");
        }

        target.setHp(target.getHp() - damage);
    }
}