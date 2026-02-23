package com.ironhack;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("1. Create Warrior");
        System.out.println("2. Create Wizard");

        System.out.print("Choose option: ");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name1 = sc.nextLine();

        Character player1;

        if (option == 1) {
            player1 = new Warrior(
                    name1,
                    random.nextInt(101) + 100,
                    random.nextInt(41) + 10,
                    random.nextInt(10) + 1
            );
        } else {
            player1 = new Wizard(
                    name1,
                    random.nextInt(51) + 50,
                    random.nextInt(41) + 10,
                    random.nextInt(50) + 1
            );
        }

        Character enemy = new Warrior(
                "Enemy",
                random.nextInt(101) + 100,
                random.nextInt(41) + 10,
                random.nextInt(10) + 1
        );

        BattleSimulator.startBattle(player1, enemy);
    }
}