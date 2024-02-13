public class Wizard extends Character{

    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, 0);

        int hpMin = 50;
        int hpMax = 100;
        setHp(Randomizer.getRandomInt(hpMin, hpMax));

        int manaMin = 10;
        int manaMax = 50;
        setMana(Randomizer.getRandomInt(manaMin, manaMax));

        int intelligenceMin = 1;
        int intelligenceMax = 50;
        setIntelligence(Randomizer.getRandomInt(intelligenceMin, intelligenceMax));
    }
    public int getIntelligence() {
        return this.intelligence;
    }
    public int getMana() {
        return this.mana;
    }
    public int setMana(int mana) {
        return this.mana = mana;
    }
    public int setIntelligence(int intelligence) {return this.intelligence = intelligence;}

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

        int fireballDamage = getIntelligence();
        enemy.setHp(enemy.getHP() - fireballDamage);

        int manaDecrease = 5;
        this.setMana(getMana() - manaDecrease);
        System.out.println(getName() + " attacked " + enemy.getName() + " with a fireball for " + fireballDamage + " damage!");
    }

    private void staffHit(Character enemy){
        int staffHitDamage = 2;
        enemy.setHp(enemy.getHP() - staffHitDamage);

        int manaIncrease = 1;
        this.setMana(getMana() + manaIncrease);
        System.out.println(getName() + " attacked " + enemy.getName() + " with a staff for " + staffHitDamage + " damage!");
    }

    private void recovery(){
       int recoveryAmount = 2;
       setMana(getMana() + recoveryAmount);
         System.out.println(getName() + " recovered " + recoveryAmount + " mana!");
    }

}
