import java.util.Random;

public class Warrior extends Character{
    // Constructors
    Warrior(String name) {
        super(name);

        Random rand = new Random();
        // Stamina initial value is a random int between 10 and 50
        setStamina(rand.nextInt(50 - 10 + 1) + 10);

        // Strength initial value is a random int between 1 and 10
        setStrength(rand.nextInt(10 - 1 + 1) + 1);
    }

    // Attributes
    private int stamina;
    private int strength;

    // Getters and Setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Methods
    public void attack(Character enemy) {
        if (getStamina() < 2) {
            recovery();
        } else if (getStamina() < 5) {
            weakAttack(enemy);
        } else {
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
                heavyAttack(enemy);
            } else {
                weakAttack(enemy);
            }
        }
    }

    private void heavyAttack(Character enemy) {
        // Attack enemy
        int attackStrength = getStrength();
        enemy.setHp(enemy.getHp() - attackStrength);

        // Log
        System.out.println(getName() + " heavy attacked " + enemy.getName() + " with " + attackStrength + " hp!");
    }

    private void weakAttack(Character enemy) {
        // Attack enemy
        int attackStrength = getStrength() / 2;
        enemy.setHp(enemy.getHp() - attackStrength);

        // Recover
        setStamina(getStamina() + 1);

        // Log
        System.out.println(getName() + " weak attacked " + enemy.getName() + " with " + attackStrength + " hp!");
    }

    private void recovery() {
        setStamina(getStamina() + 2);
    }
}
