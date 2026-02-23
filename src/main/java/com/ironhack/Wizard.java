package com.ironhack;

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
        if (mana>=10 && mana <= 50){
            this.mana = mana;
        }
        else{
            System.out.println("[WARNING]: Mana of wizard is not value between 10 and 50. Setting random value!");
            Random random = new Random();
            this.mana = random.nextInt(50-10+1) + 10;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence>=1 && intelligence <= 50){
            this.intelligence = intelligence;
        }
        else{
            System.out.println("[WARNING]: Intelligence of wizard is not value between 1 and 50. Setting random value!");
            Random random = new Random();
            this.intelligence = random.nextInt(50-1+1) + 1;
        }
    }

    @Override
    public void setHp(int hp){
        if (hp>=50 && hp <=100){
            updateHp(hp);
        }
        else{
            System.out.println("[WARNING]: HP of Wizard is not value between 50 and 100. Setting random value!");
            Random random = new Random();
            updateHp(random.nextInt(100-50+1) + 50);
        }
    }

    @Override
    public void attack(Character character) {
        Random random = new Random();
        boolean isFireBall = random.nextBoolean();
//      FireBall
        if (isFireBall && this.mana >= 5) {
            int damage = this.intelligence;
            character.updateHp(character.getHp() - damage);
            this.mana -= 5;
            System.out.println(this.getName() +
                    " cast Fireball. Damage: " + damage +
                    ". Target HP: " + character.getHp() +
                    ". Mana: " + this.mana);
        }
//      Staff hit
        else if (this.mana >= 1) {
            int damage = 2;
            character.updateHp(character.getHp() - damage);
            this.mana += 1;
            System.out.println(this.getName() +
                    " used Staff hit. Damage: " + damage +
                    ". Target HP: " + character.getHp() +
                    ". Mana: " + this.mana);
        }
//      Not enough mana for Staff hit
        else {
            this.mana += 2;
            System.out.println(this.getName() +
                    " has no mana and recovers. Mana: " +
                    this.mana);
        }
    }
}
