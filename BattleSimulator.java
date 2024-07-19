// Main class to run the battle simulation
public class BattleSimulator {
    public static void main(String[] args) {
        // Create a warrior and a wizard
        Warrior warrior = new Warrior("Conan");
        Wizard wizard = new Wizard("Gandalf");

        // Simulate battle until one character is defeated
        while (warrior.isAlive() && wizard.isAlive()) {
            warrior.attack(wizard); // Warrior attacks wizard
            if (wizard.isAlive()) {
                wizard.attack(warrior); // Wizard attacks warrior
            }
            System.out.println();
        }

        // Determine and announce the winner
        if (warrior.isAlive() && !wizard.isAlive()) {
            System.out.println("Warrior " + warrior.getName() + " wins!");
        } else if (!warrior.isAlive() && wizard.isAlive()) {
            System.out.println("Wizard " + wizard.getName() + " wins!");
        } else {
            System.out.println("It's a tie! Restarting the battle...");
        }
    }
}