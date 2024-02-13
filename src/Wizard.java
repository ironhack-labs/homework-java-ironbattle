import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana; //random between 10-50
    private int intelligence; //random between 1-50

    //Constructor
    public Wizard (String name, int hp, int mana, int intelligence){
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    //Setters
    private void setMana(int mana) {
        if (mana < 10 || mana > 50) {
            this.mana = -1;
            System.out.println("Invalid value for mana");
        } else {
            this.mana = mana;
        }
    }

    private void setIntelligence(int intelligence) {
        if (intelligence < 1 || intelligence > 50) {
            this.intelligence = -1;
            // Maybe we can throw IllegalArgumentException({Message}).
            System.out.println("Invalid value for intelligence");
        } else {
            this.intelligence = intelligence;
        }
    }

    //Getters
    public int getMana(){
        return mana;
    }

    public int getIntelligence(){
        return intelligence;
    }

    //Functions
    @Override
    public void attack(Character character) {
        int randomNumber = getRandomNumber(); // Abstract to an external method

        if (randomNumber == 0 && hasEnoughMana()) {
            fireBallAttack(character);
        } else if(randomNumber == 1 && hasAlmostOneMana()){
            staffHitAttack(character);
        }else{
            recoverMana();
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(2); // Abstract to an external method
    }

    private boolean hasEnoughMana() {
        return getMana() >= 5;
    }
    private boolean hasAlmostOneMana() { return getMana() >= 1;}

    private void fireBallAttack(Character character) {
        System.out.println("Wizard fireBallAttack");
        setMana(getMana() - 5);
        character.receiveDamage(getIntelligence());
    }

    private void staffHitAttack(Character character) {
        System.out.println("Wizard staffHitAttack");
        setMana(getMana() + 1);
        character.receiveDamage(2);
    }

    private void recoverMana(){
        setMana(getMana() + 2);
    }

    public void receiveDamage(int damage){
        System.out.println("Damage received from warrior" + " " +  damage);
        int newHP = getHp() - damage;
        setHp(newHP);
        if(newHP <= 0){
            setAlive(false);
        }
    }

}





