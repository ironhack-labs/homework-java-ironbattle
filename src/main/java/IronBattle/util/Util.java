package IronBattle.util;

import IronBattle.BattleSimulator;
import IronBattle.Warrior;
import IronBattle.Wizard;
import IronBattle.Character;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util {
    private static final Random rand = new Random();

    public List<Character> importCharactersFromCSV(String fileName) throws FileNotFoundException {
        List<Character> importedCharacters = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fileName))) {
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(",");

                if(lineArray.length == 5) {
                    String type = lineArray[0].trim();
                    String name = lineArray[1].trim();
                    int hp = Integer.parseInt(lineArray[2].trim());
                    int energy = Integer.parseInt(lineArray[3].trim());
                    int power = Integer.parseInt(lineArray[4].trim());


                    if(type.equalsIgnoreCase("Wizard")) {
                        importedCharacters.add(new Wizard(name,hp,energy,power));
                    }
                    else if(type.equalsIgnoreCase("Warrior")) {
                        importedCharacters.add(new Warrior(name,hp,energy,power));
                    }
                }
            }
            System.out.println("Successfully imported characters from CSV");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found"+fileName);
        } catch (Exception e){
            System.out.println("Error while importing characters from CSV"+e.getMessage());
        }
        return importedCharacters;

    }
    public  static Character getRandomCharacter(){
        boolean isWarrior = rand.nextBoolean();
        String[] warriorNames = {
                "Achilles", "Hector", "Beowulf", "Ragnar",
                "Ares", "Maximus", "Aragorn", "Leon"
        };
        String[] wizardNames = {
                "Morgana", "Saruman", "Elminster", "Radagast",
                "Alatar", "Pallando", "Prospero", "Zatanna"
        };
        if(isWarrior){
            String warriorName = warriorNames[rand.nextInt(warriorNames.length)];
            int hp = rand.nextInt(101) + 100;
            int stamina =rand.nextInt(41) + 10;
            int strength = rand.nextInt(10) + 1;
            return new Warrior(warriorName,hp,stamina,strength);
        } else {
            String wizardName = wizardNames[rand.nextInt(wizardNames.length)];
            int hp = rand.nextInt(51) + 50;
            int mana = rand.nextInt(41) + 10;
            int intelligence = rand.nextInt(50) + 1;
            return new Wizard(wizardName,hp,mana,intelligence);
        }


    }
    public static void simulateCharacter(){
        System.out.println("Welcome to IronBattle");

        Character player1 = getRandomCharacter();
        Character player2 = getRandomCharacter();

        System.out.println("Player 1: "+player1.getName()+" Player 2: "+player2.getName());
        System.out.println("Player 1: "+player1.getHp()+" Player 2: "+player2.getHp());
        BattleSimulator battleSimulator = new BattleSimulator();
        battleSimulator.starter(player1,player2);
    }





}
