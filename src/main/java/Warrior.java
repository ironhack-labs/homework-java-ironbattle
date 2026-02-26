import java.util.Random;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;
    private Random rand=new Random();

    public Warrior(String name,int hp,int stamina,int strength){
        super(name,hp);
        this.stamina=stamina;
        this.strength=strength;
    }

    @Override
    public void attack(Character opponent){
        int damage=0;
        int move=rand.nextInt(2);

        if((move==0||stamina<5)&&stamina>=5){
            damage=strength;
            stamina-=5;
            System.out.println(getName()+" used Heavy Attack! Damage:"+damage);
        }else if(stamina>=1){
            damage=strength/2;
            stamina+=1;
            System.out.println(getName()+" used Weak Attack! Damage:"+damage);
        }else{
            stamina+=2;
            System.out.println(getName()+" is exhausted. Recovering stamina.");
        }
        opponent.setHp(opponent.getHp()-damage);
    }
}
