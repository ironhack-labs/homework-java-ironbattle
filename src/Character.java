public abstract class Character implements Attacker {
    private String name;
    private static int idCounter = 1;
    private String id;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        setName(name);
        setHp(hp);
        assignId();
    }
    public Character(String name){
        setName(name);
    }

    private void assignId(){
        this.id = String.valueOf(idCounter++);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHp(int hp){
        if(hp<0){
            this.isAlive = false;
        }
        this.hp = hp;

    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public String getName(){
        return this.name;
    }

    public int getHP(){
        return this.hp;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public abstract void attack(Character character);
}
