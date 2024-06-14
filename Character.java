public class Character{ //NEEDS TO IMPLEMENT ATTACKER WHEN ITS DONE
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    //CONSTRUCTOR
    public Character(String name, int hp) {
        setId(""); //Auto-generated???
        setName(name);
        setHp(hp);
        setAlive(true);

    }

    //GETTERS & SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
//        IDEA FOR AUTO-GENERATION:
//        String letters="abcdefg";
//        String numbers="123456";
        this.id=id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
