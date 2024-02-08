class Warrior extends Character{


    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        System.out.println("hola");
    }
}