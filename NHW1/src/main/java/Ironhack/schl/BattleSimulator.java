package Ironhack.schl;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BattleSimulator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Character character1 = null;
        Character character2 = null;

        while (true) {
            System.out.println("|-----Welcome to the Battle Simulator!-----|");
            System.out.println("|                 Main Menu:               |");
            System.out.println("|     1.Create your Warrior (write 1)      |");
            System.out.println("|     2.Create your Wizard  (write 2)      |");
            System.out.println("|     3.Start the Battle    (write 3)      |");
            System.out.println("|     4.Exit the game       (write 4)      |");
            System.out.print("     Enter your choice between 1 and 4:    ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character1 = createWarrior(scanner);
                    break;
                case 2:
                    character2 = createWizard(scanner);
                    break;
                case 3:
                    if (character1 != null && character2 != null) {
                        startBattle(character1, character2);

                    } else {
                        System.out.println("Please create both characters before starting the battle.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Character createWarrior(Scanner scanner) {
        System.out.println("|-----------------------|");
        System.out.print("Enter warrior's name: ");
        String name = scanner.next();
        int hp = new Random().nextInt(101) + 100;
        int strength = new Random().nextInt(10) + 1;
        int stamina = new Random().nextInt(40) + 10;
        return new Warrior(name, hp, strength, stamina);
    }


    private static Character createWizard(Scanner scanner) {
        System.out.println("|-----------------------|");
        System.out.print("Enter wizard's name: ");
        String name = scanner.next();
        int hp = new Random().nextInt(51) + 50;
        int mana = new Random().nextInt(20) + 1;
        int intelligence = new Random().nextInt(30) + 20;
        return new Wizard(name, hp, mana, intelligence);
    }

    private static void startBattle(Character character1, Character character2) {
        while (character1.isAlive() && character2.isAlive()) {
            character1.attack(character2);
            if (!character2.isAlive()) {
                break;
            }
            character2.attack(character1);
        }

        if (character1.isAlive()) {
            System.out.println("***"+character1.getName() + " wins the battle!***");
        } else {
            System.out.println("***"+character2.getName() + " wins the battle!***");

        }
    }
}
