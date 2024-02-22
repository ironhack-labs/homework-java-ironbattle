import java.util.Random;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;


    public Warrior(String name, int hp, int stamina, int strength){
        super(name,hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina(){return stamina;}
    public int getStrength(){return strength;}
    public void setStamina(int stamina){this.stamina = stamina;}
    public void setStrength(int strength) {this.strength = strength;}
    @Override
    public void setHp(int hp){super.setHp(hp);}
    public void Attack(Character x){
        int randomNumber = new Random().nextInt(2);
        int staminaWarrior = getStamina();

        try{
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
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void heavyAttack(Character opponent) throws IllegalArgumentException{
        if(opponent == null){
            throw new IllegalArgumentException("Target character cannot be null.");
        }

        int strengthWarrior = getStrength();
        int staminaWarrior = getStamina();

        opponent.receiveAttack(strengthWarrior);
        setStamina(staminaWarrior - 5);}


    public void weakAttack(Character opponent) throws IllegalArgumentException{
        if(opponent == null){
            throw new IllegalArgumentException("Target character cannot be null.");
        }

        int halfStrengthWarrior = Math.round(getStrength()/2);
        int staminaWarrior = getStamina();

        opponent.receiveAttack(halfStrengthWarrior);
        setStamina(staminaWarrior + 1);
    }
}
