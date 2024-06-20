package src;

import java.util.Random;

public class Wizard extends Character {
    private int mana;
    private int intelligence;
    private Random random;

    public Wizard(String name) {
        super(name, (int) (Math.random() * 51) + 50);
        this.mana = (int) (Math.random() * 41) + 10;
        this.intelligence = (int) (Math.random() * 50) + 1;
        this.random = new Random();
    }

    @Override
    public void attack(Character character) {
        randomWizardAttack(character);
    }

    private void randomWizardAttack(Character character) {
        if (mana >= 5) {
            if (random.nextBoolean()) {
                castFireball(character);
            } else {
                staffHit(character);
            }
        } else if (mana >= 1) {
            staffHit(character);
        } else {
            noManaToAttack();
        }
    }

    private void castFireball(Character character) {
        System.out.println(getName() + " casts Fireball.");
        mana -= 5;
        int damage = intelligence;
        character.setHp(character.getHp() - damage);
        checkIfCharacterIsAlive(character);
    }

    private void staffHit(Character character) {
        System.out.println(getName() + " hits with Staff.");
        mana += 1;
        int damage = 2;
        character.setHp(character.getHp() - damage);
        checkIfCharacterIsAlive(character);
    }

    private void noManaToAttack() {
        System.out.println(getName() + " has no mana left to attack.");
        mana += 2;
    }

    private void checkIfCharacterIsAlive(Character character) {
        if (character.getHp() <= 0) {
            character.setAlive(false);
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}


