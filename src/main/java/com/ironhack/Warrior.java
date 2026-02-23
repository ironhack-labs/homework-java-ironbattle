package com.ironhack;

import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina>=10 && stamina <= 50){
            this.stamina = stamina;
        }
        else{
            System.out.println("[WARNING]: Stamina of Warrior is not value between 1 and 10. Setting random value!");
            Random random = new Random();
            this.stamina = random.nextInt(50-10+1) + 10;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength>=1 && strength <= 10){
            this.strength = strength;
        }
        else{
            System.out.println("[WARNING]: Strength of Warrior is not value between 1 and 10. Setting random value!");
            Random random = new Random();
            this.strength = random.nextInt(10-1+1) + 1;
        }
    }

    @Override
    public void setHp(int hp) {
        if (hp>=100 && hp <=200){
            updateHp(hp);
        }
        else{
            System.out.println("[WARNING]: HP of Warrior is not value between 100 and 200. Setting random value!");
            Random random = new Random();
            updateHp(random.nextInt(200-100+1) + 100);
        }
    }

    @Override
    public void attack(Character character) {
        Random random = new Random();
        boolean isHeavyAttack = random.nextBoolean();
//      Heavy Attack
        if (isHeavyAttack && this.stamina >= 5) {
            int damage = this.strength;
            character.updateHp(character.getHp() - damage);
            this.stamina -= 5;
            System.out.println(this.getName() +
                    " used Heavy Attack. Damage: " + damage +
                    ". Target HP: " + character.getHp() +
                    ". Stamina: " + this.stamina);
        }
//      Weak Attack
        else if (this.stamina >= 1) {
            int damage = this.strength / 2;
            character.updateHp(character.getHp() - damage);
            this.stamina += 1;
            System.out.println(this.getName() +
                    " used Weak Attack. Damage: " + damage +
                    ". Target HP: " + character.getHp() +
                    ". Stamina: " + this.stamina);
        }
//      Not enough stamina for Weak
        else {
            this.stamina += 2;
            System.out.println(this.getName() +
                    " has no stamina and recovers. Stamina: " +
                    this.stamina);
        }
    }
}
