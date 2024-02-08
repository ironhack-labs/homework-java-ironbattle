class Wizard extends Character{

    public Wizard(String name, int hp) {
        super(name, hp);
    }

    public Wizard(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        System.out.println("hols");
    }
}