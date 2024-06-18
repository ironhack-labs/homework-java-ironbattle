import java.util.Random;
import java.util.UUID;

public class Character implements IAttacker{
    private String id;
    private String name;
    private int hp;
    private int originalHp;
    private boolean isAlive;

    //CONSTANTS FOR HP
    protected static final int WARRIOR_MIN_HP = 100;
    protected static final int WARRIOR_MAX_HP = 200;
    protected static final int WIZARD_MIN_HP = 50;
    protected static final int WIZARD_MAX_HP = 100;


    //CONSTRUCTOR
    public Character(String name, int hp) {
        setId(); //Auto-generated
        setName(name);
        setHp(hp);
        setOriginalHp(hp);
        setAlive(true);

    }

    protected int generateRandomHp() {
        return hp;
    }

    //GETTERS & SETTERS
    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString().substring(0, 5);
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
            setAlive(false);
        }
    }

    public int getOriginalHp() {
        return originalHp;
    }

    public void setOriginalHp(int originalHp) {
        this.originalHp = originalHp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void attack(Character character) {}

    //HP GETTERS
    public int getMinHp() { //Needs to be overwritten w/ proper constants
        return 0;
    }

    public int getMaxHp() { //Needs to be overwritten w/ proper constants
        return 0;
    }

    public static int generateRandomHp(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }

    public void reestablishHp() {
        setHp(getOriginalHp());
        setAlive(true);
    }

}

