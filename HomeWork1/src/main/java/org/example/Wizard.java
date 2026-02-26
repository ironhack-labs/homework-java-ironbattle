package org.example;

public class Wizard extends Character{
    private int mana;
    private int intelligence;


    public Wizard(String name, int hp, int mana, int intelligence){
        super(name,hp);
        this.mana=mana;
        this.intelligence=intelligence;
    }

    public int getMana(){
        return mana;
    }

    public int getIntelligence(){
        return  intelligence;
    }

    public void setMana(int mana){
        this.mana=mana;
    }

    public void setIntelligence(int intelligence){
        this.intelligence=intelligence;
    }

    @Override
    public  void attack(Character target){

        if (!this.isAlive()) return;

        boolean fireball =   Math.random() < 0.5;
        int damage = 0;
        if (fireball && mana >= 5) {

            damage = intelligence;
            mana -= 5;

            System.out.println(getName() + " casts FIREBALL!");

        }
        else{
            if (mana > 0) {

                damage = 2;
                mana += 1;

                System.out.println(getName() + " does STAFF!");

            }
            else{
                damage = 0;
                mana += 2;

                System.out.println(getName() + " has no mana!");
            }
        }

        target.setHp(target.getHp()-intelligence);
        System.out.println(getName()+" attacked "+ target.getName());
        System.out.println("Damage: " +damage);
    }
}
