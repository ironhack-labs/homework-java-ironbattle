public abstract class CharacterAttributes {

    protected String name = "";
    protected int hp;
    protected int attribute1;
    protected int attribute2;
    protected int type = -1;

    //getters
    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int getHP() {
        return this.hp;
    }

    public int getAttribute1() {
        return this.attribute1;
    }

    public int getAttribute2() {
        return this.attribute2;
    }

    public void printInfo(){
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("health points: " + hp);
        System.out.println("attribute1: " + attribute1);
        System.out.println("attribute2: " + attribute2);
    }
}
