package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    static File file = new File("resources/characters.csv");

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }

    public static String getRandomCharacter() {
        try {
            Scanner scanner = new Scanner(file);
            int numberOfCharacters = numberOfCharacters();
            int targetCharacter = Utils.generateRandomInt(1, numberOfCharacters);
            int currentCharacter = 0;
            while (scanner.hasNextLine()) {
                currentCharacter++;
                String lineContent = scanner.nextLine();
                if (currentCharacter == targetCharacter) {
                    scanner.close();
                    return lineContent;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
        return null;
    }

    protected static int numberOfCharacters() throws FileNotFoundException {
        int characters = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            characters++;
        }

        scanner.close();
        return characters;
    }

    public static int validate(int value, int min, int max, Stats statType, CharacterType characterType) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(characterType + "'s " + statType + " should be between " + min + " - " + max);
        }
        return value;
    }

    public static boolean isValidNumberInRange(String str, int min, int max) {
        System.out.println("Validating: " + str);
        try {
            int numericValue = Integer.parseInt(str);
            if (numericValue >= min && numericValue <= max) return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}




