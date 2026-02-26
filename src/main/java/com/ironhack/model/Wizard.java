package com.ironhack.model;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    private final int initialMana;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
        this.initialMana = mana;
    }

    @Override
    public void attack(Character target) {
        boolean fireball = random.nextBoolean();

        int damage = performAttack(fireball);
        target.setHp(target.getHp() - damage);

        System.out.println(getName() + " deals " + damage + " damage to " + target.getName());
    }

    private int performAttack(boolean fireball) {
        int damage = 0;
        if (fireball && mana >= 5) {
            damage = intelligence;
            mana -= 5;
            System.out.println(getName() + " casts FIREBALL!");
        }
        else if (mana > 0) {
            damage = 2;
            mana += 1;
            System.out.println(getName() + " hits with STAFF!");
        }
        else {
            mana += 2;
            System.out.println(getName() + " is out of mana and regenerates.");
        }
        return damage;
    }

    public int getInitialMana() {
        return initialMana;
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
}
