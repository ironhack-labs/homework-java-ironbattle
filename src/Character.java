abstract class Character {
    // Generate id
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String id, String name, int hp) {
        setId(id);
        setName(name);
        setHp(hp);
    }

    //Getters
    public String getId(){return id;}
    public String getName(){return name;}
    public int getHp(){return hp;}
    public boolean getIsAlive(){return isAlive;}

    //Setters
    public void setId(String id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setHp(int hp){this.hp = hp;}
    //public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}

    public void receiveAttack(int attack){
        this.hp -= attack;
    }

    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean checkIsAlive(){
        if (getHp() <= 0){
            setIsAlive(false);
            return false;
        }
        return true;
    }
}





