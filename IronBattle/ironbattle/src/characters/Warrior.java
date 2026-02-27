package characters;

import java.util.Random;


public class Warrior extends Character{

    static Random random = new Random();
    // (max - int +1) + min


    private static int hp;
    private static int stamina;
    private static int strength;

    
    public static characters.Character createWarrior(String name){
        return new Warrior(name, random.nextInt(101)+100, random.nextInt(41)+10, random.nextInt(10)+1);
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack(Character attacksThisCharacter) {

        // if false --> Weak attack, else --> Heavy attack
        boolean attackType = random.nextBoolean();

        if (stamina >= 5 && attackType) {
            heavyAttack(attacksThisCharacter);

        } 
        else if(stamina == 0) {
            stamina+=2;
        }
        else{
            weakAttack(attacksThisCharacter);
        }

    }

    public static void heavyAttack(Character attacksThisCharacter){

        attacksThisCharacter.setHp(attacksThisCharacter.getHp()-strength);
        stamina-=5;
    }

    public static void weakAttack(Character attacksThisCharacter){
        attacksThisCharacter.setHp(attacksThisCharacter.getHp()-(int)(strength/2));
        stamina++;
    }







}
