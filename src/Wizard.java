public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    private static final int MIN_HEALTH = 50;
    private static final int MAX_HEALTH = 100;
    private static final int MIN_MANA = 10;
    private static final int MAX_MANA = 50;
    private static final int MIN_INTELLIGENCE = 1;
    private static final int MAX_INTELLIGENCE = 50;
    private static final int MANA_TO_DECREASE_WHEN_FIREBALL = 5;
    private static final int DAMAGE_INFLICTED_BY_STAFF_HIT = 2;
    private static final int MANA_TO_DECREASE_WHEN_STAFF_HIT = 1;


    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(Utils.generateRandomInt(MIN_MANA, MAX_MANA));
        setIntelligence(Utils.generateRandomInt(MIN_INTELLIGENCE, MAX_INTELLIGENCE));
    }

    @Override
    public void attack(Character character) {

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
        if (mana < MIN_MANA || mana > MAX_MANA) {
            throw new IllegalArgumentException("Wizard's nana should be between " + MIN_MANA + " - " + MAX_MANA);
        }
    }

    public void validateIntelligence(int intelligence) {
        if (intelligence < MIN_INTELLIGENCE || intelligence > MAX_INTELLIGENCE) {
            throw new IllegalArgumentException("Wizard's intelligence should be between " + MIN_INTELLIGENCE + " - " + MAX_INTELLIGENCE);
        }
    }

    public void validateHp(int hp) {
        if (hp < MIN_HEALTH || hp > MAX_HEALTH) {
            throw new IllegalArgumentException("hp (health points) debe estar entre " + MIN_HEALTH + " y " + MAX_HEALTH);
        }
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
    public void setHp(int hp) {
        validateHp(hp);
        super.setHp(hp);
    }

    @Override
    public String toString() {
        return "<< Wizard >>" + "\n" +
                "Name: " + getName() + "\n" +
                "Health: " + getHp() + "\n" +
                "Mana: " + mana + "\n" +
                "Intelligence: " + intelligence;
    }
}
