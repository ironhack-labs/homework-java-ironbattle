package org.example.utils;

import org.example.entity.BattleSimulator;
import org.example.entity.Warrior;
import org.example.entity.Wizard;
import org.example.entity.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util {

    private static final Random RANDOM = new Random();

    public static List<Character> importCharactersFromCSV(String filePath) {
        List<Character> importedCharacters = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 5) {
                    String type = data[0].trim();
                    String name = data[1].trim();
                    int hp = Integer.parseInt(data[2].trim());
                    int resource = Integer.parseInt(data[3].trim());
                    int power = Integer.parseInt(data[4].trim());

                    if (type.equalsIgnoreCase("Warrior")) {
                        importedCharacters.add(new Warrior(name, hp, resource, power));
                    } else if (type.equalsIgnoreCase("Wizard")) {
                        importedCharacters.add(new Wizard(name, hp, resource, power));
                    }
                }
            }
            System.out.println("Characters imported: !");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return importedCharacters;
    }

    public static Character createRandomCharacter() {
        boolean isWarrior = RANDOM.nextBoolean();
        String[] warriorNames = {"Thor", "Conan", "Arthur", "Leonidas"};
        String[] wizardNames = {"Merlin", "Gandalf", "Dumbledore", "Voldemort"};

        if (isWarrior) {
            String name = warriorNames[RANDOM.nextInt(warriorNames.length)];
            int hp = RANDOM.nextInt(101) + 100;
            int stamina = RANDOM.nextInt(41) + 10;
            int strength = RANDOM.nextInt(10) + 1;
            return new Warrior(name, hp, stamina, strength);
        } else {
            String name = wizardNames[RANDOM.nextInt(wizardNames.length)];
            int hp = RANDOM.nextInt(51) + 50; // 50-100 arası
            int mana = RANDOM.nextInt(41) + 10; // 10-50 arası
            int intelligence = RANDOM.nextInt(50) + 1; // 1-50 arası
            return new Wizard(name, hp, mana, intelligence);
        }
    }

    public static void simulateRandomBattle() {
        System.out.println("=== Random Battle Starding... ===");

        Character player1 = createRandomCharacter();
        Character player2 = createRandomCharacter();

        System.out.println("Player 1: " + player1.getName() + " (HP: " + player1.getHp() + ")");
        System.out.println("Player 2: " + player2.getName() + " (HP: " + player2.getHp() + ")");
        System.out.println("---------------------------------------------");

        BattleSimulator battleSimulator = new BattleSimulator();
        battleSimulator.startBattle(player1, player2);
    }
}
