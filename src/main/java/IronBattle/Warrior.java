package IronBattle;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;

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

    @Override
    public void attack(Character character) {
        int choice = (int) (Math.random() * 2);
        int damage=0;
        if (choice == 0 && stamina >= 5) {
            stamina -= 5;
            damage=strength;
//            character.setHp(character.getHp() - strength);
            System.out.println(getName() + "  does Heavy attack to " + character.getName());

        } else if (stamina>0) {
            stamina += 1;
            damage=strength/2;
//            character.setHp(character.getHp() - strength / 2);
            System.out.println(getName() + "  does Weak attack  to " + character.getName());
        } else {
            stamina += 2;
            System.out.println(getName() + " needs to recover ");
        }
        character.setHp(character.getHp()-damage);

    }
}
