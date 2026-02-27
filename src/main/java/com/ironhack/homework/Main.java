package com.ironhack.homework;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character player1 = null;
        Character player2 = null;

        boolean stop = false;
        while (!stop) {
            System.out.println("\nMain Menu");
            System.out.println("1. Create Character 1");
            System.out.println("2. Create Character 2");
            System.out.println("3. Start Battle");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    player1 = createCharacter(scanner, "Player 1");
                    break;
                case "2":
                    player2 = createCharacter(scanner, "Player 2");
                    break;
                case "3":
                    if(player1 == null ||  player2 == null){
                        System.out.println("You must create both characters first!");
                    }else{
                        startBattle(player1,player2);
                    }
                    break;
                case "4":
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid option! Choose from valid options!");
            }
        }
        scanner.close();
    }
    public static Character createCharacter(Scanner scanner, String playerTag){
        System.out.println("\n--- Creating " + playerTag + "---");
        String type = "";

        while (!type.equals("warrior") && !type.equals("wizard")){
            System.out.println("Choose a class: Warrior or Wizard");
            type = scanner.nextLine();
        }

        System.out.println("Enter character name: ");
        String name = scanner.nextLine().trim();

        if(type.equals("warrior")){
            int hp = ThreadLocalRandom.current().nextInt(100,201);
            int stamina = ThreadLocalRandom.current().nextInt(10,51);
            int strength = ThreadLocalRandom.current().nextInt(1,11);
            System.out.println("Warrior " + name + " created! \n Hp " + hp + " Stamina " + stamina + " Strength " + strength);
            return new Warrior(name, hp, stamina, strength);
        }else{
            int hp = ThreadLocalRandom.current().nextInt(50, 101);
            int mana = ThreadLocalRandom.current().nextInt(10, 51);
            int intelligence = ThreadLocalRandom.current().nextInt(1, 51);

            System.out.println("Wizard " + name + " created! \nHp " + hp + " Mana " + mana + " Intelligence " + intelligence);
            return new Wizard(name, hp, mana, intelligence);
        }
    }
    public static void startBattle(Character player1, Character player2){
        System.out.println("\n Battle Begins! " + player1.getName() + "VS" + player2.getName());
        int round = 1;
        while(player1.isAlive() && player2.isAlive()){
            System.out.println("Round " + round);
            ((Attacker) player1).attack(player2);
            ((Attacker) player2).attack(player1);

            System.out.println(player1.getName() + " Remaining Hp: " + player1.getHp());
            System.out.println(player2.getName() + " Remaining Hp: " + player2.getHp());
            round++;
        }
        if(!player1.isAlive() && !player2.isAlive()){
            System.out.println("It's a tie!\n" + "Restarting battle!");
            resetForRematch(player1,player2);
            startBattle(player1,player2);
        } else if (player1.isAlive()) {
            System.out.println(player1.getName() + " is the winner!");
        }else{
            System.out.println(player2.getName() + " is the winner!");
        }
    }
    public static void resetForRematch(Character player1, Character player2){
        Character[] players = {player1,player2};

        for(Character player : players){
            if(player instanceof Warrior){
                player.setHp(ThreadLocalRandom.current().nextInt(100,201));
                ((Warrior) player).setStamina(ThreadLocalRandom.current().nextInt(10,51));
            }else if(player instanceof Wizard){
                player.setHp(ThreadLocalRandom.current().nextInt(50,101));
                ((Wizard) player).setMana(ThreadLocalRandom.current().nextInt(10,51));
            }
            player.setAlive(true);
        }
    }
}
