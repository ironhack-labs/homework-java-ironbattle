package org.example;

import java.util.Random;
import java.util.Scanner;

public class Wizard extends Character implements Attacker{

    private int mana= new Random().nextInt(10,50);
    private int intelligence= new Random().nextInt(1,50);
    public Wizard(String id, String name, int hp, boolean isAlive) {
        super(id, name, hp, isAlive);
    }

    public Wizard(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.mana = stamina;
        this.intelligence = strength;
    }

    @Override
    public void attack(Character character) {
        if (mana == 0) {
            setMana(mana + 2);
            System.out.println(getName()+" is recovering his stamina");
        }
        else if (mana < 5) {
            setMana(mana -1);
            character.setHp(character.getHp()-2);
            System.out.println(staffHitInfo(character));
        }
        else if (new Random().nextBoolean()){
            setMana(mana -5);
            character.setHp(character.getHp()-intelligence);
            System.out.println(fireballInfo(character));
        }
        else {
            setMana(mana -1);
            character.setHp(character.getHp()-2);
            System.out.println(staffHitInfo(character));
        }

    }
    public String fireballInfo(Character character){
        return "Fireball from wizard: "
                +character.getName()+"'s health is: "
                +character.getHp()+" ,"
                +getName()+"'s mana is: "
                +getMana();
    }
    public String staffHitInfo(Character character){
        return "Staff Hit from wizard: "
                +character.getName()+"'s health is: "
                +character.getHp()+" ,"
                +getName()+"'s mana is: "
                +getMana();
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
}


