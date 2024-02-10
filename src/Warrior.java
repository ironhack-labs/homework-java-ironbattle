public class Warrior extends Character {

    private static final int MIN_HEALTH = 100;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STRENGTH = 1;
    private static final int MAX_STRENGTH = 10;
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        setStamina(Utils.generateRandomInt(MIN_STAMINA, MAX_STAMINA));
        setStrength(Utils.generateRandomInt(MIN_STRENGTH, MAX_STRENGTH));
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, Utils.validate(hp, MIN_HEALTH, MAX_HEALTH, Stats.Health, Characters.Warrior));
        setStamina(stamina);
        setStrength(strength);
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - Utils.generateRandomInt(1, 2));
    }


    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        Utils.validate(stamina, MIN_STAMINA, MAX_STAMINA, Stats.Stamina, Characters.Warrior);
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        Utils.validate(strength, MIN_STRENGTH, MAX_STRENGTH, Stats.Strength, Characters.Warrior);
        this.strength = strength;
    }

    @Override
    public String toString() {
        return String.format("<< Warrior >> %n " +
                        "Name: %s; " +
                        "Health: %d; " +
                        "Stamina: %d; " +
                        "Strength: %d%n",
                getName(), getHp(), getStamina(), getStrength());
    }
}
