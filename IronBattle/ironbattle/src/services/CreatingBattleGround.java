package services;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import characters.Warrior;
import characters.Wizard;

public class CreatingBattleGround {

    static List<characters.Character> characters = new ArrayList<>();


    public static List<characters.Character> addCharactersToBattleGround() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("characters.csv"))) {

            String[] playerdata = new String[6];

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                playerdata = line.split(",");

                //String name, int hp, int stamina, int strength
                if(playerdata[2].equals("Warrior")){
                    characters.add(new Warrior(playerdata[1], Integer.parseInt(playerdata[3]), Integer.parseInt(playerdata[4]), Integer.parseInt(playerdata[5])));
                }
                else{
                    characters.add(new Wizard(playerdata[1], Integer.parseInt(playerdata[3]), Integer.parseInt(playerdata[4]), Integer.parseInt(playerdata[5])));

                }

                


            }
        } 
        return characters;
    }
}
