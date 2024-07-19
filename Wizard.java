import java.util.Random;

// Class representing a Wizard, inherits from Character and implements Attacker
class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    // Constructor to initialize the wizard's attributes
    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50); // HP between 50-100
        this.mana = new Random().nextInt(41) + 10; // Mana between 10-50
        this.intelligence = new Random().nextInt(50) + 1; // Intelligence between 1-50
    }

    // Getter method for mana
    public int getMana() {
        return mana;
    }

    // Setter method for mana
    public void setMana(int mana) {
        this.mana = mana;
    }

    // Getter method for intelligence
    public int getIntelligence() {
        return intelligence;
    }

    // Setter method for intelligence
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // Method to perform an attack on another character
    @Override
    public void attack(Character opponent) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean(); // Randomly decide if the attack is a fireball
        if (fireball && this.mana >= 5) {
            // Cast a fireball
            opponent.setHp(opponent.getHp() - this.intelligence);
            this.mana -= 5;
            System.out.println(getName() + " casts a Fireball on " + opponent.getName());
        } else {
            // Perform a staff hit
            opponent.setHp(opponent.getHp() - 2);
            this.mana += 1;
            System.out.println(getName() + " hits with Staff on " + opponent.getName());
        }
        System.out.println(opponent.getName() + " has " + opponent.getHp() + " HP left.");
    }
}