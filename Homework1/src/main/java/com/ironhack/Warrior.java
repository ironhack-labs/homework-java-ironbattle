package com.ironhack;

import java.util.Random;

public class Warrior extends Character implements Attacker {
   private int stamina;
   private int strength;
    Random random=new Random();


    public Warrior(String name, int hp,int stamina,int strength) {
        super(name, hp);
        this.stamina=stamina;
        this.strength=strength;
    }

    public void setStamina(int stamina){
        this.stamina=stamina;
    }
    public void setStrength(int strength){
        this.strength=strength;
    }

    public int getStamina(){
        return stamina;
    }
    public int getStrength(){
        return strength;
    }

    @Override
    public void attack(Character enemy) {

     boolean heavyAttack=random.nextBoolean();

     if(heavyAttack && stamina>=5){
         enemy.setHp(enemy.getHp()-strength);
         stamina -= 5;
         System.out.println(getName() + " does HEAVY attack for " + strength);
     }else if (stamina >= 1) {
         int damage = strength / 2;
         enemy.setHp(enemy.getHp() - damage);
         stamina += 1;
         System.out.println(getName() + " does WEAK attack for " + damage);
     } else {
         stamina += 2;
         System.out.println(getName() + " is too tired and recovers stamina");
     }

    }
}
