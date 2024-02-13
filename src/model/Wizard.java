package model;

import utils.Characters;
import utils.Colors;
import utils.Stats;
import utils.Utils;

public class Wizard extends Character implements Attacker {

    private static final int MIN_HEALTH = 50;
    private static final int MAX_HEALTH = 100;
    private static final int MIN_MANA = 10;
    private static final int MAX_MANA = 50;
    private static final int MIN_INTELLIGENCE = 1;
    private static final int MAX_INTELLIGENCE = 50;
    private static final int MANA_TO_DECREASE_WHEN_FIREBALL = 5;
    private static final int DAMAGE_INFLICTED_BY_STAFF_HIT = 2;
    private static final int MANA_TO_DECREASE_WHEN_STAFF_HIT = 1;
    private static final int CONST_FOR_FIREBALL = 0;
    private int mana;
    private final int intelligence;

    public Wizard(String name) {
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        this.mana = Utils.generateRandomInt(MIN_MANA, MAX_MANA);
        this.intelligence = Utils.generateRandomInt(MIN_INTELLIGENCE, MAX_INTELLIGENCE);
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, Utils.validate(hp, MIN_HEALTH, MAX_HEALTH, Stats.Health, Characters.Wizard));
        this.mana = Utils.validate(mana, MIN_MANA, MAX_MANA, Stats.Mana, Characters.Wizard);
        this.intelligence = Utils.validate(intelligence, MIN_INTELLIGENCE, MAX_INTELLIGENCE, Stats.Intelligence, Characters.Wizard);
    }

    @Override
    public void attack(Character character) {
        character.setHp(character.getHp() - Utils.generateRandomInt(1, 2));
        if (this.getMana() >= MANA_TO_DECREASE_WHEN_FIREBALL
                && Utils.generateRandomInt(1, 2) == CONST_FOR_FIREBALL) {
            castFireball(character);
        } else {
            castStaffHit(character);
        }
    }

    private void castFireball(Character character) {
        character.setHp(character.getHp() - this.intelligence);
        this.setMana(this.getMana() - MANA_TO_DECREASE_WHEN_FIREBALL);
    }

    private void castStaffHit(Character character) {
        character.setHp(character.getHp() - DAMAGE_INFLICTED_BY_STAFF_HIT);
        this.setMana(this.getMana() + MANA_TO_DECREASE_WHEN_STAFF_HIT);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana, 0);
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    public void printStats() {
        System.out.printf("%s - health: %s %d %s mana: %s%d%s",
                getName(), Colors.red.getCode(), getHp(), Colors.white.getCode(), Colors.green.getCode(), mana, Colors.white.getCode());
    }

    @Override
    public String toString() {
        return String.format("<< Wizard >> %n " +
                        "Name: %s; " +
                        "Health: %d; " +
                        "Mana: %d; " +
                        "Intelligence: %d%n",
                getName(), getHp(), mana, intelligence);
    }

}
