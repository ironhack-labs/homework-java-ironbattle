import java.util.Random;

public class Character {
    private String id ;
    private String name ;
    private int hp;
    boolean isAlive = true;

    public Character() {
    }

    public Character( String name, int hp) {
        Random random = new Random();
        this.id ="CHAR-" + random.nextInt(1000);
        this.name = name;
        this.hp = hp;
    }


    public Character(String hen, int i, int i1) {

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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return !isAlive;
    }


}
