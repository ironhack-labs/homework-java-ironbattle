package org.ironhack.homework;

import java.util.UUID;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public boolean getIsAlive() { return isAlive; }


    public void setName(String name) { this.name = name; }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
        if (this.hp == 0) this.isAlive = false;
    }

    public void setIsAlive(boolean isAlive) { this.isAlive = isAlive; }
}