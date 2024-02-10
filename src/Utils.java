import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    static File file = new File("src/characters.csv");

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }

    public static String getRandomCharacter() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numberOfCharacters = numberOfCharacters();
        int targetCharacter = Utils.generateRandomInt(1,numberOfCharacters);
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
        return null;
    }

    public static int numberOfCharacters() throws FileNotFoundException {
        int characters = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            characters++;
        }

        scanner.close();
        return characters;
    }

}




