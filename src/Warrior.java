import java.util.Random;

public class Warrior extends Character {
    private int strength;
    private int stamina;

    public Warrior(String name, int hp, int strength, int stamina) {
        super(name, hp);
        this.strength = strength;
        this.stamina = stamina;
    }

    public void performRound() {
        Random random = new Random();
        boolean isHeavyAttack = random.nextBoolean(); // Randomly choose Heavy or Weak attack

        if (this.stamina <= 0){
            rest();
        } else if (isHeavyAttack && this.stamina >= 5) {
            performHeavyAttack();
        } else {
            performWeakAttack();
        }
    }

    private void performHeavyAttack() {
        System.out.println("Warrior performs Heavy attack with damage: " + strength);
        this.stamina -= 5;
    }

    private void performWeakAttack() {
        int damage = strength / 2;
        System.out.println("Warrior performs Weak attack with damage: " + damage);
        this.stamina = Math.min(100, this.stamina + 1); // Ensure stamina does not exceed 100
    }

    public void rest() {
    this.stamina += 2;
    }

    public int getStamina() {
        return stamina;
    }

    public void attack(Character character) {
        performRound();

    }
}
