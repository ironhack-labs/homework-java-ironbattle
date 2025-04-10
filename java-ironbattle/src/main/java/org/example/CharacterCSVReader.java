package org.example;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CharacterCSVReader {

   private final ArrayList<Character> charactersList;


    public CharacterCSVReader(String URI) {

        this.charactersList = new ArrayList<>();
        try{
            File file = new File(URI);
            Scanner sc = new Scanner(file);
            String[] line;
            sc.nextLine();
            while(sc.hasNext()) {
                line = sc.nextLine().split(",");
                String type = line[0];
                String name = line[1];
                int hp = Integer.parseInt(line[2]);
                int attrib1 = Integer.parseInt(line[3]);
                int atrrib2 = Integer.parseInt(line[4]);
                if (type.equals("warrior")) {
                    Warrior warrior = new Warrior(name, hp, attrib1, atrrib2);
                    charactersList.add(warrior);
                } else if (type.equals("wizard")) {
                    Wizard wizard = new Wizard(name, hp, attrib1, atrrib2);
                    charactersList.add(wizard);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        System.out.println();

    }

    public Attacker[] getRandomCharacters() {
        Attacker[] chars = new Attacker[2];

        Random r = new Random();
        chars[0] = (Attacker) charactersList.get(r.nextInt(charactersList.size()));
        chars[1] = (Attacker) charactersList.get(r.nextInt(charactersList.size()));
        return chars;
    }
}
