package Ironhack.schl;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;
    private static final Random rand = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return this.stamina;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Character character) {
        Random rand = new Random();
        boolean heavyAttack = rand.nextBoolean();
        if (this.stamina < 5) {
            heavyAttack = false;
        }

        int damage;
        if (heavyAttack) {
            damage = this.strength;
            this.stamina -= 5;
        } else if (this.stamina < 1) {
            damage = 0;
            this.stamina += 2;
        } else {
            damage = this.strength / 2;
            ++this.stamina;
        }

        character.takeDamage(damage);
        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println(var10001 + " attacks " + character.getName() + " for " + damage + " damage. (" + (heavyAttack ? "Heavy" : "Weak") + " attack)");
    }
}

