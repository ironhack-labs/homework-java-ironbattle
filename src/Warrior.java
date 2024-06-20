package src;

public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, (int) (Math.random() * 101) + 100);
        this.stamina = (int) (Math.random() * 41) + 10;
        this.strength = (int) (Math.random() * 10) + 1;
    }

    @Override
    public void attack(Character character) {
        int damage;
        if (stamina >= 5) {
            damage = strength;
            stamina -= 5;
        } else if (stamina >= 1) {
            damage = strength / 2;
            stamina += 1;
        } else {
            damage = 0;
            stamina += 2;
        }

        character.setHp(character.getHp() - damage);
        System.out.println(getName() + " attacks " + character.getName() + " for " + damage + " damage.");
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
