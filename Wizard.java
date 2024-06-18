import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }
    // Getters and setters

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // Methods

    @Override
    public void attack(Character character) {
        Random random = new Random(); // Create a new random object.
        int choice = random.nextInt(2); // Randomly choose between 0 and 1

        if (choice == 0 && mana >= 5) { // Fireball
            mana -= 5; // Decrease mana by 5.
            int damage = intelligence;
            character.setHp(character.getHp() - damage);
            System.out.println(this.getName() + " casts a Fireball and deals " + damage + " damage to " + character.getName());
        } else if (mana >= 1) { // Staff hit
            mana += 1; // Increase mana by 1.
            int damage = 2;
            character.setHp(character.getHp() - damage);
            System.out.println(this.getName() + " hits with a staff and deals " + damage + " damage to " + character.getName());
        } else { // Not enough mana
            mana += 2; // Increase mana by 2.
            System.out.println(this.getName() + " does not have enough mana to attack");
        }
    }
}

}