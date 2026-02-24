import java.util.UUID;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp){
        this.id = UUID.randomUUID().toString();
        this.hp = hp;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public int getHp(){
        return hp;
    }
    public boolean isAlive(){
        return isAlive;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void setName(String name) {
        this.name = name;
    }
}
