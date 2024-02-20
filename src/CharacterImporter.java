import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/// BONUS 1
// Allows to import a file with the characters. In the Main class I added the coded to read, retrieve and select 2 characters to battle
public class CharacterImporter {
    public static List<Character> importCharactersFromCSV(String filename) { //Imports the file called in the main class
        List<Character> characters = new ArrayList<>(); /// Initializes the List
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { ///This reads the file
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) { /// each line has to have all the necessary info to be considered or else is skipped
                    continue;
                }
                String characterType = data[0].trim();
                String name = data[1].trim();
                int hp = Integer.parseInt(data[2].trim());
                int attribute1 = Integer.parseInt(data[3].trim());
                int attribute2 = Integer.parseInt(data[4].trim());

                if ((characterType.equalsIgnoreCase("Warrior") && isValidWarrior(attribute1, attribute2, hp))
                        || (characterType.equalsIgnoreCase("Wizard") && isValidWizard(attribute1, attribute2, hp))) {
                    if (characterType.equalsIgnoreCase("Warrior")) {
                        characters.add(new Warrior(name, hp, attribute1, attribute2));
                    } else if (characterType.equalsIgnoreCase("Wizard")) {
                        characters.add(new Wizard(name, hp, attribute1, attribute2));
                    }
                } else {
                    System.out.println("Skipping character: " + name + " - Attribute values are not valid.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
    private static boolean isValidWarrior(int stamina, int strength, int hp) {
        return stamina >= 10 && stamina <= 50 && strength >= 1 && strength <= 10 && hp >= 100 && hp <= 200;
    }

    private static boolean isValidWizard(int mana, int intelligence, int hp) {
        return mana >= 10 && mana <= 50 && intelligence >= 1 && intelligence <= 50 && hp >= 50 && hp <= 100;
    }
}