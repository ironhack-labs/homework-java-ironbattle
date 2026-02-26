package org.example.entity;
import org.example.entity.Character;

import java.util.Random;


public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {
        Random random = new Random();
        boolean heavy = random.nextBoolean();
        int damage = 0;
        if (heavy && this.stamina >= 5) {
           damage = this.strength;
           stamina -= 5;
            System.out.println(this.getName() + " uses a Heavy Attack! (Damage: " + damage + ")");
        }
        else if (this.stamina >= 1){
            damage = this.strength/2;
            this.stamina += 1;
            System.out.println(this.getName() + " uses a Weak Attack! (Damage: " + damage + ")");
        }
        else{
            this.stamina += 2;
            System.out.println(this.getName() + " has no stamina! Recovers 2 stamina.");
        }
        character.setHp(character.getHp() - damage);
    }
}
