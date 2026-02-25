package com.ironhack;

import java.util.UUID;

public abstract class Character {

    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int setHp(int hp) {
        this.hp = hp;

        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
        return hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}