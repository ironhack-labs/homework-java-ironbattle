package com.ironhack;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Character character1;
        Character character2;

        String name1;
        String type1;
        String name2;
        String type2;

        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Please enter a name for Player1: ");
            name1 = scanner.nextLine();
            System.out.println("Please enter a character type for Player1: (wizard or warrior only)");
            type1 = scanner.next();
            scanner.nextLine();

            System.out.println("Please enter a name for Player2: ");
            name2 = scanner.nextLine();
            System.out.println("Please enter a character type for Player2: (wizard or warrior only)");
            type2 = scanner.next();
            scanner.nextLine();
        }

        if(type1.equals("wizard")){
            character1 = createWizard(name1);
        }
        else if(type1.equals("warrior")){
            character1 = createWarrior(name1);
        }
        else {
            throw new IllegalArgumentException("Wrong character type! warrior or wizard only!");
        }

        if(type2.equals("wizard")){
            character2 = createWizard(name2);
        }
        else if(type2.equals("warrior")){
            character2 = createWarrior(name2);
        }
        else {
            throw new IllegalArgumentException("Wrong character type! warrior or wizard only!");
        }


        startBattle(character1, character2);
    }

    public static Wizard createWizard(String name){
        int hp = ThreadLocalRandom.current().nextInt(50, 101);
        int mana = ThreadLocalRandom.current().nextInt(10, 51);
        int intelligence = ThreadLocalRandom.current().nextInt(1, 51);

        Wizard wizardCharacter = new Wizard(name, hp, mana, intelligence);
        System.out.println("A Wizard Character with " + hp + " HP, named " + wizardCharacter.getName() + ", with " + wizardCharacter.getMana() + " Mana and " + wizardCharacter.getIntelligence() + " Intelligence is created!");
        return wizardCharacter;
    }

    public static Warrior createWarrior(String name){
        int hp = ThreadLocalRandom.current().nextInt(100, 201);
        int stamina = ThreadLocalRandom.current().nextInt(10, 51);
        int strength = ThreadLocalRandom.current().nextInt(1, 11);

        Warrior warriorCharacter = new Warrior(name, hp, stamina, strength);
        System.out.println("A Warrior Character with " + hp + " HP, named " + warriorCharacter.getName() + ", with " + warriorCharacter.getStamina() + " Stamina and " + warriorCharacter.getStrengh() + " Strength is created!");
        return warriorCharacter;
    }

    public static void startBattle(Character character1, Character character2){
        System.out.println("=== BATTLE STARTED! ===");
        int rounds = 0;

        while(character1.getLifeStatus() && character2.getLifeStatus()){
            System.out.println("=== Round " + rounds + " ===");

            character1.attack(character2);
            character2.attack(character1);
            rounds++;
        }

        if(!character1.getLifeStatus() && !character2.getLifeStatus()){
            character1.resetStats();
            character2.resetStats();
            startBattle(character1, character2);
        }
        else {
            Character winner = character1.getLifeStatus() ? character1 : character2;
            System.out.println("The WINNER is : " + winner.getName());
            System.out.println("=== THE BATTLE IS OVER ===");
        }

    }

}