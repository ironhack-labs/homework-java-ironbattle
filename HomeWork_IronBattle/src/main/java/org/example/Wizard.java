package org.example;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private static final Random RANDOM = new Random();
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, mana);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = Math.max(0, intelligence);
    }

    @Override
    public void attack(Character target) {
        if (target == null || !target.isAlive() || !this.isAlive()) return;

        boolean wantsFireball = RANDOM.nextBoolean();

        if (mana <= 0) {
            setMana(mana + 2);
            System.out.printf("  %s is out of mana and deals 0 damage. (mana +2 => %d)%n",
                    getName(), mana);
            return;
        }

        if (wantsFireball && mana >= 5) {
            int dmg = intelligence;
            setMana(mana - 5);
            target.takeDamage(dmg);
            System.out.printf("  %s casts FIREBALL: %d dmg. (mana -5 => %d)%n",
                    getName(), dmg, mana);
            return;
        }

        int dmg = 2;
        setMana(mana + 1);
        target.takeDamage(dmg);
        System.out.printf("  %s uses STAFF HIT: %d dmg. (mana +1 => %d)%n",
                getName(), dmg, mana);
    }

    @Override
    public String shortStats() {
        return String.format("Wizard(hp=%d, mana=%d, intelligence=%d)", getHp(), mana, intelligence);
    }
}