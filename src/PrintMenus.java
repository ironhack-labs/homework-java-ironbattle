import java.util.List;
import java.util.Scanner;

public class PrintMenus {
    public static void charactersCreatorMenu(){
        System.out.println("Welcome to Iron Battle!");
        System.out.println("Get ready to forge your fighters!");
        System.out.println("Choose your character creation mode:");
        System.out.println("\t1. Console input");
        System.out.println("\t2. File input");
        System.out.println("\t3. Random generation");
        System.out.print("Enter your choice: ");
    }

    public static void printInfoCharacters(List<Character> characters){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Our characters are ready: ");
        for (Character character : characters) {

            if (character instanceof Warrior) {
                System.out.println("Warrior " + character.getName());
                System.out.println("\tHealth points: " + character.getHp());
                System.out.println("\tStamina: " + ((Warrior) character).getStamina());
                System.out.println("\tStrength: " + ((Warrior) character).getStrength() + "\n");
            } else {
                System.out.println("Wizard " + character.getName());
                System.out.println("\tHealth points: " + character.getHp());
                System.out.println("\tMana: " + ((Wizard) character).getMana());
                System.out.println("\tIntelligence: " + ((Wizard) character).getIntelligence() + "\n");
            }
        }
        System.out.println("Press Enter to start the battle.");
        scanner.nextLine();
    }

}
