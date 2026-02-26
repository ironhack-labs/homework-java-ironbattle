package com.example;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive=true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id==null){
            throw new NullPointerException("The id cannot be null");
        }
        else{
            this.id=id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null){
            throw new NullPointerException("The name cannot be null");
        }
        else{
            this.name = name;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0,hp);
        if(this.hp==0){this.isAlive=false;}
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
       this.isAlive = alive;
    }

    public Character(String name, int hp) {
        this.id=super.toString();
        this.name = name;
        this.hp = hp;
    }
}
