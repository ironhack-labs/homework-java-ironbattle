package com.example;

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
    public void setMana(int mana) { this.mana = Math.max(0, mana); }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = Math.max(0, intelligence); }

    @Override
    public void Attack(Character target) {

        boolean fireball = random.nextBoolean();
        int damage = 0;

        if (fireball && mana >= 5) {
            damage = intelligence;
            target.setHp(target.getHp() - damage);
            mana -= 5;
            System.out.println(getName() + " attacks " + target.getName() + " with FIREBALL for " + damage + " damage");
        }
        else if (mana > 0) {
            damage = 2;
            target.setHp(target.getHp() - damage);
            mana += 1;
        } else {
            mana += 2;
            System.out.println(getName() + " has no mana and recovers");
        }
    }
}