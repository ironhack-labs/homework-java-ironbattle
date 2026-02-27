package ironhack;

import ironhack.Characters.Character;
import ironhack.Characters.Warrior;
import ironhack.Characters.Wizard;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    static void main() {
        start();
    }

    public static void start() {
        System.out.println("=== CHARACTER CREATION ===");

        Character c1 = createCharacter();
        Character c2 = createCharacter();

        Battle battle = new Battle(c1, c2);
        battle.start();
    }

    private static Character createCharacter() {
        System.out.println("\nSelect which character you want to create: ");
        System.out.println("1) Warrior");
        System.out.println("2) Wizard");

        int choice = readInt(1, 2);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        if (choice == 1) {
            int hp = randomBetween(100, 200);
            int stamina = randomBetween(10, 50);
            int strength = randomBetween(1, 10);

            return new Warrior(name, hp, stamina, strength);
        } else {
            int hp = randomBetween(50, 100);
            int mana = randomBetween(10, 50);
            int intelligence = randomBetween(1, 50);

            return new Wizard(name, hp, mana, intelligence);
        }
    }

    private static int randomBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int readInt(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value < min || value > max) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a number between " + min + " and " + max + ": ");
            }
        }
    }
}