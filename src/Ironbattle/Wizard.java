package Ironbattle;
import java.util.Random;

public class Wizard extends Character{
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence){
        super(name, hp);
        this.mana = mana;
        this.intelligence =intelligence;
    }
    @Override
    public void attack(Character target){
        Random random = new Random();
        int attackType =random.nextInt(2);

        if (attackType == 0 && this.mana >=5){
            //firebal
            target.setHp(target.getHp() - this.intelligence );
            this.mana -= 5;
            System.out.println(getName() + "cast ireball fro  " + this.intelligence + "damage.");
        }else if( this.mana >= 1){
            //staff
            int damage = 2 ;
            target.setHp(target.getHp() - damage);
            this.mana += 1;
            System.out.println(getName() + " mused Staff hit fro " + damage + "damage.");
        }else{
            //-no mana
            this.mana +=2;
            System.out.print(getName() + "is out of mana and recovered 2 points.");

        }
    }
    public int getMana (){
        return mana;
    }
    public void detMana (int mana){
        this.mana = mana;
    }
    public int getIntelligence (){
        return intelligence;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
}
