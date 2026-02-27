package Ironbattle;
import java.util.Random;

public class Warrior extends Character{
    private int stamina;
    private int strength;

    public Warrior(String name,int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }
    @Override
    public void attack(Character target){
        Random random =new Random();
        int attackType =random.nextInt(2);
        if (attackType ==0 && this.stamina >=5){
            //Heavy attack
            target.setHp(target.getHp() - this.strength);
            this.stamina -=5;
            System.out.println(getName() + "used heavy Attack for" + this.strength + "damage.");
        }else if (this.stamina >=1 ){
    // weak atack
            int damage = this.strength / 2;
            target.setHp(target.getHp() - damage);
            this.stamina +=1;
            System.out.println(getName() + " used weak attac fro " + damage + "damage.");
        }else {
            //no stemina
        }this.stamina += 2;
        System.out.println(getName() + "is exhausted adn recovered   2 stamina.");

    }
    public int getStamina(){
        return stamina; }
    public void setStamina(int stamina ) {
        this.stamina = stamina;}

    public int getStrength(){
        return strength;}
    public void setStrength (int strength) {
        this.strength = strength;
    }

}
