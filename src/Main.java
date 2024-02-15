import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public static void main(String[] args)throws IOException{
  ImportCharactersFromCSV.importCharactersFromCSV();
        //Temporary creation of characters, can be deleted

        Character char1 = new Warrior("guerrero",180,12,2);
        Character char2  = new Wizard("wizard",100,12,2);

        Scanner scanner = new Scanner(System.in);
        boolean is_finish=false;
        int selection=0;
        boolean not_selected = false;
        TextMenu.printBigText(3000,0);
        TextMenu.printBigText(1000,1);
        TextMenu.printBigText(1000,2);
        TextMenu.printBigText(1000,3);

        while(!is_finish ) {
            getIntroMenu();
            try{
                selection=scanner.nextInt();
                switch (selection) {
                    case 1:
                        break;

                    case 2:
                        //Random Player creation
                        TextMenu.printBigText(2000,4);
                        //print all char info
                        char1= RandomChar.createRandomChar();
                        char2= RandomChar.createRandomChar();
                        System.out.println("Players Created");

                        break;
                    case 3:
                        //CSV Import
                        ArrayList<Character> players= ImportCharactersFromCSV.importCharactersFromCSV();
                        char1= players.get(0);
                        char2= players.get(1);
                        //check if char are get
                        break;
                    case 4:
                        //Start the battle
                        combat(char1,char2);
                        is_finish=true;
                        break;
                    default:
                        System.out.println("Wrong Selection, Please try again");
                }
            }catch (InputMismatchException ie){
                scanner.nextLine();
            }

        }
    }

    public static void getIntroMenu(){
        System.out.println("1- Manual Players creation. \n");
        System.out.println("2- Random Players creation. \n");
        System.out.println("3- Import Players from csv. \n");
        System.out.println("4- Start Battle             \n");
        System.out.println("5- Exit: \n");
    }


    public static void combat(Character char1, Character char2){
        boolean finished = false;
        Character initChar1 = char1.clone();
        Character initChar2 = char2.clone();

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive()&&char2.isAlive()){
                char1.attack(char2);
                char2.attack(char1);
                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive() && !char1.isAlive()) {
                //The battle result is a tie
                System.out.println("The battle results in a tie! The battle will be repeated");
                char1 = initChar1.clone();
                char2 = initChar2.clone();

            } else if (!char2.isAlive()) {
                //Character 2 wins the battle
                System.out.println("The player " + char1.getName() + " wins the battle!");
                finished = true;
            } else if (!char1.isAlive()) {
                //Character 1 wins the battle
                System.out.println("The player " + char2.getName() + " wins the battle!");
                finished = true;
            }
        }
    }