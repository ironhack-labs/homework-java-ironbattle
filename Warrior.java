import java.util.Random;

// Class representing a Warrior, inherits from Character and implements Attacker
class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    // Constructor to initialize the warrior's attributes
    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100); // HP between 100-200
        this.stamina = new Random().nextInt(41) + 10; // Stamina between 10-50
        this.strength = new Random().nextInt(10) + 1; // Strength between 1-10
    }

    // Getter method for stamina
    public int getStamina() {
        return stamina;
    }

    // Setter method for stamina
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Getter method for strength
    public int getStrength() {
        return strength;
    }

    // Setter method for strength
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Method to perform an attack on another character
    @Override
    public void attack(Character opponent) {
        Random rand = new Random();
        boolean heavyAttack = rand.nextBoolean(); // Randomly decide if the attack is heavy
        if (heavyAttack && this.stamina >= 5) {
            // Perform a heavy attack
            opponent.setHp(opponent.getHp() - this.strength);
            this.stamina -= 5;
            System.out.println(getName() + " performs a Heavy attack on " + opponent.getName());
        } else {
            // Perform a weak attack
            int damage = this.strength / 2;
            opponent.setHp(opponent.getHp() - damage);
            this.stamina += 1;
            System.out.println(getName() + " performs a Weak attack on " + opponent.getName());
        }
        System.out.println(opponent.getName() + " has " + opponent.getHp() + " HP left.");
    }
}