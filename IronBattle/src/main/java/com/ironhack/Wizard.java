package com.ironhack;

import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    private final int STARTING_MANA;
    private final int STARTING_INTELLIGENCE;

    public Wizard(String name, int hp, int mana, int intelligence){
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;

        this.STARTING_MANA = mana;
        this.STARTING_INTELLIGENCE = intelligence;
    }

    //getters
    public int getMana() {
        return this.mana;
    }
    public int getIntelligence() {
        return this.intelligence;
    }

    public int getSTARTING_MANA() {
        return STARTING_MANA;
    }

    public int getSTARTING_INTELLIGENCE() {
        return STARTING_INTELLIGENCE;
    }

    //setters
    public void setMana(int newMana) {
        this.mana = newMana;
    }
    public void setIntelligence(int newIntelligence) {
        this.intelligence = newIntelligence;
    }

    public void attack(Character target){
        int attackType = ThreadLocalRandom.current().nextInt(0, 2);

        if(attackType == 1 && this.mana >= 5){
            target.setHp(target.getHp() - this.intelligence);
            this.setMana(this.getMana() - 5);
            System.out.println(this.getName() + " performed a Fireball attack and dealt " + this.intelligence + " damage!");
        }
        else if(this.getMana() > 0){
            target.setHp(target.getHp() - 2);
            this.setMana(this.getMana() + 1);
            System.out.println(this.getName() + " performed a Staff Hit and dealt 2 damage!");
        }
        else {
            System.out.println(this.getName() + " ran out of mana and did not deal any damage!");
            this.setMana(this.getMana() + 2);
        }

        if(target.getHp() <= 0){
            target.setLifeStatus(false);
        }
    }
    @Override
    public void resetStats(){
        this.setHp(this.getSTARTING_HP());
        this.setMana(this.getSTARTING_MANA());
        this.setIntelligence(this.getSTARTING_INTELLIGENCE());
    }
}
