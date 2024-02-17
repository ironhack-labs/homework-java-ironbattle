public class Warrior extends Character {
    // Attributes
    private int stamina;
    private int strength;

    // Constructors
    Warrior(String name) {
        super(name, 1);

        // HP initial value is a random int between 100 and 200
        int hpMin = 100;
        int hpMax= 200;
        setHp(Randomizer.getRandomInt(hpMin, hpMax));

        // Stamina initial value is a random int between 10 and 50
        int staminaMin = 10;
        int staminaMax = 50;
        setStamina(Randomizer.getRandomInt(staminaMin, staminaMax));

        // Strength initial value is a random int between 1 and 10
        int strengthMin = 1;
        int strengthMax = 10;
        setStrength(Randomizer.getRandomInt(strengthMin, strengthMax));
    }
/*
    public Warrior (String name, int stamina, int strength, int hp){
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;

    }*/
    public Warrior (Warrior warrior){
        super(warrior.getName(), warrior.getHP());
        setStamina(warrior.getStamina());
        setStrength(warrior.getStrength());

    }

    // Getters and Setters
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

    // Methods
    public void attack(Character enemy) {
        if (getStamina() < 2) {
            recovery();
        } else if (getStamina() < 5) {
            weakAttack(enemy);
        } else {
            if (Randomizer.getRandomInt(0, 1) == 0) {
                heavyAttack(enemy);
            } else {
                weakAttack(enemy);
            }
        }
    }

    private void heavyAttack(Character enemy) {
        // Attack enemy
        int attackStrength = getStrength();
        enemy.setHp(enemy.getHP() - attackStrength);

        // Decrease stamina
        int staminaDecreaseValue = 5;
        this.setStamina(getStamina() - staminaDecreaseValue);

        // Log
        System.out.println(getName() + " heavy attacked " + enemy.getName() + " with " + attackStrength + " hp!");
    }

    private void weakAttack(Character enemy) {
        // Attack enemy
        int attackStrength = getStrength() / 2;
        enemy.setHp(enemy.getHP() - attackStrength);

        // Decrease
        int staminaDecreaseValue = 1;
        setStamina(getStamina() - staminaDecreaseValue);

        // Log
        System.out.println(getName() + " weak attacked " + enemy.getName() + " with " + attackStrength + " hp!");
    }

    private void recovery() {
        // Recover
        int recoverValue = 2;
        setStamina(getStamina() + recoverValue);

        // Log
        System.out.println(getName() + " didn't attack on this round!");
    }
}