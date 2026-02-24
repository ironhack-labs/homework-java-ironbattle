import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, new Random().nextInt(51) + 50);
        Random random = new Random();
        this.intelligence = random.nextInt(41) + 10;
        this.mana = random.nextInt(50) + 1;
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - intelligence);
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }
}
