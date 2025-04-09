import java.util.UUID;

public class Character {

    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {

        setName(name);
        setHp(hp);
        setId();
        setAlive(true);
    }

    public Character(String name) {
        setName(name);
        setId();
        setAlive(true);
    }
    public Character() {

    }

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
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
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void attack(Character character) {
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }

}
