package com.ironhack.homework;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;
    private int counter = 1;

    // extra hp variable
    private boolean isFirstSet = true;

    public Character(String name, int hp) {
        this.name = name;
        setHp(hp);
    }

    //setId is not necessary.
    public String getId() {
        return this.id = counter++ + "_" + getName() + "_level_" + getHp();
    }

    public void setId(String id) {
        this.id = id;
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
        if (isFirstSet) {
            this.hp = hp;
            isFirstSet = false;
        } else {
            this.hp = Math.max(hp, 0); // Prevents hp from being negative. If hp is less than 0, it sets hp to 0.
        }
    }

    public boolean isAlive() {
        if(this.hp <= 0) isAlive = false;
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isFirstSet(){
        return isFirstSet;
    }
}
