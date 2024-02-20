import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Character> characters = getCharacters();
        printInfoCharacters(characters);
        runBattle(characters);
    }

    public static void charactersCreatorMenu(){
        System.out.println("Welcome to Iron Battle!");
        System.out.println("Get ready to forge your fighters!");
        System.out.println("Choose your character creation mode:");
        System.out.println("\t1. Console input");
        System.out.println("\t2. File input");
        System.out.println("\t3. Random generation");
        System.out.print("Enter your choice: ");
    }

    public static List<Character> getCharacters(){
        charactersCreatorMenu();
        Scanner scanner = new Scanner(System.in);
        do {
            String option = scanner.nextLine();
            if (option.equals("1") || option.equals("2") || option.equals("3")){
                return characterCreator(option);
            } else {
                System.out.println("Incorrect option. Enter a number from 1 to 3.");
            }
        } while (true);
    }

    public static List<Character> characterCreator(String option){
        CharacterInput characterInput;
        List<Character> characters = new ArrayList<>();
        if (option.equals("2")){
            characters = CharacterImporter.importCharactersFromCSV("characters.csv");
        } else {
            for (int i=0; i<2; i++){
                if (option.equals("1")){
                    characterInput = new CharacterInput();
                } else {
                    characterInput = new CharacterInput("random");
                }
                characters.add(characterInput.characterCreatorInput());
            }
        }
        return characters;
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

    static void runBattle(List<Character> characters){
        Character firstCharacter = characters.get(0);
        Character secondCharacter = characters.get(1);

        System.out.println("Let the battle begin between " + firstCharacter.getName() + " and " + secondCharacter.getName() + "!");
        while(firstCharacter.isAlive() && secondCharacter.isAlive()){
            firstCharacter.attack(secondCharacter);
            System.out.println(secondCharacter.getHp());
            secondCharacter.attack(firstCharacter);
            System.out.println(firstCharacter.getHp());

        }
        // Determine and print the winner. This can be added at the end of this code to announce the winner.
        Character winner = firstCharacter.isAlive() ? firstCharacter : secondCharacter;
        System.out.println("The winner is: " + winner.getName());
    }


}
//System.out.println("Let's create first character!");
//Upload by CSV method  BONUS 1
       /* List<Character> characters = CharacterImporter.importCharactersFromCSV("characters.csv"); // Path to the CSV file.
       // To check if characters.csv were uploaded successfully
        if (characters.isEmpty()) {
            System.out.println("No characters loaded from CSV. Adeuuu...");
            return;
        }
        /// To print all characters
        System.out.println("Characters loaded from CSV:");
        for (Character character : characters) {
            System.out.println(character.getName() + " (" + character.getClass().getSimpleName() + ")");
        }

        //// To choose the characters to fight
        Scanner scanner = new Scanner(System.in);
        int firstCharacterIndex, secondCharacterIndex;
        do {
            System.out.println("Choose the first character for battle (Enter corresponding number):");
            firstCharacterIndex = scanner.nextInt() - 1;
        } while (firstCharacterIndex < 0 || firstCharacterIndex >= characters.size());

        do {
            System.out.println("Choose the second character for battle (Enter corresponding number):");
            secondCharacterIndex = scanner.nextInt() - 1;
        } while (secondCharacterIndex < 0 || secondCharacterIndex >= characters.size() || secondCharacterIndex == firstCharacterIndex);

       */

  /* public static void printInfoCharacter(CharacterInput character){
        System.out.println("Fighter 1: " + character.getName());
        System.out.println("Health points: " + character.getHP());
        System.out.println("Attribute1: " + character.getAttribute1());
        System.out.println("Attribute2: " + character.getAttribute2());

    }*/