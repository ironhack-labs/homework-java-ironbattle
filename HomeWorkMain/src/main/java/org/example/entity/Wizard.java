package org.example.entity;
import org.example.entity.Character;

import java.util.Random;


public class Wizard extends Character {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean();
        int damage = 0;
        if (fireball && this.mana>=5) {
            damage = this.intelligence;
            this.mana -=5;
            System.out.println(this.getName() + " casts a Fireball! (Damage: " + damage + ")");
        } else if (this.mana>=1) {
            damage = 2;
            this.mana += 1;
            System.out.println(this.getName() + " uses a Staff Hit! (Damage: " + damage + ")");
        }else {
            this.mana +=2;
            System.out.println(this.getName() + " has no mana! Recovers 2 mana.");
        }
        character.setHp(character.getHp() - damage);
    }
}
