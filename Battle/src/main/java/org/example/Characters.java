package org.example;
import java.util.UUID;
public abstract class Characters {
    private final String id;
    private String name;
    private int hp;
    private boolean isAlive=true;
    public Characters(String name,int hp){
    this.id = UUID.randomUUID().toString();
    this.name=name;
    this.hp=hp;
    this.isAlive=true;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp=hp;
        if(this.hp<0) {
        this.hp=0;
        isAlive=false;
        }}
    public boolean getAlive(){return isAlive;}
    public void setAlive(boolean isAlive){
        this.isAlive=isAlive;
    }

}




