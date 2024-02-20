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
        int damage;

        switch (attackType) {
            case "heavyAttack":
                if (this.stamina >= 5) {
                    damage = this.strength;
                    character.setHp(character.getHp() - damage);
                    this.stamina -= 5;
                    System.out.println(this.getName() + " executed a Heavy Attack for " + damage + " points of damage!");
                } else if (this.stamina <= 0) {
                    this.stamina += 2;
                    System.out.println(this.getName() + " didn't have stamina! Stamina increased by 2 and is now " + this.getStamina()+ "!");
                } else {
                    // No stamina for a Heavy attack, do a Weak attack instead
                    damage = this.strength / 2;
                    character.setHp(character.getHp() - damage);
                    this.stamina += 1;
                    System.out.println(this.getName() + " executed a Weak Attack for " + damage + " points of damage! Stamina increases 1 point.");
                }
                break;

            case "weakAttack":
                    damage = this.strength / 2;
                    character.setHp(character.getHp() - damage);
                    this.stamina += 1;
                    System.out.println(this.getName() + " executed a Weak Attack for " + damage + " points of damage! Stamina increases 1 point.");
                break;

            default:
                // If the action is neither "heavyAttack" nor "weakAttack" -> just for convention
                break;
        }
    }
}
