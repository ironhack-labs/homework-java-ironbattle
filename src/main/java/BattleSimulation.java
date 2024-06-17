

public class BattleSimulation {

        public static void simulateBattle(Attacker attacker1, Attacker attacker2) {

            //  ATTACK TURNS
            attacker1.attack();
            attacker2.attack();

            // HEALTH / DAMAGE LOGIC
        }

        public static void main(String[] args) {
            Warrior warrior = new Warrior(Thor, 100);
            Wizard wizard = new Wizard(Gandalf, 100);

            while (warrior.isAlive() && wizard.isAlive()) {
                warrior.attack(wizard);
                if (!wizard.isAlive()) {
                    System.out.println(wizard.name + " has been defeated!");
                    break;
                }

                wizard.attack(warrior);
                if (!warrior.isAlive()) {
                    System.out.println(warrior.name + " has been defeated!");
                    break;

                    simulateBattle(warrior, wizard);
                }
            }
        }
