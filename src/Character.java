import java.util.Random;

public class Character {
    private String Id;
    private String name;
    private int hp;

    private boolean isAlive;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    this.isAlive = true;
    }
///getters
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getId() {
        return Id;
    }

    public boolean isAlive() {
        return isAlive;
    }
///setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public static int randomHp(String characterType){
        Random random = new Random();
        if(characterType.equals("warrior")){
            return random.nextInt(101) + 100;
        } else if (characterType.equals("wizard")) {
            return random.nextInt(51) + 50;
        } else{
            throw new IllegalArgumentException("Invalid Character Type");
        }

    }
}
