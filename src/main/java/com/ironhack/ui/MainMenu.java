package com.ironhack.ui;

import com.ironhack.factory.CharacterFactory;
import com.ironhack.io.InputHandler;
import com.ironhack.model.Character;
import com.ironhack.model.Warrior;
import com.ironhack.model.Wizard;
import com.ironhack.service.BattleSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.ironhack.io.InputHandler.readIntInRange;

public class MainMenu {
    private static final List<Character> characters = new ArrayList<>();

    private static final Random random = new Random(System.currentTimeMillis());
    private static final Scanner scanner = InputHandler.getScanner();

    public static void startRpgSimulator() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createWarrior();
                case "2" -> createWizard();
                case "3" -> startBattle();
                case "4" -> simulateBattle();
                case "5" -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========== RPG Battle Simulator ==========");
        System.out.println("1. Create Warrior");
        System.out.println("2. Create Wizard");
        System.out.println("3. Start Battle");
        System.out.println("4. Simulate Battle (random characters)");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createWarrior() {
        System.out.print("Enter name for your Warrior: ");
        String name = scanner.nextLine();

        int hp = readIntInRange("Enter HP (100-200): ", 100, 200);
        int stamina = readIntInRange("Enter Stamina (10-50): ", 10, 50);
        int strength = readIntInRange("Enter Strength (1-10): ", 1, 10);

        Warrior warrior = CharacterFactory.createWarrior(name, hp, stamina, strength);
        characters.add(warrior);

        System.out.println("Warrior " + name + " created! HP: " + warrior.getHp() +
                ", Stamina: " + warrior.getStamina() +
                ", Strength: " + warrior.getStrength());
    }

    private static void createWizard() {
        System.out.print("Enter name for your Wizard: ");
        String name = scanner.nextLine();

        int hp = readIntInRange("Enter HP (50-100): ", 50, 100);
        int mana = readIntInRange("Enter Mana (10-50): ", 10, 50);
        int intelligence = readIntInRange("Enter Intelligence (1-50): ", 1, 50);

        Wizard wizard = CharacterFactory.createWizard(name, hp, mana, intelligence);
        characters.add(wizard);

        System.out.println("Wizard " + name + " created! HP: " + wizard.getHp() +
                ", Mana: " + wizard.getMana() +
                ", Intelligence: " + wizard.getIntelligence());
    }

    private static void startBattle() {
        if (characters.size() < 2) {
            System.out.println("You need at least 2 characters to start a battle.");
            return;
        }

        System.out.println("Select two characters to battle:");
        for (int i = 0; i < characters.size(); i++) {
            Character c = characters.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " (" + c.getClass().getSimpleName() + ")");
        }

        int firstIndex = -1;
        int secondIndex = -1;

        while (firstIndex < 0 || firstIndex >= characters.size()) {
            System.out.print("Choose first character (number): ");
            firstIndex = Integer.parseInt(scanner.nextLine()) - 1;
        }

        while (secondIndex < 0 || secondIndex >= characters.size() || secondIndex == firstIndex) {
            System.out.print("Choose second character (number): ");
            secondIndex = Integer.parseInt(scanner.nextLine()) - 1;
        }

        Character c1 = characters.get(firstIndex);
        Character c2 = characters.get(secondIndex);

        BattleSimulator.fight(c1, c2);
    }

    private static void simulateBattle() {
        System.out.println("--- Simulating Battle with Random Characters ---");

        Character c1 = random.nextBoolean()
                ? CharacterFactory.createRandomWarrior("Aragorn")
                : CharacterFactory.createRandomWizard("Gandalf");
        Character c2 = random.nextBoolean()
                ? CharacterFactory.createRandomWarrior("Thorin")
                : CharacterFactory.createRandomWizard("Saruman");

        System.out.println("Generated Characters:");
        System.out.println("1. " + c1.getName() + " (" + c1.getClass().getSimpleName() + "), HP: " + c1.getHp());
        System.out.println("2. " + c2.getName() + " (" + c2.getClass().getSimpleName() + "), HP: " + c2.getHp());

        BattleSimulator.fight(c1, c2);
    }
}
