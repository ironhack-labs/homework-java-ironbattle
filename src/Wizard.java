import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;

    public Wizard(String id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    @Override
    public void setHp(int hp) {
        if(hp <= 50 || hp >= 100){
            hp = hp;
        } else if (hp < 50) {
            hp = 50;
        } else {
            hp = 100;
        }
    }

    public void setHpAttack(int hp, int attack){
        hp -= attack;
    }

    public void setMana(int mana) {
        if(mana <= 10 || mana >= 50){
            this.mana = mana;
        } else if (mana < 10) {
            this.mana = 10;
        } else {
            this.mana = 50;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setIntelligence(int intelligence) {
        if(intelligence <= 1 || intelligence >= 50){
            this.intelligence = intelligence;
        } else if (intelligence < 1) {
            this.intelligence =  1;
        } else {
            this.intelligence = 50;
        };
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void Attack(Character x) {
        // Attack list
        List<String> Attacks = new ArrayList<>(2);
        Attacks.add("Fireball");
        Attacks.add("Staff Hit");

        // Generate random
        Random random = new Random();
        int randomIndex = random.nextInt(Attacks.size());
        String randomString = Attacks.get(randomIndex);

        if (randomString.equals("Fireball")) {
            if (mana >= 5) {
                x.receiveAttack(getIntelligence());
                setMana(getMana() - 5);
            } else {
                throw new IllegalArgumentException("Not capable of casting Fireball, Staff Hit instead");

            }
            randomString = "Staff Hit";
        }

        if (randomString.equals("Staff Hit")) {
            if (mana >= 2) {
                x.receiveAttack(2);
                setMana(getMana() + 1);
            } else {
                throw new IllegalArgumentException("Not capable of casting Staff Hit, Mana increase +2");
            }
            setMana(getMana() + 2);
        }
    }
}