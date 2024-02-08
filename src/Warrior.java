public class Warrior extends Character {

    private int stamina;
    private int strength;
    /*
    private static final int MIN_HEALTH = 100;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STRENGTH = 1;
    private static final int MAX_STRENGTH = 10;
    */

    public Warrior(String name) {
        super(name, Utils.generateRandomInt(100, 200));
        setStamina(Utils.generateRandomInt(10, 50));
        setStrength(Utils.generateRandomInt(1, 10));
        /*
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        setStamina(Utils.generateRandomInt(MIN_STAMINA, MAX_STAMINA));
        setStrength(Utils.generateRandomInt(MIN_STRENGTH, MAX_STRENGTH));
         */
    }

    @Override
    public void attack(Character character) {

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
