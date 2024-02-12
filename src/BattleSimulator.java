import java.util.Scanner;

public class BattleSimulator {

    private static Character character1;
    private static Character character2;

    public static void main(String[] args) {

        Scanner scanner;
        String optionMenu;
        System.out.println("******** Welcome to BattleSimulator ********");

        do {
            System.out.println("Select type of battle:");
            System.out.println("1. Full random battle");
            System.out.println("2. Customize the characters name");
            System.out.println("3. Customize all characters features");
            System.out.println("Press 'E' or 'e' for exit!");

            scanner = new Scanner(System.in);
            optionMenu = scanner.next();

            if (optionMenu.equalsIgnoreCase("E")) break;
            if (optionMenu.equalsIgnoreCase("1")) fullRandomBattle();

        } while (true);

    }

    private static void fullRandomBattle() {
        character1 = createRandomCharacter();
        character2 = createRandomCharacter();
        int round = 1;
        do {
            System.out.printf("%n%nROUND %d FIGHT! %n", round);
            character1.attack(character2);
            character2.attack(character1);
            printStats();
            round++;
        } while (character1.isAlive() && character2.isAlive());
        System.out.println("\n\nGAME OVER!!!\n\n");
    }

    private static void printStats() {
        character1.printStats();
        System.out.print(" << VS >> ");
        character2.printStats();
    }

    private static Character createRandomCharacter() {
        String characterInfo = Utils.getRandomCharacter();
        String characterName = characterInfo.split(",")[0];
        String characterType = characterInfo.split(",")[1];

        Character character = characterType.equalsIgnoreCase(Characters.Warrior.name()) ?
                new Warrior(characterName) :
                new Wizard(characterName);

        System.out.println(character);
        return character;
    }

}
