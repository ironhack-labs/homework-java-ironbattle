public class Warrior extends Character {

    private int stamina;
    private int strength;

    private static final int MIN_HEALTH = 100;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STRENGTH = 1;
    private static final int MAX_STRENGTH = 10;


    public Warrior(String name) {
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        setStamina(Utils.generateRandomInt(MIN_STAMINA, MAX_STAMINA));
        setStrength(Utils.generateRandomInt(MIN_STRENGTH, MAX_STRENGTH));
    }

    @Override
    public void attack(Character character) {

    }

    public void validateHealth(int health) {
        if (health < MIN_HEALTH || health > MAX_HEALTH) {
            throw new IllegalArgumentException("Warrior's health should be between " + MIN_HEALTH + " - " + MAX_HEALTH);
        }
    }

    public void validateStamina(int stamina) {
        if (stamina < MIN_STAMINA || stamina > MAX_STAMINA) {
            throw new IllegalArgumentException("Warrior's stamina should be between " + MIN_STAMINA + " - " + MAX_STAMINA);
        }
    }

    public void validateStrength(int strength) {
        if (strength < MIN_STRENGTH || strength > MAX_STRENGTH) {
            throw new IllegalArgumentException("Warrior's strength should be between " + MIN_STRENGTH + " - " + MAX_STRENGTH);
        }
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

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

    @Override
    public String toString() {
        return "<< Warrior >>" + "\n" +
                "Name: " + getName() + "\n" +
                "Health: " + getHp() + "\n" +
                "Stamina: " + stamina + "\n" +
                "Strength: " + strength;
    }
}
