import java.util.Random;

public class Warrior extends Character {

    private int stamina;
    private int maxStamina;
    private int strength;
    private Random random = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.maxStamina = stamina;
        this.strength = strength;
    }

    public int getStamina() { return stamina; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    @Override
    public void attack(Character target) {
        boolean isHeavyAttack = random.nextBoolean();

        if (isHeavyAttack && stamina >= 5) {
            int damage = strength;
            target.setHp(target.getHp() - damage);
            stamina -= 5;
            System.out.println(getName() + " used Heavy Attack! Damage: " + damage + " | Stamina left: " + stamina);
        } else if (stamina >= 1) {
            int damage = strength / 2;
            target.setHp(target.getHp() - damage);
            stamina += 1;
            System.out.println(getName() + " used Weak Attack! Damage: " + damage + " | Stamina: " + stamina);
        } else {
            stamina += 2;
            System.out.println(getName() + " had no stamina and recovered! Stamina: " + stamina);
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.stamina = maxStamina;
    }
}