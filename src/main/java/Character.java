abstract class Character {
    private static long idCounter = 0;
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;


    public Character(String name, int hp) {
        this.id = createID();
        setName(name);
        setHp(hp);
    }

    //Getters
    public String getId(){return id;}
    public String getName(){return name;}
    public int getHp(){return hp;}
    public boolean getIsAlive(){return isAlive;}

    //Setters
    public void setId(String id){this.id = createID();}
    public void setName(String name){this.name = name;}
    public void setHp(int hp){this.hp = hp;}
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }


    public void receiveAttack(int attack){
        this.hp -= attack;
    }

    public boolean checkIsAlive(){
        if (getHp() <= 0){
            setIsAlive(false);
            return false;
        }
        return true;
    }

   public static synchronized String createID() {
        return String.valueOf(idCounter++);
    }
}





