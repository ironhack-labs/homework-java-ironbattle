package battlesimulator;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intel;

    public Wizard(String n, int h, int m, int i) {
        super(n, h);
        this.mana = m;
        this.intel = i;
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getIntelligence() { return intel; }
    public void setIntelligence(int intel) { this.intel = intel; }

    @Override
    public void attack(Character target) {
        Random r = new Random();
        boolean fireball = r.nextBoolean();

        if (fireball && mana >= 5) {
            target.setHp(target.getHp() - getIntelligence());
            mana -= 5;
            System.out.println(getName() + " casts fireball at " + target.getName());
        } else if (mana >= 1) {
            target.setHp(target.getHp() - 2);
            mana += 1;
            System.out.println(getName() + " hits with staff " + target.getName());
        } else {
            mana += 2;
            System.out.println(getName() + " rests.");
        }
    }
}
