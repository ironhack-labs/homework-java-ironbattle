package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Warrior extends Character implements Attacker {
    private int stamina = new Random().nextInt(10, 50);
    private int strength = new Random().nextInt(1, 10);

    public Warrior(String id, String name, int hp, boolean isAlive) {
        super(id, name, hp, isAlive);
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {
        if (stamina == 0) {
            setStamina(stamina + 2);
            System.out.println(getName()+" is recovering his stamina");
        }
        else if (stamina < 5) {
            setStamina(stamina -1);
            character.setHp(character.getHp()-strength/2);
            System.out.println(weakAttackInfo(character));
        }
        else if (new Random().nextBoolean()){
            setStamina(stamina -5);
            character.setHp(character.getHp()-strength);
            System.out.println(heavyAttackInfo(character));
        }
        else {
            setStamina(stamina -1);
            character.setHp(character.getHp()-strength/2);
            System.out.println(weakAttackInfo(character));
        }

}
    public String weakAttackInfo(Character character){
        return "Weak attack from warrior: "
                +character.getName()+"'s health is: "
                +character.getHp()+" ,"
                +getName()+"'s stamina is: "
                +getStamina();
    }
    public String heavyAttackInfo(Character character){
        return "Heavy attack from warrior: "
                +character.getName()+"'s health is: "
                +character.getHp()+" ,"
                +getName()+"'s stamina is: "
                +getStamina();
    }
        public int getStamina () {
            return stamina;
        }

        public void setStamina ( int stamina){
            this.stamina = stamina;
        }

        public int getStrength () {
            return strength;
        }

        public void setStrength ( int strength){
            this.strength = strength;
        }
}
