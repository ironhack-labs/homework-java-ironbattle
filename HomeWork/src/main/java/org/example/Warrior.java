package org.example;

import java.util.Random;

import static java.lang.Math.random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private static final Random random = new Random();

    public Warrior(String name,int hp,int stamina, int strength){
        super(name,hp);
        this.stamina=stamina;
        this.strength=strength;
    }
    public Warrior(String name){
        super(name,random.nextInt(100,201));
        this.stamina=random.nextInt(10,51);
        this.strength=random.nextInt(1,11);
    }

    //setters
    public void setStamina(int stamina){
        this.stamina=stamina;
    }
    public void setStrength(int strength){
        this.strength=strength;
    }

    //getters
    public int getStamina(){
        return stamina;
    }
    public int getStrength(){
        return strength;
    }

    @Override
    public void attack(Character character){
        if(!character.getIsAlive()) return;

        boolean heavyAttack=random.nextBoolean();
        int damage=0;
        if(heavyAttack && this.stamina>=5){
             damage=strength;
            stamina-=5;
            System.out.println(getName()+" Uses Heavy Attack "+damage);
        }
        else if(stamina>0){
             damage=strength/2;
            stamina++;
            System.out.println(getName()+" Uses Weak Attack "+damage);
        }
        else{
            stamina+=2;
            System.out.println(getName()+" is too tired and recovers stamina ");
        }
        character.setHp(character.getHp()-damage);
    }
}
