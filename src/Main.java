//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a warrior and a wizard for the battle
        Warrior warrior = new Warrior("Orc", 150, 40, 8);
        Wizard wizard = new Wizard("Gandalf", 100, 30, 45);

        // Start the battle, print initial stats
        System.out.println("The battle begins!");
        printStats(warrior, wizard);

        // The battle consists of 10 rounds
        for (int round = 1; round <= 10; round++) {
            System.out.println("\n--- Round " + round + " ---");
            warrior.attack(wizard); // Warrior attacks the wizard
            wizard.attack(warrior); // Wizard attacks the warrior
            printStats(warrior, wizard);

            // Check if any of the characters has been defeated
            if (!warrior.isAlive() && !wizard.isAlive()) {
                System.out.println("Both characters have been defeated. It's a tie!");
                break; // The battle ends in a tie
            } else if (!warrior.isAlive()) {
                System.out.println(warrior.getName() + " has been defeated. " + wizard.getName() + " is the winner!");
                break; // The wizard wins
            } else if (!wizard.isAlive()) {
                System.out.println(wizard.getName() + " has been defeated. " + warrior.getName() + " is the winner!");
                break; // The warrior wins
            }
        }

    }
        public static void printStats (Character c1, Character c2){
            System.out.println(c1.getName() + " (Warrior) - HP: " + c1.getHp() + " | Stamina: " + ((Warrior) c1).getStamina());
            System.out.println(c2.getName() + " (Wizard) - HP: " + c2.getHp() + " | Mana: " + ((Wizard) c2).getMana());
        }

}