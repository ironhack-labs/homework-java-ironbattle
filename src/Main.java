
import java.util.Scanner;
public class Main {
    private static int variableGlobal;Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Iron Battle!");

        Wizard char1 = createCharacter(); //Character char1 = createCharacter();
        System.out.println("Character 1 finished! Let's create the second character!");

        Wizard char2 = createCharacter(); // Character char2 = createCharacter();
        System.out.println("Character 2 finished!");
    }


    public static Wizard createCharacter(){ //public static Character createCharacter(){

        Wizard newCharacter = null; //Character newCharacter
        int charType = checkCharacterType();

        if (charType >= 0)
            newCharacter = fillAtributes(charType); //newCharacter = createCharType(charType);
        else
            System.out.println("byebye"); //manage error

        return (newCharacter);
    }

    public static int checkCharacterType(){

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int numType = -1;

        System.out.println("Choose the character: Wizard or Warrior?");
        while (attempts++ < 5 && numType < 0){
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                numType = 0;
            }
            else if (charType.equals("wizard")){
                numType = 1;
            }
            else{
                if (attempts == 5)
                    System.out.println("Sorry, you have exhausted the maximum number of attempts."); //manage error
                else
                    System.out.println("You can only choose Wizard or Warrior.");
            }
        }
        return (numType);
    }

    public static Wizard fillAtributes(int charType){

        System.out.println("Let's get create a Wizard character.");
        String name = enterName();
        if (name.equals(""))
            System.out.println("byebye"); //manage error
        int[] atr = {-1, -1, -1};
        for (int i = 0; i < 3; i++){
            atr[i] = enterAtribute(i, charType);
            if (atr[i] < 0){
                System.out.println("byebye"); //manage error
                break;
            }
        }
        Wizard newCharacter = new Wizard(atr[1], atr[2]);
        System.out.println("Great! New wizard has been created");

        return (newCharacter);
    }

    public static String enterName() {

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String name = "";
        System.out.println("Write the name of character");
        while (i < 3 && name.equals("")){
            if (i > 1){
                System.out.println("It is not a correct name. Try again!");
            }
            name = scanner.nextLine();
            i++;
        }

        return (name);
    }

    public static int enterAtribute(int numAtribute, int type) {

        Scanner scanner = new Scanner(System.in);

        String[] atrWarrior = {"hp", "stamina", "strenght"};
        String[] atrWizard= {"hp", "mana", "intelligence"};

        int i = 0;
        int value = -1;
        if (type == 0)
            System.out.println("Write the value of " + atrWarrior[numAtribute]);
        else
            System.out.println("Write the value of " + atrWizard[numAtribute]);
        while (i++ < 3 && value < 0){
            if (i > 1)
                System.out.println("It is not a correct range. Try again!"); // protect numbers
            value = scanner.nextInt();
        }
        scanner.nextLine();
        return (value);
    }

}
