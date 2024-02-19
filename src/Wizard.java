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
        Random random = new Random();
        String attackType;

        attackType = random.nextBoolean() ? "fireball" : "staffHit";
        int damage = 0;

        switch (attackType) {
            case "fireball":
                if (this.mana >= 5) {
                    damage = this.intelligence;
                    this.mana -= 5;
                } else if (this.mana <= 0) {
                    this.mana = 0; // No mana for Fireball
                } else {
                    // No mana for a Fireball, do a Staff hit instead
                    damage = 2;
                    this.mana += 1;
                }
                break;

            case "staffHit":
                if (this.mana >= 1) {
                    damage = 2;
                    this.mana += 1;
                } else {
                    this.mana += 2; // Recover stamina by 2 if not enough stamina for Staff hit
                }
                break;

            default:
                // If the action is neither "Fireball" nor "Staff hit" -> just for convention
                break;
        }
    }
}
