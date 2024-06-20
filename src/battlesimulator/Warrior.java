package battlesimulator;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stam;
    private int str;

    public Warrior(String n, int h, int s, int t) {
        super(n, h);
        this.stam = s;
        this.str = t;
    }

    public int getStamina() { return stam; }
    public void setStamina(int stam) { this.stam = stam; }
    public int getStrength() { return str; }
    public void setStrength(int str) { this.str = str; }

    @Override
    public void attack(Character target) {
        Random r = new Random();
        boolean heavy = r.nextBoolean();

        if (heavy && stam >= 5) {
            target.setHp(target.getHp() - getStrength());
            stam -= 5;
            System.out.println(getName() + " heavy attack on " + target.getName());
        } else if (stam >= 1) {
            target.setHp(target.getHp() - (getStrength() / 2));
            stam += 1;
            System.out.println(getName() + " weak attack on " + target.getName());
        } else {
            stam += 2;
            System.out.println(getName() + " rests.");
        }
    }
}
