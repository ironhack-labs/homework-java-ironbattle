import java.util.UUID;

public abstract class Character implements Attacker{
    private final String id;
    private String name;
    private int hp;
    private boolean isAlive;

    // Constructor
    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        setName(name);
        setHp(hp);
        this.isAlive = true;
    }

    // Getters
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void attack(Character character) {

    }
}