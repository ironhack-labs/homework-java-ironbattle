package Ironbattle;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Welcome to IronBattle ===");

        // 1. Setup Fighter 1 (Manual Name, Random Stats)
        System.out.print("Enter name for Fighter 1 (Warrior): ");
        String name1 = scanner.nextLine();
        // Warrior HP: 100-200 | Stamina: 10-50 | Strength: 1-10
        Warrior p1 = new Warrior(name1, random.nextInt(101) + 100, random.nextInt(41) + 10, random.nextInt(10) + 1);

        // 2. Setup Fighter 2 (Manual Name, Random Stats)
        System.out.print("Enter name for Fighter 2 (Wizard): ");
        String name2 = scanner.nextLine();
        // Wizard HP: 50-100 | Mana: 10-50 | Intelligence: 1-50
        Wizard p2 = new Wizard(name2, random.nextInt(51) + 50, random.nextInt(41) + 10, random.nextInt(50) + 1);

        System.out.println("\n--- BATTLE START ---");

        // 3. Battle Loop
        int round = 1;
        while (p1.isAlive() && p2.isAlive()) {
            System.out.println("\nROUND " + round);

            // Both attack at the same time
            p1.attack(p2);
            p2.attack(p1);

            System.out.println(p1.getName() + " HP: " + p1.getHp());
            System.out.println(p2.getName() + " HP: " + p2.getHp());

            round++;
        }

        // 4. Result Logic
        System.out.println("\n--- BATTLE OVER ---");
        if (!p1.isAlive() && !p2.isAlive()) {
            System.out.println("It's a TIE! Restarting battle...");
            main(args); // Recursive call to restart
        } else if (p1.isAlive()) {
            System.out.println("WINNER: " + p1.getName());
        } else {
            System.out.println("WINNER: " + p2.getName());
        }
    }
}