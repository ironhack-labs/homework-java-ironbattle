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
        character1 = customizeCharactersFeatures();
        character2 = customizeCharactersFeatures();
        System.out.println(character1);
        System.out.println(character2);
        battle();
    }

    private static Character customizeCharactersFeatures() {
        Character character = createCharactersByNameAndType();
        if (character instanceof Warrior) {
            int characterStamina;
            int characterStrength;

            do {
                System.out.println("Select your warrior's stamina between 10 and 50: ");
                characterStamina = scanner.nextInt();
            } while (characterStamina < 10 || characterStamina > 50);

            do {
                System.out.println("Select your warrior's strength between 1 and 10: ");
                characterStrength = scanner.nextInt();
            } while (characterStrength < 1 || characterStrength > 10);

            ((Warrior) character).setStamina(characterStamina);
            ((Warrior) character).setStrength(characterStrength);

        } else {
            int characterIntelligence;
            int characterMana;
            do {
                System.out.println("Select your wizard's mana between 10 and 50: ");
                characterMana = scanner.nextInt();
                System.out.println("characterMana: " + characterMana);
            } while (characterMana < 10 || characterMana > 50);

            do {
                System.out.println("Select your wizard's intelligence between 1 and 50: ");
                characterIntelligence = scanner.nextInt();
            } while (characterIntelligence < 1 || characterIntelligence > 50);

            ((Wizard) character).setIntelligence(characterIntelligence);
            ((Wizard) character).setMana(characterMana);
        }
        return character;
    }

    private static void customizeWizard(String characterName, int characterHp) {
    }

    private static void customizeWarrior(String characterName, int characterHp) {
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

    private static void printStats() {
        character1.printStats();
        System.out.print(" << VS >> ");
        character2.printStats();
    }
}
