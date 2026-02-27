package org.ironhack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterFileLoader {
    public static List<Character> fromCSV(String fileName) {
        List<Character> characters = new ArrayList<>();
        File file = new File(fileName);

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                try {
                    String type = parts[0].trim();
                    String name = parts[1].trim();
                    int hp = Integer.parseInt(parts[2].trim());
                    int ressource = Integer.parseInt(parts[3].trim());
                    int attribute = Integer.parseInt(parts[4].trim());

                    if(type.equalsIgnoreCase("Warrior")) {
                        characters.add(new Warrior(name, hp, ressource, attribute));
                    } else if (type.equalsIgnoreCase("Wizard")) {
                        characters.add(new Wizard(name, hp, ressource, attribute));
                    }
                    }catch (Exception e) {
                    System.out.println("Error parsing line: " + line + ". Skipping this line. Error: " + e.getMessage());

                }
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return characters;
    }
}
