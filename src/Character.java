import java.util.UUID;

public abstract class Character implements Attacker {
    private final String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setHp(hp);
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
            hp = 0;
            setAlive(false);
        }
        this.hp = hp;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    abstract public void printStats();


}
