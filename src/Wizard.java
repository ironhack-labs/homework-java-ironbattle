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
                    character.setHp(character.getHp() - damage);
                    this.mana -= 5;
                    System.out.println(this.getName() + " executed a Fireball for " + damage + " points of damage!");
                } else {
                    // No mana for a Fireball, do a Staff hit instead
                    damage = 2;
                    character.setHp(character.getHp() - damage);
                    this.mana += 1;
                    System.out.println(this.getName() + " didn't have enough mana to execute a Fireball and executed a Staff Hit for " + damage + " points of damage instead. Also, mana has increased 1 point.");
                }
                break;

            case "staffHit":
                if (this.mana >= 5) {
                    damage = 2;
                    character.setHp(character.getHp() - damage);
                    this.mana += 1;
                    System.out.println(this.getName() + " executed a Staff Hit for " + damage + " points of damage! Mana increases 1 point.");
                } else {
                    this.mana +=2;
                    System.out.println(this.getName() + " didn't have enough mana to execute a Staff Hit. However, mana has increased 2 points.");
                }
                break;

            default:
                // If the action is neither "Fireball" nor "Staff hit" -> just for convention
                break;
        }
    }
}
