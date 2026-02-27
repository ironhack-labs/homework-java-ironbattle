package com.ironhack;

public abstract class Character {
    private String id;
    private String name;
    private int hp; //random 100-200 for warriors,50-100 for wizards
    private boolean isAlive = true;



    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;

    }

    public String getId() {
        return id;
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
        if (hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        } else {
            this.hp = hp;
        }
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
