package com.ironhack;

import java.util.UUID;

public class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name,int hp){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.hp=hp;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }

    public boolean getIsAlive(){
        return isAlive;
    }


    public void setName(String name){
        this.name=name;
    }


    public void setHp(int hp){
        this.hp=hp;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }
}
