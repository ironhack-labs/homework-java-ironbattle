import model.Character;
import model.Warrior;
import model.Wizard;
import org.w3c.dom.ls.LSOutput;
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
            System.out.println("2. Customize characters' name and type");
            System.out.println("3. Customize all characters features");
            System.out.println("Press 'E' or 'e' for exit!");
            optionMenu = scanner.next();
            switch (optionMenu) {
                case "1" -> fullRandomBattle();
                case "2" -> customizeCharactersNameAndTypeBattle();
                case "3" -> customizeCharactersFeaturesBattle();
            }
        } while (!optionMenu.equalsIgnoreCase("E"));
    }

    private static void customizeCharactersNameAndTypeBattle() {
        character1 = createCharactersByNameAndType();
        character2 = createCharactersByNameAndType();
        System.out.println(character1);
        System.out.println(character2);
        battle();
    }
    private static Character createCharactersByNameAndType() {
        Character character = null;

        System.out.println("Write your character's name:");
        String characterName = scanner.next();
        String characterType;
        do {
            System.out.println("Select your character's type:");
            System.out.println("1. Warrior");
            System.out.println("2. Wizard");
            characterType = scanner.next();
            switch (characterType) {
                case "1" -> character = new Warrior(characterName);
                case "2" -> character = new Wizard(characterName);
            }
        } while (!characterType.equals("1") && !characterType.equals("2"));

        return character;
    }

    private static void customizeCharactersFeaturesBattle() {
        character1 = createFullCharacter();
        System.out.println(character1);
        character2 = createFullCharacter();
        System.out.println(character2);
        battle();
    }

    private static Character createFullCharacter() {
        System.out.println("Write your character's name:");
        String characterName = scanner.next();
        System.out.println("Write your character's hp:");
        int characterHp = scanner.nextInt();
        String characterType;
        Character character = null;

        do {
            System.out.println("Select your character's type:");
            System.out.println("1. Warrior");
            System.out.println("2. Wizard");
            characterType = scanner.next();
            switch (characterType) {
                case "1" -> character = createWarrior(characterName, characterHp);
                case "2" -> character = createWizard(characterName, characterHp);
            }
        } while (characterType.equals("1") && characterType.equals("2"));

        return character;
    }

    private static Character createWizard(String characterName, int characterHp) {
        Wizard wizard = new Wizard(characterName);
        wizard.setHp(characterHp);
        System.out.println("Write your character's mana:");
        wizard.setMana(23);
        System.out.println("Write your character's intelligence:");
        wizard.setIntelligence(150);
        return wizard;
    }

    private static Character createWarrior(String characterName, int characterHp) {
        Warrior warrior = new Warrior(characterName);
        warrior.setHp(characterHp);
        System.out.println("Write your character's stamina:");
        warrior.setStamina(45);
        System.out.println("Write your character's strength:");
        warrior.setStrength(78);
        return warrior;
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

        Character character = characterType.equalsIgnoreCase(Characters.WARRIOR.name()) ?
                new Warrior(characterName) :
                new Wizard(characterName);

        System.out.println(character);
        return character;
    }

}
