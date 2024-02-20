import java.util.Random;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name,hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public void setStamina(int stamina) {
        if (stamina< 10 || stamina>50) {
            this.stamina = -1;
        } else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength < 1 || strength > 10) {
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

/// Attack method. Weak and Heavy attacks separate. Attacks are random using Random Util
    @Override
    public void attack(Character character) {


        int attackType = Utils.generateRandomNumber(1, 2);
        if (attackType == 1 && canMakeHeavyAttack()) {
            heavyAttack(character);
            Printer.asciiWarriorAttack("heavyAttack");
        } else if (canMakeWeakAttack()) {

            weakAttack(character);
            Printer.asciiWarriorAttack("weakAttack");
        } else {
            regainStamina();
        }

    }
    private boolean canMakeHeavyAttack(){
        return stamina >= 5;
    }

    private boolean canMakeWeakAttack(){
        return stamina >=1;
    }

    private void heavyAttack(Character character){
//        System.out.println("Warrior HeavyAttack");
        character.receiveDamage(strength);
        stamina -=5;
    }
    private void weakAttack(Character character){
//        System.out.println("Warrior weakAttack");
        int damage = strength / 2; // can be floated.
        System.out.println("This is the damage " + " " + damage);
        character.receiveDamage(damage);
        stamina +=1;
    }

    private int weakAttack(){
        int damage = strength / 2;
        stamina +=1;
        return damage;
    }

    private void regainStamina(){
        stamina +=2;
    }
    /// this receiveDamage can be also in the Character class?
    public void receiveDamage(int damage){
        System.out.println("Damage received from wizard" + " " +  damage);
        int newHP;
        if (getHp() - damage < 0){
            setHp(0);
        } else {
            setHp(getHp() - damage);
        }
        if(getHp() <= 0){
            setAlive(false);
        }
    }
}


