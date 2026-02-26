import java.util.UUID;

public abstract class Character implements Attacker {

    private String id;
    private String name;
    private int hp;
    private int maxHp;
    private boolean isAlive = true;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public boolean isAlive() { return isAlive; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAlive(boolean alive) { isAlive = alive; }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }


    public void reset() {
        this.hp = maxHp;
        this.isAlive = true;
    }
}