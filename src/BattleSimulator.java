import model.Character;
import model.Warrior;
import model.Wizard;
import utils.Characters;
import utils.Utils;

import java.util.Scanner;

public class BattleSimulator {

    private static Character character1;
    private static Character character2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String optionMenu;
        System.out.println("******** Welcome to BattleSimulator ********");

        do {
            System.out.println("Select type of battle:");
            System.out.println("1. Full random battle");
            System.out.println("2. Customize the characters name and type");
            System.out.println("3. Customize all characters features");
            System.out.println("Press 'E' or 'e' for exit!");
            optionMenu = scanner.next();
            switch (optionMenu) {
                case "1" -> fullRandomBattle();
                case "3" -> customizeCharactersNameAndTypeBattle();
                case "4" -> customizeCharactersFeaturesBattle();
            }
        } while (!optionMenu.equalsIgnoreCase("E"));
    }

    private static void customizeCharactersNameAndTypeBattle() {
    }

    private static void customizeCharactersFeaturesBattle() {
    }

    private static void fullRandomBattle() {
        character1 = createRandomCharacter();
        character2 = createRandomCharacter();
        battle();
    }

    private static void battle() {
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
