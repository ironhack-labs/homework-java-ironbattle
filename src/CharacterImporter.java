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
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) { /// each line has to have all the necessary info to be considered or else is skipped
                    continue;
                }
                String characterType = data[0].trim();
                String name = data[1].trim();
                int hp = Integer.parseInt(data[2].trim());
                if (characterType.equalsIgnoreCase("Warrior")) {
                    int stamina = Integer.parseInt(data[3].trim());
                    int strength = Integer.parseInt(data[4].trim());
                    characters.add(new Warrior(name, hp, stamina, strength));
                } else if (characterType.equalsIgnoreCase("Wizard")) {
                    int mana = Integer.parseInt(data[3].trim());
                    int intelligence = Integer.parseInt(data[4].trim());
                    characters.add(new Wizard(name, hp, mana, intelligence));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}