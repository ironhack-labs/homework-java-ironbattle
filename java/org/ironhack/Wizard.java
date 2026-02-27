package org.ironhack;

import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }





    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(mana<10 || mana>50){
            throw new IllegalArgumentException("Mana must be between 10 and 50.");
        }
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if(intelligence<1 || intelligence>50){
            throw new IllegalArgumentException("Intelligence must be between 1 and 50.");
        }
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        Random random=new Random();
        boolean fireball=random.nextBoolean();
        int damage=0;

        if (fireball && mana>=5) {
            damage=intelligence;
            mana-=5;
            System.out.println(getName()+" casts a fireball on "+character.getName()+" dealing "+damage+" damage!");

        } else if (mana>=1) {
            damage=2;
            mana+=1;
            System.out.println(getName()+" casts a Staff Hit on "+character.getName()+" dealing "+damage+" damage!");

        } else {
            mana+=2;
            System.out.println(getName()+" has no mana left and takes a moment to recover.");
        }
         character.setHp(character.getHp()-damage);

        }

    }

