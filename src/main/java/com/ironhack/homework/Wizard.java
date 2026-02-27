package com.ironhack.homework;

import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;
    private Random random = new Random();

    public Wizard(String name, int hp, int mana,int intelligence) {
        super(name,hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana,0);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = Math.max(intelligence,0);
    }

    @Override
    public void attack(Character character) {
        int damage = 0;
        boolean isFireball = random.nextBoolean();
        if(isFireball && mana >= 5){
            damage = intelligence;
            character.setHp(character.getHp() - damage);
            mana -= 5;
            System.out.println(getName() + " attacked " + character.getName() + " with fireball dealing damage " + damage);
        }else if(mana >= 0){
            damage = 2;
            character.setHp(character.getHp() - damage);
            mana += 1;
            System.out.println(getName() + " attacked " + character.getName() + " with staff dealing damage " + damage);
        }else{
            mana += 2;
            System.out.println("Wizard is recovering mana. Current mana: " + mana);
        }
        character.setHp(character.getHp() - getIntelligence());
    }
}
