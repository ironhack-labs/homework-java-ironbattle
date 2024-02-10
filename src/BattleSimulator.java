import java.util.Scanner;

public class BattleSimulator {

    private static Character character1;
    private static Character character2;

    public static void main(String[] args) {

        String optionMenu;
        Scanner scanner;
        System.out.println("******** Welcome to BattleSimulator ********");
        do {
            System.out.println("Select type of battle:");
            System.out.println("1. Full random battle");
            System.out.println("2. Customize the characters name");
            System.out.println("Press 'E' or 'e' for exit!");

            scanner = new Scanner(System.in);
            optionMenu = scanner.next();
            if (optionMenu.equalsIgnoreCase("E")) break;
            if (optionMenu.equalsIgnoreCase("1")) {
                fullRandomBattle();
            }
        } while (true);

    }

    private static void fullRandomBattle() {
        character1 = createCharacter();
        character2 = createCharacter();
        int round = 1;
        do {
            System.out.printf("ROUND %d FIGHT! %n", round);
            character1.attack(character2);
            character2.attack(character1);
            System.out.printf("%s health: %d - %s health: %d %n",
                    character1.getName(), character1.getHp(),
                    character2.getName(), character2.getHp());
            round++;
        } while (character1.getHp() > 0 && character2.getHp() > 0);
        System.out.println("GAME OVER!!!");
    }

    private static Character createCharacter() {
        String characterInfo = Utils.getRandomCharacter();
        String characterName = characterInfo.split(",")[0];
        String characterType = characterInfo.split(",")[1];

        Character character;

        if (characterType.equalsIgnoreCase(Characters.Warrior.name())) {
            character = new Warrior(characterName);
        } else {
            character = new Wizard(characterName);
        }

        System.out.println(character);
        return character;
    }

    private static void clearTerminalWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
