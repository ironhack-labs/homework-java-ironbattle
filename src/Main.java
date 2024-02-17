import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws IOException {
        ImportCharactersFromCSV.importCharactersFromCSV();
        //Temporary creation of characters, can be deleted

        Character char1 = new Warrior("guerrero", 180, 12, 2);
        Character char2 = new Wizard("wizard", 100, 12, 2);

        Scanner scanner = new Scanner(System.in);
        boolean is_finish = false;
        int selection = 0;
        boolean not_selected = false;
        TextMenu.printBigText(3000, 0);
        TextMenu.printBigText(1000, 1);
        TextMenu.printBigText(1000, 2);
        TextMenu.printBigText(1000, 3);

        while (!is_finish) {
            getIntroMenu();
            try {
                selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        char1 = manualCharacterCreator(scanner);
                        char2 = manualCharacterCreator(scanner);
                        break;

                    case 2:
                        //Random Player creation
                        TextMenu.printBigText(2000, 4);
                        //print all char info
                        char1 = RandomChar.createRandomChar();
                        char2 = RandomChar.createRandomChar();
                        System.out.println("Players Created");

                        break;
                    case 3:
                        //CSV Import
                        ArrayList<Character> players = ImportCharactersFromCSV.importCharactersFromCSV();
                        char1 = players.get(0);
                        char2 = players.get(1);
                        //check if char are get
                        break;
                    case 4:
                        //Start the battle
                        combat(char1, char2);
                        is_finish = true;
                        break;
                    default:
                        System.out.println("Wrong Selection, Please try again");
                }
            } catch (InputMismatchException ie) {
                scanner.nextLine();
            }

        }
    }

    public static void getIntroMenu() {
        System.out.println("1- Manual Players creation. \n");
        System.out.println("2- Random Players creation. \n");
        System.out.println("3- Import Players from csv. \n");
        System.out.println("4- Start Battle             \n");
        System.out.println("5- Exit: \n");
    }

    public static Character manualCharacterCreator(Scanner scanner) {
        System.out.println("First, select your character class:\n");

        String characterName = "Default";
        int characterClass = 0;
        int characterHp = 100;
        int characterParameter1 = 20;
        int characterParameter2 = 20;
        Character character;

        //Selector for class
        boolean optionSelected = false;
        while (optionSelected == false) {
            System.out.println("1.Warrior\n2.Wizard\n");
            try {
                if(scanner.hasNextInt()) { // Verificar si hay un entero disponible para leer
                    characterClass = scanner.nextInt();
                    scanner.nextLine();
                    optionSelected = true;
                } else {
                    // Manejar el caso en el que no haya un entero disponible
                    System.out.println("Input error: No integer value entered.");
                    scanner.nextLine();
                }
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Wow! seems that the class1 you selected is not available.\n" +
                        "Please, try it again:");
            }
        }

        optionSelected = false;
        //Selector for Name
        while (optionSelected == false) {
            System.out.println("Write a name for the character");
            try {
                characterName = scanner.next();
                scanner.nextLine();
                optionSelected = true;
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Wow! seems that what you write is not possible.\n" +
                        "Please, try it again:");
            }
        }
        optionSelected = false;
        //Selector for HP
        while (optionSelected == false) {
            System.out.println("Set an HP value for the character:");
            try {
                characterHp = scanner.nextInt();
                scanner.nextLine();
                optionSelected = true;
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("you select a value out of the range \n" +
                        "Please, try it again:");
            }
        }
        optionSelected = false;
        //Selector for parameter 1
        while (optionSelected == false) {
            System.out.println("Now, select a value for ");
            if (characterClass == 1) {
                System.out.println(" stamina:");
            } else {
                System.out.println(" mana:");
            }
            try {
                characterParameter1 = scanner.nextInt();
                scanner.nextLine();
                optionSelected = true;
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("you select a value out of the range \n" +
                        "Please, try it again:");
            }
        }
        optionSelected = false;
        //Selector for parameter 2
        while (optionSelected == false) {
            System.out.println("And finally, set a value for ");
            if (characterClass == 1) {
                System.out.println(" strengh:");
            } else {
                System.out.println(" intelligence:");
            }
            try {
                characterParameter2 = scanner.nextInt();
                optionSelected = true;
                scanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("you select a value out of the range \n" +
                        "Please, try it again:");
            }
        }

        //Creation of the character
        if (characterClass == 1) {
            character = new Warrior(characterName, characterHp, characterParameter1, characterParameter2);
        } else {
            character = new Wizard(characterName, characterHp, characterParameter1, characterParameter2);
        }
        return character;
}


    public static void combat(Character char1, Character char2) {
        boolean finished = false;
        char1.setTeam(Team.A);
        char2.setTeam(Team.B);

        Bard.introducesStory();

        Character initChar1 = char1.clone();

        Bard.introducesFirstOpponent(char1);

        Character initChar2 = char2.clone();

        Bard.introducesSecondOpponent(char2);

        int roundCounter = 1;
        //Loop until one of the character wins
        while (!finished) {

            //Loop for the battle
            while (char1.isAlive() && char2.isAlive()) {
                Bard.announcesRound(roundCounter++);

                char1.attack(char2);
                Bard.narratesHp(char2);

                char2.attack(char1);
                Bard.narratesHp(char1);

                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                    Bard.announcesOpponentDeath(char1);
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                    Bard.announcesOpponentDeath(char2);
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive() && !char1.isAlive()) {
                //The battle result is a tie
                Bard.announcesTie();
                roundCounter = 0;
                char1 = initChar1.clone();
                char2 = initChar2.clone();

            } else if (!char2.isAlive()) {
                Bard.announcesOpponentVictory(char1);
                finished = true;
            } else if (!char1.isAlive()) {
                Bard.announcesOpponentVictory(char2);
                finished = true;
            }
        }
    }
}