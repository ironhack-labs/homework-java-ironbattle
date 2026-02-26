package org.example;

public class Warrior extends Character {
    private  int stamina;
    private  int strength;
    public Warrior(String name, int hp, int stamina, int strength){
        super(name,hp);
        this.stamina=stamina;
        this.strength=strength;
    }

    public int getStamina(){
        return stamina;
    }

    public int getStrength(){
        return  strength;
    }

    public void setStamina(int stamina){
        this.stamina=stamina;
    }

    public void setStrength(int strength){
        this.strength=strength;
    }


    @Override
    public void attack(Character target){
        if (!this.isAlive()) return;
        boolean heavy= Math.random()<0.5;
        int damage = 0;
        if (heavy &&  stamina  >= 5){
            damage = strength;

            stamina-=5;
            System.out.println(getName() + " does attack HEAVY!");
        }
        else {
            if (stamina > 0){
                damage = strength / 2;
                stamina += 1;

                System.out.println(getName() + " does attack WEAK!");
            }
            else{
                damage = 0;
                stamina += 2;
                System.out.println(getName() + " Doesnt have enough stamina to attack");
            }
        }
        target.setHp(target.getHp()- strength);

        System.out.println(getName()+" attacked "+ target.getName());
        System.out.println(damage+" Damaged");
    }
}
