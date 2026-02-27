package ironhack.Characters;

import java.util.Random;

public class Warrior extends Character {
    private int stamina;
    private int strength;
    private final Random random = new Random();

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina > 50 || stamina < 10) {
            throw new IllegalArgumentException("Stamina should be between 10 and 50!");
        }
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength > 10 || strength < 1) {
            throw new IllegalArgumentException("Strength should be between 1 and 10!");
        }
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {

        WarriorAttackType chosenAttack =
                random.nextBoolean() ? WarriorAttackType.HEAVY : WarriorAttackType.WEAK;

        if (chosenAttack == WarriorAttackType.HEAVY && stamina < WarriorAttackType.HEAVY.getStaminaCost()) {
            chosenAttack = WarriorAttackType.WEAK;
        }

        if (chosenAttack == WarriorAttackType.WEAK && stamina <= 0) {
            System.out.println(getName() + " is too exhausted and recovers 2 stamina...");
            stamina += 2;
            return;
        }

        if (chosenAttack == WarriorAttackType.HEAVY) {
            character.setHp(character.getHp() - strength);
            stamina -= WarriorAttackType.HEAVY.getStaminaCost();

            System.out.println(
                    getName() + " performs a HEAVY attack for " + strength + " damage!"
            );
        } else {
            int damage = strength / 2;
            character.setHp(character.getHp() - damage);
            stamina += 1;

            System.out.println(
                    getName() + " performs a WEAK attack for " + damage + " damage!"
            );
        }
    }
}
