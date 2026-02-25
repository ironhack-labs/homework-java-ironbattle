package com.ironhack;

import java.util.Random;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = new Random().nextInt(41) + 10;
        this.strength = new Random().nextInt(10) + 1;
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


    @Override
    public void attack(Character target) {
        if (!isAlive()) {
            System.out.println(getName() + " is dead and can't attack!");
            return;
        }

        Random rand = new Random();
        boolean chooseHeavy = rand.nextBoolean(); // random heavy or weak

        if (chooseHeavy) {
            if (stamina >= 5) {
                target.setHp(target.getHp() - strength);
                stamina -= 5;
                System.out.println(getName() + " performs Heavy Attack on " + target.getName() + " for " + strength + " damage! Stamina: " + stamina);
            } else {
                if (stamina > 0) {
                    int damage = strength / 2;
                    target.setHp(target.getHp() - damage);
                    stamina += 1;
                    System.out.println(getName() + " has low stamina, performs Weak Attack on " + target.getName() + " for " + damage + " damage! Stamina: " + stamina);
                } else {
                    stamina += 2; // recover
                    System.out.println(getName() + " has no stamina to attack, recovers 2 stamina. Current Stamina: " + stamina);
                }
            }
        } else {
            // Attempt Weak attack
            if (stamina > 0) {
                int damage = strength / 2;
                target.setHp(target.getHp() - damage);
                stamina += 1;
                System.out.println(getName() + " performs Weak Attack on " + target.getName() + " for " + damage + " damage! Stamina: " + stamina);
            } else {
                stamina += 2; // recover
                System.out.println(getName() + " has no stamina to attack, recovers 2 stamina. Current Stamina: " + stamina);
            }
        }

        // Update target alive status
        if (target.getHp() <= 0) {
            target.setAlive(false);
        }
    }
}
