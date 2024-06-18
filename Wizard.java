import java.util.Random;

public class Wizard extends Character {
    private int mana;
    private int intelligence;


    public Wizard(String name, int hp, int mana, int intelligence){
        super(name, generateRandomHp(WIZARD_MIN_HP, WIZARD_MAX_HP));
        this.mana = new Random().nextInt(51)+ 10;
//        this.intelligence = new Random().nextInt(50)+ 1;
        this.intelligence = intelligence;
    }

    //Getter for mana
    public int getMana() {
        return mana;
    }

    //Setter for mana
    public void setMana(int mana) {
        this.mana = mana;
    }

    //getter for intel
    public int getIntelligence() {
        return intelligence = new Random().nextInt(50)+ 1;
    }

    //setter for intel
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    //Override goes here to implement attack()

    @Override
    public void attack(Character character) {
        int damage = 0;
        Random random = new Random();
        String attackType = random.nextBoolean() ? "staffAttack" : "fireHail";

        if(this.mana <= 0){
            this.mana += 2;
            System.out.println("\uD83E\uDDD9" + this.getName() + "\uD83E\uDDD9" + " is out of mana! Regenerates for 2 mana");
        }else if(attackType.equals("staffAttack") && this.getMana() > 0){
            damage = 2;
            character.setHp(character.getHp() - damage);
            System.out.println("\uD83E\uDDD9" + this.getName() + "\uD83E\uDDD9" + " uses the staff as a weapon, dealing 2 damage. " );
            this.mana += 1;
        }else if (attackType.equals("fireHail")){
            //this was to see the intelligence of the character
//            System.out.println("\uD83E\uDDD9" + this.getName() + "\uD83E\uDDD9" + " has " + this.getIntelligence() );
            damage = this.getIntelligence();
            character.setHp(character.getHp() - damage);
            System.out.println("\uD83E\uDDD9" + this.getName() + "\uD83E\uDDD9" + " conjures a Fire Hail Storm, dealing " + damage);
            this.mana -= 5;
        }


//        int newHp;
//        while (isAlive() && character.isAlive()) {
//
//            Random random = new Random();
//
//
//            String attackType;
//
//            attackType = random.nextBoolean() ? "StaffAttack" : "fireHail";
//            if(attackType.equals("StaffAttack")){
//                damage = (int) (this.getIntelligence() * 0.5);
//                System.out.println("Spell failed, but this wooden staff wont!");
//                newHp = character.getHp() - damage;
//                character.setHp(newHp > 0 ? newHp : 0);
//                mana++;
//            }else if(attackType.equals("fireHail")){
//                damage = this.getIntelligence();
//                System.out.println("Wizard conjures a hail storm of fire");
//                newHp = character.getHp() - damage;
//                character.setHp(newHp > 0 ? newHp : 0);
//                mana -= 5;
//            }
//
////            int newHp = target.getHp() - damage;
////            target.setHp(newHp > 0 ? newHp : 0);
//
//
//            System.out.println("Wizard attacked " + character.getName() + " for " + damage + " damage!");
//            System.out.println(character.getName() + " currently has: " + character.getHp() + " remaining!");
//        }
//
//            // Check if the target is still alive
//            if (character.getHp() <= 0) {
//                character.setAlive(false);
//                System.out.println(character.getName() + " has been defeated.");
//            }
    }
}

