import java.util.Random;

public class Wizard extends Character {

    private int mana;
    private final int maxMana;
    private int intelligence;
    private Random random = new Random();

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.maxMana = mana;
        this.intelligence = intelligence;
    }


    public int getMana() { return mana; }

    public void setMana(int mana) { this.mana = mana; }

    public int getIntelligence() { return intelligence; }

    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    @Override
    public void attack(Character target) {
        boolean castFireball = random.nextBoolean();

        if (castFireball && mana >= 5) {
            int damage = intelligence;
            target.setHp(target.getHp() - damage);
            mana -= 5;
            System.out.println(getName() + " cast Fireball! Damage: " + damage + " | Mana left: " + mana);
        } else if (mana >= 1) {
            int damage = 2;
            target.setHp(target.getHp() - damage);
            mana += 1;
            System.out.println(getName() + " used Staff Hit! Damage: " + damage + " | Mana: " + mana);
        } else {
            mana += 2;
            System.out.println(getName() + " had no mana and recovered! Mana: " + mana);
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.mana = maxMana;
    }
}