import java.util.Random;

// This Warrior class represents a warrior character in the game.
// It extends the Character class and implements the Attacker interface.
public class Warrior extends Character implements Attacker{
    // Stamina is used to perform attacks.
    private int stamina;
    // Strength determines the power of the warrior's attacks.
    private int strength;
    // Random number generator used for various random behaviors in methods.
    private static final Random rand = new Random();

    // Constructor for the Warrior class.
    // Initializes a new Warrior with the given name, hp, stamina, and strength.
    public Warrior(String name, int hp1, int i, int hp) {
        super(name, hp); // Call to the superclass constructor (Character)
        this.stamina = stamina; // Initialize the warrior's stamina
        this.strength = strength; // Initialize the warrior's strength
    }

    // Getter for stamina.
    public int getStamina() {
        return stamina;
    }

    // Getter for strength.
    public int getStrength() {
        return strength;
    }

    // Setter for stamina.
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Setter for strength.
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Character character) {
        Random rand = new Random();
        boolean heavyAttack = rand.nextBoolean();

        if (stamina < 5) {
            heavyAttack = false;
        }

        int damage;
        if (heavyAttack) {
            damage = strength;
            stamina -= 5;
        } else {
            if (stamina < 1) {
                damage = 0;
                stamina += 2;
            } else {
                damage = strength / 2;
                stamina += 1;
            }
        }

        character.takeDamage(damage);
        System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage. (" + (heavyAttack ? "Heavy" : "Weak") + " attack)");
    }
    }

