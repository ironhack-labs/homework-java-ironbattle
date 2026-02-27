package com.ironhack;

public class Warrior extends Character implements Attacker{
    private int stamina;  //random between 10-50
    private int strength;  //rand between 1-10
    private int damage;

    public Warrior(String name, int hp,int stamina,int strength) {
        super(name, hp);
            this.stamina = stamina;
            this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character enemy) {
        int damage = 0;
        if (this.stamina >= 5){
            damage = this.strength;
            this.stamina = this.stamina - 5;
            System.out.println( getName() + " attacked HEAVY and damage is " + damage + " . Stamina is now : " + stamina );
        }else if (this.stamina <5 && this.stamina>0){
           damage = this.strength / 2 ;
           this.stamina = this.stamina + 1;
           System.out.println( getName() + " attacked WEAK and damage is " + damage + " . Stamina is now : " + stamina );
        }else{
            damage = 0;
            this.stamina = this.stamina + 2;
            System.out.println( getName() + " didn't attack.Damage is " + damage + " . Stamina is now : " + stamina );

        }


        // old version
//        int newHp = enemy.getHp() - damage;
//        enemy.setHp(newHp);

        // new version
        int currentEnemyHp = enemy.getHp();
        enemy.setHp(currentEnemyHp - damage);
        //

      //  System.out.println(this.getName() + " attacked! " + enemy.getName() + " qalan HP: " + enemy.getHp());

       // System.out.println(" Enemy health is now : " + enemy.getHp());
    }



}
