package com.ironhack;

import java.util.Random;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;
    private Random random = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() { return stamina; }
    public int getStrength() { return strength; }

    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setStrength(int strength) { this.strength = strength; }

    @Override
    public void attack(Character target) {

        boolean heavyAttack = random.nextBoolean();

        if (heavyAttack && stamina >= 5) {
            target.setHp(target.getHp() - strength);
            stamina -= 5;
            System.out.println(getName() + " used Heavy Attack for " + strength + " damage.");
        }
        else if (stamina >= 0) {
            int damage = strength / 2;
            target.setHp(target.getHp() - damage);
            stamina += 1;
            System.out.println(getName() + " used Weak Attack for " + damage + " damage.");
        }
        else {
            stamina += 2;
            System.out.println(getName() + " was too tired and recovered stamina.");
        }
    }
}
