import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    // Constructor
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    // Getters
    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    // Setters
    public void setStamina(int stamina) {
        Random random = new Random();
        this.stamina = random.nextInt(50) + 1;
    }

    public void setStrength(int strength) {
        Random random = new Random();
        this.strength = random.nextInt(10) + 1;
    }

    // Attack
    @Override
    public void attack(Character character) {

    }
}
