package characters;

import java.util.Random;
import characters.Character;

public class Wizard extends Character {

    static Random random = new Random();

    private static int hp;
    private static int mana;
    private static int intelligence;

    public static characters.Character createWizard(String name) {
        return new Wizard(name, random.nextInt(51) + 50, random.nextInt(41) + 10, random.nextInt(50) + 1);
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character attacksThisCharacter) {

        //if true --> fireBall, else --> staffHit
        boolean skill = random.nextBoolean();

        if(skill && mana>=5){
            fireBall(attacksThisCharacter);

        }
        else if(mana==0){
            mana+=2;
        }
        else{
            staffHit(attacksThisCharacter);
        }

    }

    public static void fireBall(Character attacksThisCharacter){
        attacksThisCharacter.setHp(attacksThisCharacter.getHp()- intelligence);
        mana-=5;
    }

    public static void staffHit(Character attacksThisCharacter){

        attacksThisCharacter.setHp(attacksThisCharacter.getHp()- 2);
        mana++;



    }



    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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


}
