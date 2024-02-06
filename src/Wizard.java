public class Wizard extends Character{

    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, 0);
        setMana();
        setIntelligence();
    }

    public void setMana(){
        this.mana = mana;
    }

    public void setIntelligence(){
        this.intelligence = intelligence;
    }

    public void attack(){
        System.out.println("atacking");
    }

}
