import java.util.Random;

public class BattleSimulator {
    public void battle(Character character1, Character character2) {
        boolean battleOver = false;

        while (!battleOver) {
            int prevHealth1 = character1.getHp();
            int prevHealth2 = character2.getHp();

            character1.attack(character2);
            character2.attack(character1);

            int damage1 = prevHealth2 - character2.getHp();
            int damage2 = prevHealth1 - character1.getHp();

            System.out.println("Warrior attacks Wizard. Damage dealt: " + damage1 + ". Remaining HP: " + character2.getHp());
            System.out.println("Wizard attacks Warrior. Damage dealt: " + damage2 + ". Remaining HP: " + character1.getHp());

            if (character1.getHp() <= 0 && character2.getHp() <= 0) {
                System.out.println("Both characters died. IT'S A DRAW.");
                battleOver = true;
            } else if (character1.getHp() <= 0) {
                System.out.println("Warrior has died. WIZARD WINS!");
                battleOver = true;
            } else if (character2.getHp() <= 0) {
                System.out.println("Wizard has died. WARRIOR WINS!");
                battleOver = true;
            }

            System.out.println("Game over.");
        }
    }
}