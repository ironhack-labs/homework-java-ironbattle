import java.util.Random;

public class Warrior extends Character implements IAttacker {
    private int stamina;
    private int strength;

    //    CONSTRUCTOR
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    //    GETTERS
    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    //    SETTERS
    public void setStamina(int stamina) {
        Random random = new Random();
        this.stamina = new Random().nextInt(41) + 10;
    }

    public void setStrength(int strength) {
        Random random = new Random();
        this.strength = new Random().nextInt(10) + 1;
    }


    @Override
    public void attack(Character character) {
        Random random = new Random();
        String attackType;

        attackType = random.nextBoolean() ? "lightAttack" : "heavyAttack";
        int damage;

        switch (attackType) {
            case "lightAttack":
                damage = this.strength / 2;
                character.setHp(character.getHp() - damage);
                System.out.println("Warrior " + this.getName() + " executed a Weak Attack for " + damage + " points of damage! Stamina increases 1 point.");
                break;

            case "heavyAttack":
                if (this.stamina >= 5) {
                    damage = this.strength;
                    character.setHp(character.getHp() - damage);
                    this.stamina -= 5;
                    System.out.println("Warrior " + this.getName() + " attacked " + character.getName() + " for " + damage + " damage!");
                } else if (this.stamina <= 0) {
                    this.stamina += 2;
                    System.out.println("Warrior " + this.getName() + " is out of stamina! Warrior's stamina has been restored by 2 points!");
                } else {
                    // If Warrior is too weak to do a heavy attack, do a light attack instead
                    damage = this.strength / 2;
                    character.setHp(character.getHp() - damage);
                    System.out.println("Warrior " + this.getName() + " executed a Weak Attack for " + damage + " points of damage! Stamina increases 1 point.");
                }
                break;

            default:
                break;
        }
    }
}