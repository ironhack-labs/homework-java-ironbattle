import java.util.Random;

public class Wizard extends Character {

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp1, int i, int hp) {
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

    public void attack(Character character) {
        Random rand = new Random();
        boolean fireball = rand.nextBoolean();

        if (mana < 5) {
            fireball = false;
        }

        int damage;
        if (fireball) {
            damage = intelligence;
            mana -= 5;
        } else {
            if (mana < 1) {
                damage = 0;
                mana += 2;
            } else {
                damage = 2;
                mana += 1;
            }
        }

        character.takeDamage(damage);
        System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage. (" + (fireball ? "Fireball" : "Staff hit") + ")");
    }
}
