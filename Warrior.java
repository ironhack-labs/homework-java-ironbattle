import java.io.Serializable;
import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name)  {
        super( name,new Random().nextInt(101) + 100);
        this.stamina = new Random().nextInt(41) + 10;
        this.strength = new Random().nextInt(10) + 1;
    }
    public int getStamina() {
        return stamina;
    }
    public int getStrength() {
        return strength;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void attack(Character target) {
        Random r = new Random();
        boolean heavyAttack = r.nextBoolean();
        int damage = heavyAttack ? strength : (int) Math.floor(strength / 2.0);
        if (heavyAttack && stamina  >= 5) {
            target.setHp(target.getHp() - damage);
            stamina -= 5;

        } else if ( stamina >= 1) {
            target.setHp(target.getHp() - damage);
            stamina += 1;
        } else {
            stamina += 2;
        }
        if (target.getHp() <= 0) {
            target.isAlive(false);

        }

    }

}
