public class Wizard {
//derived from character

    private String name;
    private int hp;
    private int mana; //random between 10-50
    private int intelligence; //random between 1-50

    //Constructor
    public Wizard (String name, int hp, int mana, int intelligence){
        setName(name);
        setHp(hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setMana(int mana) {
        if (mana < 10 || mana > 50) {
            this.mana = -1;
            System.out.println("Invalid value for mana");
        } else {
            this.mana = mana;
        }
    }

    public void setIntelligence(int intelligence) {
        if (intelligence < 1 || intelligence > 50) {
            this.intelligence = -1;
            System.out.println("Invalid value for intelligence");
        } else {
            this.intelligence = intelligence;
        }
    }


    //Getters
    public String getName() {
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getMana(){
        return mana;
    }

    public int getIntelligence(){
        return intelligence;
    }

    //Functions
    void attack(){
        System.out.println("Attacks");
    }
}




