package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvCharacterLoader {
    public static List<Character> loadFromCsv(String filePath) {
        List<Character> characters = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineArr  = line.split(",");

                String name = lineArr[0];
                String type = lineArr[1];

                if (type.equalsIgnoreCase("Warrior")) {
                    int hp = Integer.parseInt(lineArr[2]);
                    int stamina  = Integer.parseInt(lineArr[3]);
                    int strength  = Integer.parseInt(lineArr[4]);
                    characters.add(new Warrior(name,hp,stamina,strength));
                } else if (type.equalsIgnoreCase("Wizard")) {
                    int hp = Integer.parseInt(lineArr[2]);
                    int mana  = Integer.parseInt(lineArr[3]);
                    int intelligance  = Integer.parseInt(lineArr[4]);
                    characters.add(new Wizard(name,hp,mana,intelligance));
                }

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return characters;
    }
}
