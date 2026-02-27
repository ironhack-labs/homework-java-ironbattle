package IronBattle;

import java.util.UUID;

public  abstract class Character implements Attacker {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive=true;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.id = UUID.randomUUID().toString();
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
        this.hp = hp;

        if (this.hp <= 0) {
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
}
