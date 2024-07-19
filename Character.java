import java.util.UUID;

// Abstract class representing a generic character in the game
abstract class Character {
    // Private variables for character's attributes
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    // Constructor to initialize the character's name and hp
    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString(); // Generates a unique ID for each character
        this.name = name;
        this.hp = hp;
        this.isAlive = true; // Characters start as alive
    }

    // Getter method for id
    public String getId() {
        return id;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for hp
    public int getHp() {
        return hp;
    }

    // Setter method for hp, also updates isAlive status
    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0) {
            this.isAlive = false;
            this.hp = 0;
        }
    }

    // Getter method for isAlive
    public boolean isAlive() {
        return isAlive;
    }

    // Setter method for isAlive
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}