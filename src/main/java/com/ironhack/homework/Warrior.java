package com.ironhack.homework;

import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private Random random = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, 0);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(strength, 0);
    }

    @Override
    public void attack(Character character) {
        int damage = 0;
        boolean heavy = random.nextBoolean();
        if(heavy && stamina >= 5){
            damage = strength;
            stamina -= 5;
            character.setHp(character.getHp() - damage);
            System.out.println(getName() + " heavily attacked! Dealing " + damage + " damage! To " + character.getName());
        }else if(stamina >= 1){
            damage = strength / 2;
            stamina += 1;
            character.setHp(character.getHp() - damage);
            System.out.println(getName() + " couldn't heavily attack! Dealing " + damage + " damage! To " + character.getName());
        }else{
            stamina += 2;
            System.out.println(getName() + " recovering stamina. Current stamina: " + stamina);
        }
    }
}
