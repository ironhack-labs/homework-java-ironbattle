package org.ironhack;

import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name,hp);
        setStamina(stamina);
        setStrength(strength);
    }



    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina<10 || stamina>50){
            throw new IllegalArgumentException("Stamina must be between 10 and 50.");
        }

        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength<1 || strength>10) {
            throw new IllegalArgumentException("Strength must be between 1 and 10.");

        }
        this.strength = strength;
    }


    @Override
    public void attack(Character character) {
        Random random=new Random();
        boolean heavyAttack=random.nextBoolean();
        int damage=0;
        if (heavyAttack && stamina>5){
            damage=strength;
            stamina-=5;
            System.out.println(getName()+" performs a heavy attack on "+character.getName()+" dealing "+damage+" damage!");

        } else if (stamina>=1) {
             damage=strength/2;
            stamina+=1;
            System.out.println(getName()+" performs a weak attack on "+character.getName()+" dealing "+damage+" damage!");

        } else {
            stamina+=2;
            System.out.println(getName()+" has no stamina left and takes a moment to recover.");
            
        }
        character.setHp(character.getHp()-damage);
    }
}

