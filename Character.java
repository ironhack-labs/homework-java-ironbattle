import java.util.UUID;

public abstract class Character {
    private final String id;
    private String name;
    private int hp;
    private boolean isAlive;

    //  For name and hp//
    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = isAlive;

    }
    public String getId() {
        return id;

    }
    public String getName() {
        return name;
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
        }
    }
    public void isAlive (boolean isAlive) {
        this.isAlive = isAlive;
    }



}
