import java.util.Random;

public class Warrior extends Character implements Attacker{

    private static final int MAX_HP = 200;
    private static final int MIN_HP = 100;
    private static final int MAX_STAMINA = 50;
    private static final int MIN_STAMINA = 10;
    private static final int MAX_STRENGTH = 10;
    private static final int MIN_STRENGTH = 1;
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);

    }

    public Warrior(String name) {
        super(name);
        setHp(generateRandomHp());
        setStamina(generateRandomStamina());
        setStrength(generateRandomStrength());
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

    public int getMaxHp() {
        return MAX_HP;
    }

    public int getMaxStamina() {
        return MAX_STAMINA;
    }
    public int getMaxStrength() {
        return MAX_STRENGTH;
    }
    public int getMinHp() {
        return MIN_HP;
    }
    public int getMinStamina() {
        return MIN_STAMINA;
    }
    public int getMinStrength() {
        return MIN_STRENGTH;
    }

    private int generateRandomHp() {
        Random random = new Random();
        return random.nextInt((MAX_HP - MIN_HP) + 1) + MIN_HP;
    }

    private int generateRandomStrength() {
        Random random = new Random();
        return random.nextInt((MAX_STRENGTH - MIN_STRENGTH) + 1) + MIN_STRENGTH;
    }

    private int generateRandomStamina() {
        Random random = new Random();
        return random.nextInt((MAX_STAMINA - MIN_STAMINA) + 1) + MIN_STAMINA;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "hp=" + getHp() +
                ", stamina=" + getStamina() +
                ", strength=" + getStrength() +
                '}';
    }


    public void heavyAttack(Character character){
            System.out.println("Heavy Attack: " + getStrength() + " points of damage");
            character.setHp(character.getHp()-(getStrength()));
            System.out.println("Character: " + character.getName() + " has " + character.getHp() + " points of health left");
    }


    public void weakAttack(Character character){
        if(getStamina()<5){
            System.out.println("Recovering stamina");
            setStamina(getStamina()+2);
        }else{
            if(getStrength()==MIN_STRENGTH){
                System.out.println("Not enough strength to attack");
            }
                    System.out.println("Weack Attack: " + getStrength()/2 + " points of damage");
                    character.setHp(character.getHp()-(getStrength()/2));
                    System.out.println("Character: " + character.getName() + " has " + character.getHp() + " points of health left");
                    //Stamina recovery up to init or max?
                    if(getStamina()<MAX_STAMINA){
                        System.out.println("Recovering stamina");
                        setStamina(getStamina()+1);
                    }
        }
    }


    @Override
    public void attack(Character character){
        Random random = new Random();
        if(isAlive()){
            if(random.nextDouble()>0.5){
                weakAttack(character);
            }else{
                if(getStamina()<5){
                    weakAttack(character);
                }else {
                    heavyAttack(character);
                }
            }
            if(character.getHp()<=0){
                character.setAlive(false);
                System.out.println("Character: " + getName() + " has won the battle");
                System.out.println("The character " + character.getName() + " has been defeated");
            }
        }
    }
}
