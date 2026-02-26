package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("--- Chose Character 1 ---");
            System.out.println("1 - Warrior");
            System.out.println("2 - Wizard");
            int choice1 = sc.nextInt();
            sc.nextLine();
            System.out.print("1st character's name: ");
            String name1 = sc.nextLine();

            Character character1;
            if (choice1 == 1) {
                character1 = new Warrior(name1);
            } else {
                character1 = new Wizard(name1);
            }

            System.out.println("\n--- Chose Character 2 ---");
            System.out.println("1 - Warrior");
            System.out.println("2 - Wizard");
            int choice2 = sc.nextInt();
            sc.nextLine();

            System.out.print("2st character's name: ");
            String name2 = sc.nextLine();

            Character character2;
            if (choice2 == 1) {
                character2 = new Warrior(name2);
            } else {
                character2 = new Wizard(name2);
            }


            System.out.println("\n=== The battle begins! ===");
            System.out.println(character1.getName() + " vs " + character2.getName());

            int round = 1;

            while (character1.getIsAlive() && character2.getIsAlive()){
                System.out.println("\n ----- Round " + round + " -----");
                ((Attacker)character1).attack(character2);
                ((Attacker)character2).attack(character1);
                System.out.println(character1.getName() + " HP: " + character1.getHp());
                System.out.println(character2.getName() + " HP: " + character2.getHp());

                round++;
            }
            System.out.println("\n=== The battle is over. ===");

            if (!character1.getIsAlive() && !character2.getIsAlive()) {
                System.out.println("It's a draw! The battle begins again...\n");
                main(null); // restart
            }
            else if (character1.getIsAlive()) {
                System.out.println("Winner: " + character1.getName());
            }
            else {
                System.out.println("Winner: " + character2.getName());
            }
        }
    }
}