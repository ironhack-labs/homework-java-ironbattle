package com.ironhack.homework;

public abstract class Character {
    private static int nextId = 0;
    private String id;
    private String name;
    private int hp;
    private boolean isAlive ;

    public Character(String name, int hp){
        id = String.valueOf(nextId++);
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public String getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
        if(this.hp == 0) setAlive(false);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
