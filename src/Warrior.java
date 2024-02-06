import java.util.Random;

public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name,hp);
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
        Random random = new Random();
        int attackType = random.nextInt(2);
        if(attackType == 0 && canMakeHeavyAttack()){
                    heavyAttack(character);
                } else if (canMakeWeakAttack()) {
                    weakAttack(character);
                } else{
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
        System.out.println("Warrior HeavyAttack");
        character.receiveDamage(strength);
        stamina -=5;
    }
    private void weakAttack(Character character){

        System.out.println("Warrior weakAttack");
        int damage = strength / 2;
        character.receiveDamage(damage);
        stamina +=1;
    }

    private void regainStamina(){
        stamina +=2;
    }
    /// this receiveDamage can be also in the Character class?
    public void receiveDamage(int damage){
    System.out.println("Damage received from wizard" + " " +  damage);
        int newHP = getHp() - damage;
        setHp(newHP);
        if(newHP <= 0){
            setAlive(false);
        }
    }

}


