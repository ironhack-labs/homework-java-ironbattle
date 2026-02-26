package org.example;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;
    private static final Random random = new Random();

    public Wizard(String name,int hp,int mana,int intelligence){
        super(name,hp);
        this.mana=mana;
        this.intelligence=intelligence;
    }
    public Wizard(String name){
        super(name,random.nextInt(50,101));
        this.mana=random.nextInt(10,51);
        this.intelligence=random.nextInt(1,51);
    }

    //setters
    public void setMana(int mana){
        this.mana=mana;
    }
    public void setIntelligence(int intelligence){
        this.intelligence=intelligence;
    }

    //getters
    public int getMana(){
        return mana;
    }
    public int getIntelligence(){
        return intelligence;
    }

    @Override
    public void attack(Character character){
        if(!character.getIsAlive()) return;

        boolean fireball=random.nextBoolean();
        int damage=0;
        if(fireball && mana >= 5){
            damage=intelligence;
            mana-=5;
            System.out.println(getName()+" casts Fireball "+damage);
        }
        else if(mana>0){
            damage=2;
            mana+=1;
            System.out.println(getName()+" hits with Staff "+damage);
        }
        else{
            mana+=2;
            System.out.println(getName()+" has no mana ,regenerates ");
        }
        character.setHp(character.getHp()-damage);
    }
}
