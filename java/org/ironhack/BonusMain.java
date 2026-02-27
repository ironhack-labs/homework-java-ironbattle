package org.ironhack;
import java.util.List;


public class BonusMain {
    public static void main(String[] args) {
        boolean winnerFound = false;
         while (!winnerFound) {
             System.out.println("=== Battle Bonus Menu ===");
             System.out.println("1.Create character manually");
             System.out.println("2.Dowland character from CSV file");
             System.out.println("3.Exit");
                int choice =TerminalReader.readIntInRange("Choose an option: ", 1, 3);

                switch (choice) {
                    case 1:
                        runManualBattle();
                        winnerFound = true;
                        break;
                    case 2:
                        runCSVBattle();
                        winnerFound = true;
                        break;
                    case 3:
                        winnerFound = true;
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                }
         }
    }

    private static Character createCharacter() {

        String name = TerminalReader.readString("Please enter your name: ");
        int type= TerminalReader.readIntInRange("Choose a character type: (1:Warrior, 2: Wizard) ", 1, 2);

        if (type==1) {
            int hp= TerminalReader.readIntInRange("Enter HP (100-200): ", 100, 200);
            int stamina= TerminalReader.readIntInRange("Enter Stamina (10-50): ", 10, 50);
            int strength= TerminalReader.readIntInRange("Enter Strength (1-10): ", 1, 10);
            return new Warrior(name, hp, stamina, strength);
        }else {
            int hp= TerminalReader.readIntInRange("Enter HP (50-100): ", 50, 100);
            int mana= TerminalReader.readIntInRange("Enter Mana (10-50): ", 10, 50);
            int intelligence= TerminalReader.readIntInRange("Enter Intelligence (1-50): ", 1, 50);
            return new Wizard(name, hp, mana, intelligence);
        }
    }

    public static  void startBattle(Character character1, Character character2) {
        int round = 1;
        System.out.println("=== Battle Start ===");
        System.out.println(character1.getName() + " vs " + character2.getName());

        while (character1.isAlive() && character2.isAlive()) {
            System.out.println("=== Round " + round + " ===");

            character1.attack(character2);
            character2.attack(character1);

            System.out.println(character1.getName() + " HP: " + character1.getHp());
            System.out.println(character2.getName() + " HP: " + character2.getHp());
            round++;
        }
        if (character1.isAlive() && !character2.isAlive()) {
            System.out.println(character1.getName() + " wins!");
        } else if (!character1.isAlive() && character2.isAlive()) {
            System.out.println(character2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void  runManualBattle() {
        System.out.println("Create Character 1:");
        Character character1 = createCharacter();

        System.out.println("Create Character 2:");
        Character character2 = createCharacter();

        startBattle(character1, character2);
    }

    public static void runCSVBattle() {
        List<Character> characters=CharacterFileLoader.fromCSV("characters.csv");

        if(characters !=null && characters.size()>=2) {
            System.out.println("Characters loaded from CSV file: and ready to battle!");
            startBattle(characters.get(0), characters.get(1));
        } else {
            System.out.println("Not enough characters loaded from CSV file.");
        }
    }
}
