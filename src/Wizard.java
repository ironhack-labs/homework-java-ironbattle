public class Wizard extends Character implements Attacker {

    private final int MIN_HP_WIZARD = 50;
    private final int MAX_HP_WIZARD = 100;

    private int stamina;
    private int strength;

    public Wizard(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
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
    public void attack(Character character) {

    }

    public void validateHp(int hp) {
        if (hp < MIN_HP_WIZARD && hp > MAX_HP_WIZARD) {
            throw new IllegalArgumentException("hp (health points) debe estar entre " + MIN_HP_WIZARD + " y " + MAX_HP_WIZARD);
        }
    }

    @Override
    public void setHp(int hp) {
        validateHP(hp);
        super.hp = hp;
    }

}
