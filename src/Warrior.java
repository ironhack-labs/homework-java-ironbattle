public class Warrior extends Character {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength){
        super(name,hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina(){return stamina;}
    public int getStrength(){return strength;}
    public void setStamina(int stamina){
        if(stamina <= 10 || stamina >= 50){
            throw new IllegalArgumentException("Stamina is not a number between 10 and 50.");
        }else{
            this.stamina = stamina;}
    }
    public void setStrength(int strength) {
        if(strength <= 1 || strength >= 10) {
            throw new IllegalArgumentException("Strength is not a number between 1 and 10.");
        } else {
            this.strength = strength;
        }
    }

    public void attack(Wizard wizard){
        int random = 0;
        int strengthWarrior = getStrength();
        int staminaWarrior = getStamina();

        if(random == 0){
            //Heavy attack
            if(staminaWarrior < 5){
                weakAttack(wizard);
            }else{
                heavyAttack(wizard);}
        }else{
            //Weak attack
            if(staminaWarrior<1){
                setStamina(staminaWarrior + 2);
            }else{
                weakAttack(wizard);
            }
        }

    }

    public void heavyAttack(Wizard wizard){
        int wizardHealth = wizard.getHp();
        int strengthWarrior = getStrength();
        int staminaWarrior = getStamina();

        wizard.setHp(wizardHealth - strengthWarrior);
        setStamina(staminaWarrior - 5);}

    public void weakAttack(Wizard wizard){

        int wizardHealth = wizard.getHp();
        int halfStrengthWarrior = Math.round(getStrength()/2);
        int staminaWarrior = getStamina();

        wizard.setHp(wizardHealth - halfStrengthWarrior);
        setStamina(staminaWarrior + 1);

    }
}


