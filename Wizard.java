import java.io.Serializable;
import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50);
        this.mana = new Random().nextInt(41) + 10;
        this.intelligence = new Random().nextInt(50) + 1;
    }
    public int getMana() {
        return mana;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void attack(Character target) {
        Random r = new Random();
        boolean fireball = r.nextBoolean();
        int damage = fireball ? this.intelligence : 2;
        if (fireball && mana >= 5) {
            target.setHp(target.getHp() - damage);
            mana -= 5;
        } else if (mana >= 1) {
            target.setHp(target.getHp() - damage);
            mana += 1;
        } else {
            mana += 2;
        }
        if (target.getHp() <= 0) {
            target.isAlive(false);

        }

    }

}
