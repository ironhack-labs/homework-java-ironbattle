import java.util.UUID;
import java.util.Random;

public class Character {
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
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static Character createWarrior(String name) {
        Random rand = new Random();
        int hp = rand.nextInt(101) + 100; // Random hp between 100 and 200
        return new Character(name, hp);
    }

    public static Character createWizard(String name) {
        Random rand = new Random();
        int hp = rand.nextInt(51) + 50; // Random hp between 50 and 100
        return new Character(name, hp);
    }

    @Override
    public String toString() {
        return "Character{id='" + id + "', name='" + name + "', hp=" + hp + ", isAlive=" + isAlive + "}";
    }

    public static void main(String[] args) {
        Character warrior = Character.createWarrior("Thor");
        Character wizard = Character.createWizard("Gandalf");

        System.out.println(warrior);
        System.out.println(wizard);
    }
}