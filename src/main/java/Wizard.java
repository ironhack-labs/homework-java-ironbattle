import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;
    private Random rand=new Random();

    public Wizard(String name,int hp,int mana,int intelligence){
        super(name,hp);
        this.mana=mana;
        this.intelligence=intelligence;
    }

    @Override
    public void attack(Character opponent){
        int damage=0;
        int move=rand.nextInt(2);

        if(move==0&&mana>=5){
            damage=intelligence;
            mana-=5;
            System.out.println(getName()+" cast Fireball! Damage:"+damage);
        }else if(mana>=1){
            damage=2;
            mana+=1;
            System.out.println(getName()+" hit with Staff! Damage:"+damage);
        }else{
            mana+=2;
            System.out.println(getName()+" is out of mana. Recovering mana.");
        }
        opponent.setHp(opponent.getHp()-damage);
    }
}
