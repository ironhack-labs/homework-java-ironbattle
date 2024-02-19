public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;

    public Warrior(String id, String name, int hp, int stamina, int strength){
        super(id, name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina(){return stamina;}
    public int getStrength(){return strength;}
    public void setStamina(int stamina){
        if(stamina < 10 || stamina > 50){
            throw new IllegalArgumentException("Stamina isn't a number between 10 and 50.");
        }else{
        this.stamina = stamina;}
    }
    public void setStrength(int strength) {
        if(strength < 1 || strength > 10) {
            throw new IllegalArgumentException("Strength isn't a number between 1 and 10.");
        } else {
            this.strength = strength;
        }
    }
    @Override
    public void setHp(int hp){
        //Esto traera problemas durante la batalla. Hay que reverlo
      if(hp >200 || hp < 100){
          throw new IllegalArgumentException("Warrior's hp isn't a number between 100 and 200.");
      }else{
          hp = hp;
      }
    }
    public void Attack(Character x){
        int randomNumber = Math.toIntExact(Math.round(Math.random()));
        System.out.println(randomNumber);
        int staminaWarrior = getStamina();

        if(randomNumber == 0){
            //Heavy attack
            if(staminaWarrior < 5){
                weakAttack(x);
            }else{
            heavyAttack(x);}
        }else{
            //Weak attack
            if(staminaWarrior<1){
                setStamina(staminaWarrior + 2);
            }else{
            weakAttack(x);
            }
        }

        }

    public void heavyAttack(Character wizard){
        int wizardHealth = wizard.getHp();
        int strengthWarrior = getStrength();
        int staminaWarrior = getStamina();

        wizard.receiveAttack(wizardHealth - strengthWarrior);
        setStamina(staminaWarrior - 5);}



    public void weakAttack(Character wizard){

        int wizardHealth = wizard.getHp();
        int halfStrengthWarrior = Math.round(getStrength()/2);
        int staminaWarrior = getStamina();

        wizard.receiveAttack(wizardHealth - halfStrengthWarrior);
        setStamina(staminaWarrior + 1);

    }

}
