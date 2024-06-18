public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Gladiator", 0, 0, 0);
        Warrior warrior1 = new Warrior ("Spartacus", 0, 0, 0);

//        System.out.println("Warrior 0: " + warrior.getName() + " HP: " + warrior.getHp() + " Stamina: " + warrior.getStamina() + " Strength: " + warrior.getStrength());
//        System.out.println("Warrior 1: " + warrior1.getName() + " HP: " + warrior1.getHp() + " Stamina: " + warrior1.getStamina() + " Strength: " + warrior1.getStrength());

        Wizard wizard1 = new Wizard("Harry Potter", 0,0,0);

        wizard1.attack(warrior);
        }
}
