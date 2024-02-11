import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    // Constructor
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    // Getters
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    // Setters
    public void setMana(int mana) {
        Random random = new Random();
        this.mana = random.nextInt(50) + 1;
    }

    public void setIntelligence(int intelligence) {
        Random random = new Random();
        this.intelligence = random.nextInt(10) + 1;
    }

    // Attack
    @Override
    public void attack(Character character) {

    }
}
