package model;

import utils.Characters;
import utils.Colors;
import utils.Stats;
import utils.Utils;

public class Warrior extends Character {

    private static final int MIN_HEALTH = 100;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_STRENGTH = 1;
    private static final int MAX_STRENGTH = 10;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STAMINA_FOR_A_HEAVY_ATTACK = 5;
    private static final int WEAK_ATTACK = 1;
    private static final int HEAVY_ATTACK = 2;
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        this.stamina = Utils.generateRandomInt(MIN_STAMINA, MAX_STAMINA);
        this.strength = Utils.generateRandomInt(MIN_STRENGTH, MAX_STRENGTH);
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, Utils.validate(hp, MIN_HEALTH, MAX_HEALTH, Stats.Health, Characters.Warrior));
        this.stamina = Utils.validate(stamina, MIN_STAMINA, MAX_STAMINA, Stats.Stamina, Characters.Warrior);
        this.strength = Utils.validate(strength, MIN_STRENGTH, MAX_STRENGTH, Stats.Strength, Characters.Warrior);
    }

    @Override
    public void attack(Character character) {
        if (stamina == 0) {
            setStamina(stamina + 2);
        } else if (stamina >= MIN_STAMINA_FOR_A_HEAVY_ATTACK) {
            switch (Utils.generateRandomInt(1, 2)) {
                case HEAVY_ATTACK -> heavyAttack(character);
                case WEAK_ATTACK -> weakAttack(character);
            }
        } else {
            weakAttack(character);
        }
    }

    private void weakAttack(Character character) {
        setStamina(stamina + 1);
        character.setHp(character.getHp() - this.strength / 2);
    }

    private void heavyAttack(Character character) {
        setStamina(stamina - 5);
        int updatedHp = character.getHp() - strength;
        character.setHp(Math.max(updatedHp, 0));
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, 0);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(strength, 0);
    }

    public void printStats() {
        System.out.printf("%s - health: %s %d %s stamina: %s%d%s",
                getName(), Colors.red.getCode(), getHp(), Colors.white.getCode(), Colors.green.getCode(), stamina, Colors.white.getCode());
    }

    @Override
    public String toString() {
        return String.format("<< Warrior >> %n " +
                        "Name: %s; " +
                        "Health: %d; " +
                        "Stamina: %d; " +
                        "Strength: %d%n",
                getName(), getHp(), stamina, strength);
    }
}
