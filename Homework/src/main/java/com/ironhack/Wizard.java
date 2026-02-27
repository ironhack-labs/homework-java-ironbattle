package com.ironhack;

public class Wizard extends Character implements Attacker{
    private int mana;           //rand between 10-50
    private int intelligence;  //rand between 1-50
    private int damage;

    public Wizard(String name, int hp,int mana,int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character enemy) {
        int damage = 0;
        if (this.mana >= 5){
            damage = this.intelligence;
            this.mana = this.mana - 5;
            System.out.println( getName() + " attacked with Fireball and damage is " + damage + " . Mana is now : " + mana);
        }else if (this.mana < 5 && this.mana >=2){
            damage = 2 ;
            this.mana = this.mana + 1 ;
            System.out.println( getName() + " attacked with Staff hit and damage is " + damage + " . Mana is now : " + mana);
        }
        else {
            this.mana = this.mana + 2;
            System.out.println( " No damage happened. Mana is :" + mana);
        }
        int currentEnemyHp = enemy.getHp();
        enemy.setHp(currentEnemyHp - damage);
        //

        //  System.out.println(this.getName() + " attacked! " + enemy.getName() + " qalan HP: " + enemy.getHp());


    }


//    @Override
//    public void attack(int attack) {}
//
//    @Override
//    public void attack(int heavyAttack, int weakAttack) {}
}
