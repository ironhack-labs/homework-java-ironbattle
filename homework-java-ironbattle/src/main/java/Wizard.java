public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.intelligence = intelligence;
        this.mana = mana;
    }

    @Override
    public void attack(Character character) {
        character.setHp(this.hp - intelligence);
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }
}
