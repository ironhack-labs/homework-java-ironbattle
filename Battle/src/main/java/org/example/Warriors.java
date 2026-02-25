package org.example;
 import java.util.concurrent.ThreadLocalRandom;
public class Warriors extends  Characters implements Attacker {
    private int stamina;
    private int strength;
    public Warriors(String name){
        super(name,ThreadLocalRandom.current().nextInt(100, 201));
        this.stamina=ThreadLocalRandom.current().nextInt(10,51);
        this.strength=ThreadLocalRandom.current().nextInt(1,11);
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
    public void attack(Characters target) {
        int attackType = ThreadLocalRandom.current().nextInt(0, 2);

        if (attackType == 0 && this.stamina >= 5) {
            int damage = this.strength;
            this.stamina -= 5;
            target.setHp(target.getHp() - damage);
            System.out.println(getName() + " uses HEAVY ATTACK! Deals " + damage + " damage.");
        } else if (this.stamina >= 1) {
            int damage = this.strength / 2;
            this.stamina += 1;
            target.setHp(target.getHp() - damage);
            System.out.println(getName() + " uses WEAK ATTACK! Deals " + damage + " damage.");
        } else {
            this.stamina += 2;
            System.out.println(getName() + " is exhausted! Recovers 2 stamina.");
        }
    }

    }

