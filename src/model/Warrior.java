package model;

import utils.*;

public class Warrior extends Character {

    private static final int MIN_HEALTH = 100;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_STRENGTH = 1;
    private static final int MAX_STRENGTH = 10;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STAMINA_FOR_A_HEAVY_ATTACK = 5;
    private static final int STAMINA_TO_RECOVER_WHEN_NOT_ENOUGH = 2;
    private static final int STAMINA_TO_DECREASE_WHEN_HEAVY_ATTACK = 5;
    private static final int STAMINA_TO_RECOVER_WHEN_WEAK_ATTACK = 1;
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
        super(name, Utils.validate(hp, MIN_HEALTH, MAX_HEALTH, Stats.HEALTH, CharacterType.WARRIOR));
        this.stamina = Utils.validate(stamina, MIN_STAMINA, MAX_STAMINA, Stats.STAMINA, CharacterType.WARRIOR);
        this.strength = Utils.validate(strength, MIN_STRENGTH, MAX_STRENGTH, Stats.STRENGTH, CharacterType.WARRIOR);
    }

    @Override
    public void attack(Character character) {
        if (stamina == 0) {
            stamina += STAMINA_TO_RECOVER_WHEN_NOT_ENOUGH;
            System.out.printf("%s does not have enough stamina to attack, so recover stamina%n", character.getName());
        } else if (stamina >= MIN_STAMINA_FOR_A_HEAVY_ATTACK) {
            switch (Utils.generateRandomInt(WEAK_ATTACK, HEAVY_ATTACK)) {
                case HEAVY_ATTACK -> heavyAttack(character);
                case WEAK_ATTACK -> weakAttack(character);
            }
        } else {
            weakAttack(character);
        }
    }

    private void weakAttack(Character character) {
        int attack = strength / 2;
        character.setHp(character.getHp() - attack);
        stamina += STAMINA_TO_RECOVER_WHEN_WEAK_ATTACK;
        System.out.printf("%s perform a weak attack%n", character.getName());
    }

    private void heavyAttack(Character character) {
        int attack = strength;
        int updatedHp = character.getHp() - attack;
        character.setHp(Math.max(updatedHp, 0));
        setStamina(stamina - STAMINA_TO_DECREASE_WHEN_HEAVY_ATTACK);
        System.out.printf("%s perform a heavy attack%n", character.getName());
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    public int getStamina() {
        return stamina;
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
        System.out.printf("health: %s %d %s stamina: %s%d%s",
                Color.RED.getCode(), getHp(), Color.WHITE.getCode(),
                Color.GREEN.getCode(), stamina, Color.WHITE.getCode());
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
