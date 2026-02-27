package IronBattle;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
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

    @Override
    public void attack(Character character) {
        int choice = (int) (Math.random() * 2);
        int damage=0;
        if (choice == 0 && mana >= 5) {
            mana -= 5;
            damage=intelligence;
//            character.setHp(character.getHp() - intelligence);
            System.out.println(getName() + " does  Fireball to " + character.getName());
        } else if (mana>0) {
//            character.setHp(character.getHp() - 2);
            mana += 1;
            damage=2;
            System.out.println(getName() + " does  Staff hit to " + character.getName());
        } else {
            mana += 2;
            System.out.println(getName() + " needs to recover ");
        }
        character.setHp(character.getHp()-damage);


    }
}
