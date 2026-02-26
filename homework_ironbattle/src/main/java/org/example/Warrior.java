package org.example;

public class Warrior extends Character{
    private int stamina;
    private int strength;
    public Warrior(String name){
        super(name, 100 + (int)(Math.random() * 101));
        this.stamina = 10 + (int)(Math.random() * 41);
        this.strength = 1 + (int)(Math.random() * 10);

    }
    public int getStamina(){
        return this.stamina;
    }
    public int getStrength(){
        return this.strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
   public void attack(Character opponent){
      int randomChoice=(int) (Math.random()*2);
      if(randomChoice==1){
          if(this.stamina>=5){
              opponent.setHp(opponent.getHp()-getStrength());
              this.stamina-=5;
              System.out.println(getName() + " performed a Heavy Attack! " + opponent.getName() + " HP: " + opponent.getHp());
          }
          else{
              weak(opponent);
          }
      }
      else{
          weak(opponent);
      }
   }
   public void weak(Character opponent){
        if(this.stamina>=1){
            opponent.setHp(opponent.getHp()-getStrength()/2);
            this.stamina+=1;
            System.out.println(getName() + " performed a Weak Attack! " + opponent.getName() + " HP: " + opponent.getHp());
        }
        else{
            System.out.println(getName() + " is out of stamina, resting... Stamina +2");
            this.stamina+=2;
        }
   }
}
