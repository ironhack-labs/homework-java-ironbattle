package ironhack.Characters;

import java.util.Random;

public class Wizard extends Character {
    private int mana;
    private int intelligence;
    private final Random random = new Random();

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMana(int mana) {
        if (mana > 50 || mana < 10) {
            throw new IllegalArgumentException("Stamina should be between 10 and 50!");
        }
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence > 50 || intelligence < 10) {
            throw new IllegalArgumentException("Intelligence should be between 10 and 50!");
        }
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {

        WizardAttackType chosenAttack =
                random.nextBoolean() ? WizardAttackType.FIREBALL : WizardAttackType.STAFF_HIT;

        if (chosenAttack == WizardAttackType.FIREBALL && mana < WizardAttackType.FIREBALL.getManaCost()) {
            chosenAttack = WizardAttackType.STAFF_HIT;
        }

        if (chosenAttack == WizardAttackType.STAFF_HIT && mana <= 0) {
            mana += 2;
            System.out.println(getName() + " is out of mana and recovers 2 mana...");
            return;
        }

        if (chosenAttack == WizardAttackType.FIREBALL) {
            character.setHp(character.getHp() - intelligence);
            mana -= WizardAttackType.FIREBALL.getManaCost();

            System.out.println(
                    getName() + " casts FIREBALL for " + intelligence + " damage!"
            );
        } else {
            int damage = 2;
            character.setHp(character.getHp() - damage);
            mana += 1;

            System.out.println(
                    getName() + " performs a STAFF HIT for " + damage + " damage!"
            );
        }
    }
}