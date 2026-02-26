package org.example;

public class Wizard extends Character{
    private int mana;
    private int intelligence;
    public Wizard(String name){
        super(name, 50 + (int)(Math.random() * 51));
        this.mana = 10 + (int)(Math.random() * 41);
        this.intelligence = 1 + (int)(Math.random() * 50);
    }
    public int getMana(){
        return this.mana;
    }
    public int getIntelligence(){
        return this.intelligence;
    }
    public void setMana(int mana){
        this.mana=mana;
    }
    public void setIntelligence(int intelligence){
        this.intelligence=intelligence;
    }
    public void attack(Character opponent){
        int randomChoice=(int)(Math.random()*2);
        if(randomChoice==1){
            if(this.mana>=5){
                opponent.setHp(opponent.getHp() - this.intelligence);
                this.mana-=5;
                System.out.println(getName() + " cast Fireball! " + opponent.getName() + " HP: " + opponent.getHp());
            }
            else{
                staffHit(opponent);
            }
        }
        else{
            staffHit(opponent);
        }
    }
    public void staffHit(Character opponent){
        if(this.mana>=1){
            opponent.setHp(opponent.getHp()-2);
            this.mana+=1;
            System.out.println(getName() + " used Staff Hit! " + opponent.getName() + " HP: " + opponent.getHp());

        }
        else{
            this.mana+=2;
            System.out.println(getName() + " is exhausted, resting... Mana +2");

        }
    }
}
