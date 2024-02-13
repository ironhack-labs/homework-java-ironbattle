import java.util.Scanner;
public class Main {
//    private static int variableGlobal;
//    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Iron Battle!");

        Character char1 = createCharacter();
        System.out.println("Character 1 finished! Let's create the second character!");

        Character char2 = createCharacter();
        System.out.println("Character 2 finished!");

    }


    public static Character createCharacter(){
        int charType = checkCharacterType();

        if (charType >= 0)
            return(fillAtributes(charType)); //newCharacter = createCharType(charType);
        else
            return (null);
    }

    public static int checkCharacterType(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Choose the character: Wizard or Warrior?");
        while (attempts++ < 3){
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                return (0);
            } else if (charType.equals("wizard")){
                return (1);
            }
            else{
                System.out.println("You can only choose Wizard or Warrior.");
            }
        }
        System.out.println("Sorry, you have exhausted the maximum number of attempts.");
        return (-1);
    }

    public static Character fillAtributes(int charType){

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

        if (charType == 0)
           return(wizardConstructor(name, atr[0], atr[1], atr[2]));
        else
            return(warriorConstructor(name, atr[0], atr[1], atr[2]));

       // System.out.println("Great! New wizard has been created");

    }

    public static Character wizardConstructor(String name, int hp, int mana, int intelligence){
        Wizard newCharacter = new Wizard(name, hp, mana, intelligence);
        return (newCharacter);
    }

    public static Character warriorConstructor(String name, int hp, int stamina, int strength){
        Character newCharacter = new Warrior(name, hp, stamina, strength);
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

