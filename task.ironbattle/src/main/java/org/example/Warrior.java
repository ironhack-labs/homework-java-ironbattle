package org.example;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;
    Random rand = new Random();


    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100);
        this.stamina = 10 + rand.nextInt(41);
        this.strength = 1 + rand.nextInt(10);
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }


    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character target) {
        boolean heavyAttack = rand.nextBoolean();
        int damage = 0;
        String attackType = "";
        if (heavyAttack && stamina >= 5) {
            damage = strength;
            stamina -= 5;
            attackType = "Heavy Attack";
        } else if (!heavyAttack && stamina > 0) {
            damage = strength / 2;
            stamina += 1;
            attackType = "Weak Attack";
        } else if (stamina < 5) {
            if (stamina > 0) {
                damage = strength / 2;
                attackType = "Weak Attack (low stamina)";
            }
            stamina += 1;
        }else {
            stamina+=2;
            attackType = "No Attack (resting)";
        }
        target.setHp(target.getHp() - damage);
        if (damage > 0) {
            System.out.println(getName() + " used " + attackType + " on " + target.getName() + " causing " + damage + " damage!");
        } else {
            System.out.println(getName() + " could not attack and is resting this turn.");
        }
        if (target.getHp() <= 0) {
            target.setIsAlive(false);
            target.setHp(0);
            System.out.println(target.getName() + " has been defeated!");
        }
    }
}
