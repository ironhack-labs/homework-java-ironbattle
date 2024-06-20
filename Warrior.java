import java.util.Random;

public class Warrior extends Character{
    private int stamina;
    private int strength;

    //CONSTANTS FOR HP
    protected static final int WARRIOR_MIN_HP = 100;
    protected static final int WARRIOR_MAX_HP = 200;

    //    CONSTRUCTOR
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, generateRandomHp(WARRIOR_MIN_HP, WARRIOR_MAX_HP));
        this.stamina = new Random().nextInt(41) + 10; // Random between 10 and 50
//        this.strength = new Random().nextInt(10) + 1;         // Random between 1 and 10
        this.strength = strength;
    }


    //    GETTERS
    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength = new Random().nextInt(10) + 1;
    }

    //    SETTERS
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }



    @Override
    public void attack(Character character) {
        Random random = new Random();
        String attackType;

        attackType = random.nextBoolean() ? "lightAttack" : "heavyAttack";
        int damage;
//        System.out.println("Warrior " + this.getName() + " starts with " + this.getStamina() + " stamina point(s).");   PRINT STARTING STAMINA

        if(this.getStamina() > 0 && (attackType.equals("lightAttack") || this.getStamina() < 5)){
            damage = (int) (this.getStrength() * 0.5);
            stamina += 1;
            System.out.println("\u2694\uFE0F Warrior \u2694\uFE0F " + this.getName() + " executed a Weak Attack for " + damage + " points of damage!");
            character.setHp(character.getHp() - damage);
            System.out.println("Stamina Increased 1 point to: " + this.getStamina());
            System.out.println("-----------------------------------------------------------");
        }else if(this.getStamina() >= 5 && attackType.equals("heavyAttack")){
            damage = this.strength;
            character.setHp(character.getHp() - damage);
            this.stamina -= 5;
            System.out.println("\u2694\uFE0F Warrior \u2694\uFE0F " + this.getName() + " attacked " + character.getName() + " with a heavy hit for " + damage + " damage!");
            System.out.println("Stamina Decreased by 5 points to: " + this.getStamina());
            System.out.println("-----------------------------------------------------------");
        } else if (this.getStamina() <= 0) {
            this.stamina += 2;
            System.out.println("\u2694\uFE0F Warrior \u2694\uFE0F " + this.getName() + " is out of stamina! Warrior's stamina has been restored by 2 points!");
            System.out.println("-----------------------------------------------------------");
        }

    }

}