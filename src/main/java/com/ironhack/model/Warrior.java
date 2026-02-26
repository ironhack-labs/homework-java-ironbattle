package com.ironhack.model;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    private final int initialStamina;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        this.initialStamina = stamina;
    }

    @Override
    public void attack(Character target) {
        boolean heavy = random.nextBoolean();

        int damage = performAttack(heavy);
        target.setHp(target.getHp() - damage);

        System.out.println(getName() + " deals " + damage + " damage to " + target.getName());
    }

    private int performAttack(boolean heavy) {
        int damage = 0;
        if (heavy && stamina >= 5) {
            damage = strength;
            stamina -= 5;
            System.out.println(getName() + " performs HEAVY attack!");
        } else if (stamina > 0) {
            damage = strength / 2;
            stamina += 1;
            System.out.println(getName() + " performs WEAK attack!");
        } else {
            stamina += 2;
            System.out.println(getName() + " is exhausted and recovers stamina.");
        }
        return damage;
    }

    public int getInitialStamina() {
        return initialStamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
