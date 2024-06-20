import java.util.UUID;
import java.util.Random;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true; // Default to true
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

    public boolean getIsAlive() {
        return isAlive;
    }

    // Public setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
        this.hp = hp;
        if (this.hp <= 0) {
            this.isAlive = false;
            this.hp = 0;
        }
    }

    public void takeDamage(int damage) {
        setHp(this.hp - damage);
    }

    @Override
    public String toString() {
        return "Character{id='" + id + "', name='" + name + "', hp=" + hp + ", isAlive=" + isAlive + "}";
    }

    public boolean isAlive() {
        return false;
    }

    public void attack(Character character){

    }
}