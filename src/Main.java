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
                        char1 = ManualCreator.startManualCreator(scanner,char1,char2);
                        char2 = ManualCreator.startManualCreator(scanner,char1,char2);
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
                        Combat.startCombat(char1, char2);
                        is_finish = true;
                        break;
                    default:
                        System.out.println("Wrong Selection, Please try again");
                }
            } catch (InputMismatchException ie) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void getIntroMenu() {
        System.out.println("1- Manual Players creation. \n");
        System.out.println("2- Random Players creation. \n");
        System.out.println("3- Import Players from csv. \n");
        System.out.println("4- Start Battle             \n");
        System.out.println("5- Exit: \n");
    }

}
