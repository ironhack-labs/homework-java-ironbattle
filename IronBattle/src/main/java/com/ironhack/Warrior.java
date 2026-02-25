package com.ironhack;

import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    private final int STARTING_STAMINA;
    private final int STARTING_STRENGTH;

    public Warrior(String name, int hp, int stamina, int strength){
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;

        this.STARTING_STAMINA = stamina;
        this.STARTING_STRENGTH = strength;
    }

    //getters
    public int getStamina(){
        return this.stamina;
    }
    public int getStrengh(){
        return this.strength;
    }

    public int getSTARTING_STAMINA() {
        return STARTING_STAMINA;
    }

    public int getSTARTING_STRENGTH() {
        return STARTING_STRENGTH;
    }

    //setters
    public void setStamina(int newStamina){
        this.stamina = newStamina;
    }
    public void setStrengh(int newStrengh){
        this.strength = newStrengh;
    }

    public void attack(Character target){
        int attackType = ThreadLocalRandom.current().nextInt(0, 2);

        if(attackType == 1 && this.stamina >= 5){
            target.setHp(target.getHp() - this.strength);
            System.out.println(this.getName() + " Performed a Heavy Attack and dealt " + this.strength + " damage!");
            this.setStamina(this.getStamina() - 5);
        }
        else if(this.getStamina() > 0){
            int damage = this.strength / 2;
            target.setHp(target.getHp() - damage);
            System.out.println(this.getName() + " Performed a Weak Attack and dealt " + damage + " damage!");
            this.setStamina(this.getStamina() + 1);
        }
        else {
            System.out.println(this.getName() + " was exhausted and did not deal any damage!");
            this.setStamina(this.getStamina() + 2);
        }

        if(target.getHp() <= 0){
            target.setLifeStatus(false);
        }
    }
    @Override
    public void resetStats(){
        this.setHp(this.getSTARTING_HP());
        this.setStamina(this.getSTARTING_STAMINA());
        this.setStrengh(this.getSTARTING_STRENGTH());
    }
}
