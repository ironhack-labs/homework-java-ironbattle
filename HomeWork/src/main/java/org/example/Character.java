package org.example;
import java.util.Random;
import java.util.UUID;

public class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive=true;


    public Character(String name,int hp){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.hp=hp;
    }


    //setters
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setHp(int hp){
        this.hp=hp;
        if(hp<=0){
            this.hp=0;
            this.isAlive=false;
        }
    }
    public void setIsAlive(boolean alive){
        this.isAlive=alive;
    }

    //getters
    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public boolean getIsAlive(){
        return isAlive;
    }

}
