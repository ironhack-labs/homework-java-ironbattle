package org.example;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private static final Random RANDOM = new Random();
    private int stamina;   // 10-50
    private int strength;  // 1-10

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(0, stamina);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(0, strength);
    }

    @Override
    public void attack(Character target) {
        if (target == null || !target.isAlive() || !this.isAlive())
            return;

        boolean wantsHeavy = RANDOM.nextBoolean();


        if (stamina <= 0) {
            setStamina(stamina + 2);
            System.out.printf("  %s is too tired and deals 0 damage. (stamina +2 => %d)%n",
                    getName(), stamina);
            return;
        }

        if (wantsHeavy && stamina >= 5) {
            int dmg = strength;
            setStamina(stamina - 5);
            target.takeDamage(dmg);
            System.out.printf("  %s uses HEAVY attack: %d dmg. (stamina -5 => %d)%n",
                    getName(), dmg, stamina);
            return;
        }

        int dmg = strength / 2; // truncates decimals automatically
        setStamina(stamina + 1);
        target.takeDamage(dmg);
        System.out.printf("  %s uses WEAK attack: %d dmg. (stamina +1 => %d)%n",
                getName(), dmg, stamina);
    }

    @Override
    public String shortStats() {
        return String.format("Warrior(hp=%d, stamina=%d, strength=%d)", getHp(), stamina, strength);
    }
}