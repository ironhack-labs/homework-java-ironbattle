import model.Battle;
import model.Character;
import model.Warrior;
import model.Wizard;
import utils.BattleType;
import utils.CharacterType;
import utils.Utils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BattleSimulator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Utils.printTittle();
        String optionChosen;
        do {
            optionChosen = selectBattleType();
        } while (!optionChosen.equals("0"));
        scanner.close();
    }

    private static String selectBattleType() {
        String optionChosen;
        do {
            System.out.println("Select type of battle");

            Arrays.stream(BattleType.values())
                    .map(BattleType::getDescription)
                    .forEach(System.out::println);

            System.out.println("Press 0 for exit!");

            optionChosen = scanner.next();
            switch (optionChosen) {
                case "1" -> new Battle(createRandomCharacter(), createRandomCharacter()).fight();
                case "2" -> new Battle(createCharactersByNameAndType(), createCharactersByNameAndType()).fight();
                case "3" -> new Battle(customizeCharactersFeatures(), customizeCharactersFeatures()).fight();
            }
        } while (!optionChosen.equals("0"));

        return optionChosen;
    }

    private static String createCharacterName(CharacterType characterType) {
        scanner.nextLine();
        String characterName;
        do {
            System.out.printf("Write a %s's name: ", characterType.getDescription());

            characterName = scanner.nextLine();
        } while (!Utils.isValidName(characterName));

        return characterName;
    }

    private static Character createCharactersByNameAndType() {
        Character character = null;
        String characterType;
        do {
            System.out.println("Select a character's type:");
            Stream.of(CharacterType.values())
                    .forEach(e -> System.out.println((e.ordinal() + 1) + " - " + e.getDescription()));

            characterType = scanner.next();
            switch (characterType) {
                case "1" -> character = new Wizard(createCharacterName(CharacterType.WIZARD));
                case "2" -> character = new Warrior(createCharacterName(CharacterType.WARRIOR));
            }
        } while (!characterType.equals("1") && !characterType.equals("2"));

        return character;
    }

    private static Character customizeCharactersFeatures() {
        Character character = createCharactersByNameAndType();
        if (character instanceof Warrior) {
            customizeWarrior((Warrior) character);
        } else {
            customizeWizard((Wizard) character);
        }

        return character;
    }

    private static void customizeWizard(Wizard wizard) {
        String mana;
        String intelligence;

        do {
            System.out.println("Select your wizard's mana between 10 and 50: ");
            mana = scanner.next();
            System.out.println("mana: " + mana);
        } while (!Utils.isValidNumberInRange(mana, Wizard.MIN_MANA , Wizard.MAX_MANA));

        do {
            System.out.println("Select your wizard's intelligence between 1 and 50: ");
            intelligence = scanner.next();
        } while (!Utils.isValidNumberInRange(intelligence, Wizard.MIN_INTELLIGENCE , Wizard.MAX_INTELLIGENCE));

        wizard.setIntelligence(Integer.parseInt(intelligence));
        wizard.setMana(Integer.parseInt(mana));
    }

    private static void customizeWarrior(Warrior warrior) {
        String stamina;
        String strength;

        do {
            System.out.println("Select your warrior's stamina between 10 and 50: ");
            stamina = scanner.next();

        } while (!Utils.isValidNumberInRange(stamina, Warrior.MIN_STAMINA, Warrior.MAX_STAMINA));

        do {
            System.out.println("Select your warrior's strength between 1 and 10: ");
            strength = scanner.next();
        } while (!Utils.isValidNumberInRange(strength, Warrior.MIN_STRENGTH, Warrior.MAX_STRENGTH));

        warrior.setStamina(Integer.parseInt(stamina));
        warrior.setStrength(Integer.parseInt(strength));
    }

    private static Character createRandomCharacter() {
        String characterInfo = Utils.getRandomCharacter();
        String characterName = characterInfo.split(",")[0];
        String characterType = characterInfo.split(",")[1];

        if (!Utils.isValidName(characterName)) {
            throw new IllegalArgumentException("Error: character name " + characterName + " is not correct");
        }

        if (!Utils.isValidType(characterType)) {
            throw new IllegalArgumentException("Error: character type " + characterType + " is not correct");
        }

        return characterType.equalsIgnoreCase(CharacterType.WARRIOR.name()) ?
                new Warrior(characterName) :
                new Wizard(characterName);
    }

}
