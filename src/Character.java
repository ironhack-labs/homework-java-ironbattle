abstract class Character implements Attacker {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp){
        setName(name);
        setHp(hp);
        setId();
    }

    public String getId() {
        return this.id;
    }

    public void setId() {
        this.id = "1";  //TODO  add logic for autogeneration of the id
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

}



/*
Character class

This class will have:

    Variable called id of data type string, auto-generated (Private member)
    Variable called name of data type string (Private member)
    Variable called hp of data type int, random between 100-200 to warriors and 50-100 for wizards, representing the health points (Private member)
    Variable called isAlive of data type boolean defaulted to true (Private member)


    A "parameterized" constructor that takes name and hp (as parameters)

    Public Getter functions to access these variables
    Public Setter functions to change these variables
 */