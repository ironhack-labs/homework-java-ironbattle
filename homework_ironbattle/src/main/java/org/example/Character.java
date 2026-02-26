package org.example;

import java.util.UUID;

public abstract class Character implements Attacker{
    private String id;
    private String name;
    private int hp;
    private boolean isAlive=true;
    public Character(String name,int health){
        this.name=name;
        this.hp=health;
        this.id= UUID.randomUUID().toString();
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public boolean isAlive(){
        return this.isAlive;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setHp(int hp){
        this.hp=hp;
        if(hp<=0){
            this.hp=0;
            this.isAlive=false;
        }
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive=isAlive;
    }
    public void setName(String name){
        this.name=name;
    }
}
