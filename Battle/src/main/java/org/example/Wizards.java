package org.example;
import java.util.concurrent.ThreadLocalRandom;
public class Wizards extends Characters implements Attacker {
    private int mana;
    private int intelligence;
    public  Wizards(String name){
        super(name,ThreadLocalRandom.current().nextInt(50,101));
        this.mana=ThreadLocalRandom.current().nextInt(10,51);
        this.intelligence=ThreadLocalRandom.current().nextInt(1,51);
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
    public void attack(Characters target) {
        int attackType = ThreadLocalRandom.current().nextInt(0, 2);

        if (attackType == 0 && this.mana >= 5) {
            int damage = this.intelligence;
            this.mana -= 5;
            target.setHp(target.getHp() - damage);
            System.out.println(getName() + " casts FIREBALL! Deals " + damage + " damage.");
        } else if (this.mana >= 1) {
            int damage = 2;
            this.mana += 1;
            target.setHp(target.getHp() - damage);
            System.out.println(getName() + " hits with STAFF! Deals " + damage + " damage.");
        } else {        this.mana += 2;
                        System.out.println(getName() + " out of mana! Recovers 2 mana.");
                    }
                }



    }

