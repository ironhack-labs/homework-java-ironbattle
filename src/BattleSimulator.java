import java.util.Random;

public class BattleSimulator {
    public void battle(Character character1, Character character2) {
        boolean battleOver = false;

        // Starting information
        System.out.println("--------------------");
        System.out.println("Contenders:");
        if (character1 instanceof Warrior) {
            System.out.println(character1.getName() + " - Starting HP: " + character1.getHp() + ". Starting Stamina: " + ((Warrior) character1).getStamina() + ".");
        } else if (character1 instanceof Wizard) {
            System.out.println(character2.getName() + " - Starting HP: " + character1.getHp() + ". Starting Mana: " + ((Wizard) character1).getMana() + ".");
        }
        if (character2 instanceof Warrior) {
            System.out.println(character1.getName() + " - Starting HP: " + character2.getHp() + ". Starting Stamina: " + ((Warrior) character2).getStamina() + ".");
        } else if (character2 instanceof Wizard) {
            System.out.println(character2.getName() + " - Starting HP: " + character2.getHp() + ". Starting Mana: " + ((Wizard) character2).getMana() + ".");
        }
        System.out.println("--------------------");

        int roundNumber = 1;

        // Battle rounds
        while (!battleOver) {
            System.out.println("**Round #" + roundNumber + "**");

            character1.attack(character2);
            character2.attack(character1);

            character1.setHp(Math.max(character1.getHp(), 0));
            character2.setHp(Math.max(character2.getHp(), 0));

            if (character1 instanceof Warrior) {
                System.out.println(((Warrior) character1).getName() + " - Remaining HP: " + character1.getHp() + ". Remaining Stamina: " + ((Warrior) character1).getStamina() + ".");
            } else if (character1 instanceof Wizard) {
                System.out.println(((Wizard) character1).getName() + " - Remaining HP: " + character1.getHp() + ". Remaining Mana: " + ((Wizard) character1).getMana() + ".");
            }

            if (character2 instanceof Warrior) {
                System.out.println(((Warrior) character2).getName() + " - Remaining HP: " + character2.getHp() + ". Remaining Stamina: " + ((Warrior) character2).getStamina()+ ".");
            } else if (character2 instanceof Wizard) {
                System.out.println(((Wizard) character2).getName() + " - Remaining HP: " + character2.getHp() + ". Remaining Mana: " + ((Wizard) character2).getMana() + ".");
            }

            if (character1.getHp() <= 0 && character2.getHp() <= 0) {
                System.out.println("--------------------");
                System.out.println("Both characters died. IT'S A DRAW.");
                battleOver = true;
            } else if (character1.getHp() <= 0) {
                System.out.println("--------------------");
                System.out.println("Player 2 has died. PLAYER 1 WINS!");
                battleOver = true;
            } else if (character2.getHp() <= 0) {
                System.out.println("--------------------");
                System.out.println("Player 1 has died. PLAYER 2 WINS!");
                battleOver = true;
            }

            System.out.println("--------------------");
            roundNumber++;
        }
    }
}