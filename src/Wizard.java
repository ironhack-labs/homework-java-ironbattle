public class Wizard extends Character implements Attacker {

    private final int MIN_HP_WIZARD = 50;
    private final int MAX_HP_WIZARD = 100;
    private final int MIN_MANA_WIZARD = 10;
    private final int MAX_MANA_WIZARD = 50;
    private final int MIN_INTELLIGENCE_WIZARD = 1;
    private final int MAX_INTELLIGENCE_WIZARD = 50;
    private final int MANA_TO_DECREASE_WHEN_FIREBALL = 5;
    private final int DAMAGE_INFLICTED_BY_STAFF_HIT = 2;
    private final int MANA_TO_DECREASE_WHEN_STAFF_HIT = 1;

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(20);
        setIntelligence(10);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        validateMana(mana);
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        validateIntelligence(intelligence);
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        int randomCast = 1;
        if (randomCast == 1) {
            castFireball(character);
        }  else {
            castStaffHit(character);
        }
    }

    private void castFireball(Character character) {
        character.setHp(character.getHp() - this.intelligence);
        this.setMana(this.getMana() - MANA_TO_DECREASE_WHEN_FIREBALL);
    }

    private void castStaffHit(Character character) {
        character.setHp(character.getHp() - DAMAGE_INFLICTED_BY_STAFF_HIT);
        this.setMana(this.getMana() - MANA_TO_DECREASE_WHEN_STAFF_HIT);
    }

    public void validateMana(int mana) {
        if (mana < MIN_MANA_WIZARD || mana > MAX_MANA_WIZARD) {
            throw new IllegalArgumentException("El mana debe estar entre " + MIN_MANA_WIZARD + " y " + MAX_MANA_WIZARD);
        }
    }

    public void validateIntelligence(int intelligence) {
        if (intelligence < MIN_INTELLIGENCE_WIZARD || intelligence > MAX_INTELLIGENCE_WIZARD) {
            throw new IllegalArgumentException("La inteligencia del Wizard debe estar entre " + MIN_INTELLIGENCE_WIZARD + " y " + MAX_INTELLIGENCE_WIZARD);
        }
    }

    public void validateHp(int hp) {
        if (hp < MIN_HP_WIZARD || hp > MAX_HP_WIZARD) {
            throw new IllegalArgumentException("hp (health points) debe estar entre " + MIN_HP_WIZARD + " y " + MAX_HP_WIZARD);
        }
    }

    @Override
    public void setHp(int hp) {
        validateHp(hp);
        super.setHp(hp);
    }

}
