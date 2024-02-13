public class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(){}

    //Getters
    public String getId(){return id;}
    public String getName(){return name;}
    public int getHp(){return hp;}
    public boolean getIsAlive(){return isAlive;}

    //Setters
    public void setId(String id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setHp(int hp){this.hp = hp;}
    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}
}
