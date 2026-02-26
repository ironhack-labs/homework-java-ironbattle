package com.example;

import java.util.Random;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;
    private Random random = new Random();

    public Warrior(String name, int hp, int strength, int stamina) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() { return stamina; }
    public void setStamina(int stamina) { this.stamina = Math.max(0, stamina); }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = Math.max(0, strength); }

    @Override
    public void Attack(Character target) {

        boolean heavyAttack = random.nextBoolean();
        int damage = 0;

        if (heavyAttack && stamina >= 5) {
            damage = strength;
            target.setHp(target.getHp() - damage);
            stamina -= 5;
            System.out.println(getName() + " attacks " + target.getName() + " with HEAVY attack for " + damage + " damage");
        }
        else if (stamina >= 1) {
            damage = strength / 2;
            target.setHp(target.getHp() - damage);
            stamina += 1;
            System.out.println(getName() + " attacks " + target.getName() + " with WEAK attack for " + damage + " damage");
        }
        else {
            stamina += 2;
            System.out.println(getName() + " is exhausted and recovers stamina");
        }
    }
}