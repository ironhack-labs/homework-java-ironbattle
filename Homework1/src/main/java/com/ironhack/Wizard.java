package com.ironhack;

import java.util.Random;

public class Wizard extends Character implements Attacker{
   private int mana;
   private int intelligence;
   Random random=new Random();

    public Wizard(String name, int hp,int mana,int intelligence) {
        super(name, hp);
        this.mana=mana;
        this.intelligence=intelligence;
    }

    public void setMana(int mana){
        this.mana=mana;
    }
    public void setIntelligence(int intelligence){
        this.intelligence=intelligence;
    }

    public int getMana(){
        return mana;
    }
    public int getIntelligence(){
        return intelligence;
    }

    @Override
    public void attack(Character enemy) {
        boolean fireball = random.nextBoolean();

        if (fireball && mana >= 5) {
            enemy.setHp(enemy.getHp() - intelligence);
            mana -= 5;
            System.out.println(getName() + " casts FIREBALL for " + intelligence);

        } else if (mana >= 1) {
            enemy.setHp(enemy.getHp() - 2);
            mana += 1;
            System.out.println(getName() + " hits with STAFF for 2");

        } else {
            mana += 2;
            System.out.println(getName() + " meditates to recover mana");
        }
    }
}
