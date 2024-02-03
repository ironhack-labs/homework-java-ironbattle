//public class Warrior extends Character {
public class Warrior {
    private int stamina;
    private int strength;

    //public Warrior(String name, int hp, int stamina, int strength) {
    public Warrior(int stamina, int strength) {
        //super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    // Setters
    public void setStamina(int stamina) {
        if (stamina<10 || stamina>50) {
            this.stamina = -1;
            System.out.println("Invalid value for stamina");
        } else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength<1 || strength>10) {
            this.strength = -1;
            System.out.println("Invalid value for strength");
        } else {
            this.strength = strength;
        }
    }

    // Getters
    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void attack() {
        System.out.println("Warrior attacking method");
    }
}
