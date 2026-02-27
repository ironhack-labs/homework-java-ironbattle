package org.ironhack;

import java.io.Serializable;
import java.util.UUID;

public abstract class Character  {
    private final   String id;
    private String name;
    private int hp;
    private boolean isAlive=true;




    public Character(String name,int hp){
        this.id= UUID.randomUUID().toString();
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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHp(int hp) {
      this.hp = hp;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }else  {
            this.isAlive = true;
        }

    }
    public void attack(Character character) {
    }
}
