package battlesimulator;

import java.util.Scanner;

public class BattleSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("First character:");
        Character c1 = createCharacter(sc);

        System.out.println("Second character:");
        Character c2 = createCharacter(sc);

        System.out.println("Battle begins!");

        while (c1.isAlive() && c2.isAlive()) {
            c1.attack(c2);
            c2.attack(c1);

            printStatus(c1, c2);

            if (!c1.isAlive() && !c2.isAlive()) {
                System.out.println("Tie! Restarting...");
                c1.setHp(c1.getHp());
                c2.setHp(c2.getHp());
            }
        }

        if (c1.isAlive()) {
            System.out.println(c1.getName() + " wins!");
        } else {
            System.out.println(c2.getName() + " wins!");
        }
    }

    private static Character createCharacter(Scanner sc) {
        System.out.println("Name:");
        String n = sc.nextLine();

        System.out.println("Type (warrior/wizard):");
        String t = sc.nextLine();

        if (t.equalsIgnoreCase("warrior")) {
            return new Warrior(n, getRandomNumber(100, 200), getRandomNumber(10, 50), getRandomNumber(1, 10));
        } else if (t.equalsIgnoreCase("wizard")) {
            return new Wizard(n, getRandomNumber(50, 100), getRandomNumber(10, 50), getRandomNumber(1, 50));
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static void printStatus(Character c1, Character c2) {
        System.out.println(c1.getName() + " HP: " + c1.getHp() + ", " + c2.getName() + " HP: " + c2.getHp());
    }
}
