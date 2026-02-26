package com.ironhack.model;

import java.util.Random;
import java.util.UUID;

public abstract class Character {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private int hp;
    private boolean isAlive = true;

    private final int initialHp;

    protected static final Random random = new Random(System.currentTimeMillis());

    protected Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.initialHp = hp;
    }

    public int getInitialHp() {
        return initialHp;
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

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
        if (this.hp == 0) setAlive(false);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
