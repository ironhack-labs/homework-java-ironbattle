public class Wizard extends Character{
    // Attributes
    private int mana;
    private int intelligence;
    private final int recoveryAmount;


    // Constructors
    public Wizard(String name) {
        super(name, 1);

        // HP initial value is a random int between 50 and 100
        int hpMin = 50;
        int hpMax = 100;
        setHp(Randomizer.getRandomInt(hpMin, hpMax));

        // Mana initial value is a random int between 10 and 50
        int manaMin = 10;
        int manaMax = 50;
        setMana(Randomizer.getRandomInt(manaMin, manaMax));

        // Intelligence initial value is a random int between 1 and 10
        int intelligenceMin = 1;
        int intelligenceMax = 50;
        setIntelligence(Randomizer.getRandomInt(intelligenceMin, intelligenceMax));

        this.recoveryAmount = 2;
    }

    public Wizard(Wizard wizard){
        super(wizard.getName(), wizard.getHP());
        setMana(wizard.getMana());
        setIntelligence(wizard.getIntelligence());
        this.recoveryAmount = wizard.getRecoveryAmount();
    }

    // Getters and Setters
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

    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    // Methods
    public void attack(Character enemy) {
        if(getMana() < 2) {
            recovery();
        } else if(getMana() < 5){
            staffHit(enemy);
        }else{
            if (Randomizer.getRandomInt(0, 1) == 0){
                fireball(enemy);
            }else{
                staffHit(enemy);
            }
        }
    }

    private void fireball(Character enemy){
        // Attack enemy
        int fireballDamage = getIntelligence();
        enemy.setHp(enemy.getHP() - fireballDamage);

        // Decrease mana
        int manaDecrease = 5;
        this.setMana(getMana() - manaDecrease);

        //set the attack for record
        setCurrentAttack("Fireball");
    }

    private void staffHit(Character enemy){
        // Attack enemy
        int staffHitDamage = 2;
        enemy.setHp(enemy.getHP() - staffHitDamage);

        // Decrease mana
        int manaDecrease = 1;
        this.setMana(getMana() - manaDecrease);

        //set the attack for record
        setCurrentAttack("Staff Hit");
    }

    private void recovery(){
        // Recover mana
       setMana(getMana() + recoveryAmount);

         //set the ability for record
        setCurrentAbility("Recovery");
    }

}
