// A Warrior is a Character that fights by attacking. Attacks inflict damage and in order to do one,
// stamina is required.
public class Warrior extends Character {
    private int stamina;
    private int strength;
    private final int STAMINA_MIN = 10;
    private final int STAMINA_MAX = 50;
    private final int STRENGTH_MIN = 1;
    private final int STRENGTH_MAX = 10;
    private final int HP_MIN = 100;
    private final int HP_MAX = 200;
    private final int HEAVY_ATTACK_STAMINA = 5;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if(stamina < STAMINA_MIN || stamina > STAMINA_MAX) {
            throw new IllegalArgumentException("Stamina must be between " + STAMINA_MIN + " and " + STAMINA_MAX);
        } else {
            this.stamina = stamina;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if(strength < STRENGTH_MIN || strength > STRENGTH_MAX) {
            throw new IllegalArgumentException("Strength must be between " + STRENGTH_MIN + " and " + STRENGTH_MAX);
        } else {
            this.strength = strength;
        }
    }

    public void setHp(int hp) {
        if(hp < HP_MIN || hp > HP_MAX) {
            throw new IllegalArgumentException("HP must be between " + HP_MIN + " and " + HP_MAX);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void attack(Character character) {
        if (getStamina() == 0) {
            setStamina(getStamina()+2);
        } else if (getStamina() < HEAVY_ATTACK_STAMINA) {
            weakAttack(character);
        } else {
            int randomNum = rollDice();

            if (randomNum < 4) {
                weakAttack(character);
            } else {
                heavyAttack(character);
            }
        }
    }

    public void heavyAttack(Character character) {
        setStamina(getStamina()-HEAVY_ATTACK_STAMINA);
        character.setHp(character.getHp()-getStrength());
    }

    public void weakAttack(Character character) {
        final int STAMINA_RECOVER = 1;
        final int HP_LOSS = getStrength()/2;

        setStamina(getStamina()+STAMINA_RECOVER);
        character.setHp(character.getHp()-HP_LOSS);
    }
}
