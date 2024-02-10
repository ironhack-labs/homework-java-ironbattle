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
    private static final int CONST_FOR_STAFF_HIT = 1;

    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, Utils.generateRandomInt(MIN_HEALTH, MAX_HEALTH));
        setMana(Utils.generateRandomInt(MIN_MANA, MAX_MANA));
        setIntelligence(Utils.generateRandomInt(MIN_INTELLIGENCE, MAX_INTELLIGENCE));
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    @Override
    public void attack(Character character) {
        if (this.getMana() >= MANA_TO_DECREASE_WHEN_FIREBALL && Utils.generateRandomInt(
          , CONST_FOR_STAFF_HIT) == CONST_FOR_FIREBALL) {
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
        Utils.validate(mana, MIN_MANA, MAX_MANA, Stats.Mana, Characters.Wizard);
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        Utils.validate(intelligence, MIN_INTELLIGENCE, MAX_INTELLIGENCE, Stats.Intelligence, Characters.Wizard);
        this.intelligence = intelligence;
    }

    @Override
    public void setHp(int hp) {
        Utils.validate(hp, MIN_HEALTH, MAX_HEALTH, Stats.Health, Characters.Wizard);
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
