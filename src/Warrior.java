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
        Random random = new Random();
        String attackType;

        attackType = random.nextBoolean()? "heavyAttack" : "weakAttack";
        int damage = 0;

        switch (attackType) {
            case "heavyAttack":
                if (this.stamina >= 5) {
                    damage = this.strength;
                    this.stamina -= 5;
                } else if (this.stamina <= 0) {
                    this.stamina = 0; // No stamina for heavy attack
                } else {
                    // No stamina for a Heavy attack, do a Weak attack instead
                    damage = this.strength / 2;
                    this.stamina += 1;
                }
                break;

            case "weakAttack":
                if (this.stamina >= 1) {
                    damage = this.strength / 2;
                    this.stamina += 1;
                } else {
                    this.stamina += 2; // Recover stamina by 2 if not enough stamina for weak attack
                }
                break;

            default:
                // If the action is neither "heavyAttack" nor "weakAttack" -> just for convention
                break;
        }
    }
}
