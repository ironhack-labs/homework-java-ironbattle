import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws IOException {
        ImportCharactersFromCSV.importCharactersFromCSV();
        //Temporary creation of characters, can be deleted

        Character char1 = null;
        Character char2 = null;

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
                        char1 = manualCharacterCreator(scanner,char1,char2);
                        char2 = manualCharacterCreator(scanner,char1,char2);
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

    public static Character manualCharacterCreator(Scanner scanner, Character char1, Character char2) {
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
                characterClass = scanner.nextInt();
                scanner.nextLine();
                optionSelected = true;
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Wow! seems that the class you selected is not available.\n" +
                        "Please, try it again:");
            }
            if(characterClass ==1 || characterClass == 2 ){
                optionSelected = true;
            }else{
                System.out.println("Ops! You select an option not available. Please, try it again:");
            }
        }


        //Selector for Name
        optionSelected = false;
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


        //Selector for HP
        optionSelected = false;
        int [] hpMinMax = {0,0};
        if(characterClass == 1){
            hpMinMax = Warrior.getHP_RANGE();
        }else{
            hpMinMax = Wizard.getHP_RANGE();
        }
        System.out.println("Set a value for HP between "+hpMinMax[0] +" and "+ hpMinMax[1]+" for the character:");
        while (optionSelected == false) {
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


        //Selector for parameter 1
        optionSelected = false;
        String parameter1;
        int [] parameter1Range = {0,0};
        if(characterClass == 1){
            parameter1Range = Warrior.getSTAMINA_RANGE();
            parameter1 = "stamina";
        }else{
            parameter1Range = Wizard.getMANA_RANGE();
            parameter1 =  "mana";
        }
        System.out.println("Set a value for "+parameter1+" between "+parameter1Range[0] +" and "+ parameter1Range[1]+" for the character:");
        while (optionSelected == false) {
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


        //Selector for parameter 2
        optionSelected = false;
        String parameter2;
        int [] parameter2Range = {0,0};
        if(characterClass == 1){
            parameter2Range = Warrior.getSTRENGTH_RANGE();
            parameter2 = "strength";
        }else{
            parameter2Range = Wizard.getINTELLIGENCE_RANGE();
            parameter2 =  "intelligence";
        }
        System.out.println("Set a value for "+parameter2+" between "+parameter2Range[0] +" and "+ parameter2Range[1]+" for the character:");
        while (optionSelected == false) {
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
