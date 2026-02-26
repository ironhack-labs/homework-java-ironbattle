package org.ironhack.homework;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;
    private Random rand = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() { return stamina; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    @Override
    public void attack(Character target) {
        int damage = 0;
        boolean heavy = rand.nextBoolean(); // Random Heavy or Weak

        if (heavy && stamina >= 5) {
            damage = strength;
            stamina -= 5;
            System.out.println(getName() + " performs a Heavy Attack causing " + damage + " damage!");
        } else if (!heavy && stamina > 0) {
            damage = strength / 2;
            stamina += 1;
            System.out.println(getName() + " performs a Weak Attack causing " + damage + " damage!");
        } else if (stamina > 0) {
            // Not enough stamina for heavy, do weak
            damage = strength / 2;
            stamina += 1;
            System.out.println(getName() + " performs a Weak Attack causing " + damage + " damage!");
        } else {
            damage = 0;
            stamina += 2;
            System.out.println(getName() + " is too tired to attack! Recovering stamina...");
        }

        target.setHp(target.getHp() - damage);
    }
}