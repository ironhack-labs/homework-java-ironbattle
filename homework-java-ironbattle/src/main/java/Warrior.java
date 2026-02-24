import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100);
        Random random = new Random();
        this.stamina = random.nextInt(41) + 10;
        this.strength = random.nextInt(10) + 1;
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - strength);
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
}
