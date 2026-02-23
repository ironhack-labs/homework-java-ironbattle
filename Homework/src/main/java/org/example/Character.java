package org.example;

public class Character implements Attacker {
    private final String id;
    private  String name;
    private int hp;
    private boolean isAlive;
    public Character(String id, String name, int hp, boolean isAlive) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = isAlive;
    }

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.isAlive=true;
        this.id="N/A";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp<0) {this.hp=0;}
        else {this.hp = hp;}
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void attack(Character character) {

    }
}
