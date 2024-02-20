import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterImporter {
    public CharacterImporter() {
    }

    public static List<Character> importCharactersFromCSV(String filename) {
        List<Character> characters = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            try {
                String header = br.readLine();

                label54:
                while(true) {
                    while(true) {
                        String[] data;
                        do {
                            String line;
                            if ((line = br.readLine()) == null) {
                                break label54;
                            }

                            data = line.split(",");
                        } while(data.length != 5);

                        String characterType = data[0].trim();
                        String name = data[1].trim();
                        int hp = Integer.parseInt(data[2].trim());
                        int attribute1 = Integer.parseInt(data[3].trim());
                        int attribute2 = Integer.parseInt(data[4].trim());
                        if (characterType.equalsIgnoreCase("Warrior") && isValidWarrior(attribute1, attribute2, hp) || characterType.equalsIgnoreCase("Wizard") && isValidWizard(attribute1, attribute2, hp)) {
                            if (characterType.equalsIgnoreCase("Warrior")) {
                                characters.add(new Warrior(name, hp, attribute1, attribute2));
                            } else if (characterType.equalsIgnoreCase("Wizard")) {
                                characters.add(new Wizard(name, hp, attribute1, attribute2));
                            }
                        } else {
                            System.out.println("Skipping character: " + name + " - Attribute values are not valid.");
                        }
                    }
                }
            } catch (Throwable var12) {
                try {
                    br.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            br.close();
        } catch (IOException var13) {
            var13.printStackTrace();
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