package Ironhack.schl;

import java.io.PrintStream;
import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return this.mana;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void attack(Character character) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean();
        if (this.mana < 5) {
            fireball = false;
        }

        int damage;
        if (fireball) {
            damage = this.intelligence;
            this.mana -= 5;
        } else if (this.mana < 1) {
            damage = 0;
            this.mana += 2;
        } else {
            damage = 2;
            ++this.mana;
        }

        character.takeDamage(damage);
        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println(var10001 + " attacks " + character.getName() + " for " + damage + " damage. (" + (fireball ? "Fireball" : "Staff hit") + ")");
    }
}
