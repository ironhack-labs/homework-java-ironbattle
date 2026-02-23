package com.ironhack;

import java.util.Random;

public abstract class Character {
    private final String id = randomId(); // using randomId() function for generating random id.
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character (String name, int hp){
        setName(name);
        setHp(hp);
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

    public abstract void setHp(int hp);
    protected void updateHp(int hp) {
        this.hp = hp;
        if (hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

//  Id randomizer function.
    private String randomId(){
        Random random = new Random();
        return Integer.toString(random.nextInt(12732173-0+1) + 0); //nextInt(max-min+1) + min)
    }
}
