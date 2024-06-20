import java.util.Random;

public class BattleSimulation {
    public static void simulateBattle(Character character1, Character character2) {
        System.out.println("Battle starts between " + character1.getName() + " and " + character2.getName());

        while (character1.isAlive() && character2.isAlive()) {
            character1.attack(character2);
            character2.attack(character1);

            System.out.println(character1.getName() + " has " + character1.getHp() + " HP left.");
            System.out.println(character2.getName() + " has " + character2.getHp() + " HP left.");
        }

        if (!character1.isAlive() && !character2.isAlive()) {
            System.out.println("The battle ended in a tie.");
        } else if (character1.isAlive()) {
            System.out.println(character1.getName() + " wins!");
        } else {
            System.out.println(character2.getName() + " wins!");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        Warrior warrior = new Warrior("Thor", rand.nextInt(101) + 100, rand.nextInt(41) + 10, rand.nextInt(10) + 1);
        Wizard wizard = new Wizard("Gandalf", rand.nextInt(51) + 50, rand.nextInt(41) + 10, rand.nextInt(50) + 1);

        simulateBattle(warrior, wizard);
    }
}