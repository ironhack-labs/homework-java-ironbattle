import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //characterSelector();
        Scanner scanner = new Scanner(System.in);
        //Temporary creation of characters, can be deleted
        Character char1 = manualCharacterCreator(scanner);
        Character char2 = manualCharacterCreator(scanner);
        //Call for the method that will do the combat
        combat(char1, char2);
        scanner.close();
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
            if (!char2.isAlive()&&!char1.isAlive()){
                //The battle result is a tie
                System.out.println("The battle results in a tie! The battle will be repeated");
                char1=initChar1.clone();
                char2=initChar2.clone();

            }else if (!char2.isAlive()){
                //Character 2 wins the battle
                System.out.println("The player "+char1.getName()+" wins the battle!");
                finished = true;
            }else if(!char1.isAlive()){
                //Character 1 wins the battle
                System.out.println("The player "+char2.getName()+" wins the battle!");
                finished = true;
            }
        }
    }
}
