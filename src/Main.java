import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Character> characters = getCharacters();
        PrintMenus.printInfoCharacters(characters);
        runBattle(characters);
    }

    public static List<Character> getCharacters(){
        PrintMenus.charactersCreatorMenu();
        Scanner scanner = new Scanner(System.in);
        do {
            String option = scanner.nextLine().trim();
            if (option.equals("1") || option.equals("2") || option.equals("3")){
                return characterCreator(option);
            } else {
                System.out.println("Incorrect option. Enter a number from 1 to 3.");
            }
        } while (true);
    }

    public static List<Character> characterCreator(String option){

        List<Character> characters = new ArrayList<>();
        if (option.equals("2")){
            characters = CharacterImporter.importCharactersFromCSV("./src/characters.csv");
        } else {
            CharacterInput characterInput;
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

    static void runBattle(List<Character> characters){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose two characters for battle:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i).getName());
        }
        int firstCharacterIndex;
        do {
            System.out.print("Choose the first character (Enter corresponding number): ");
            firstCharacterIndex = scanner.nextInt() - 1;
        } while (firstCharacterIndex < 0 || firstCharacterIndex >= characters.size());
        int secondCharacterIndex;
        do {
            System.out.print("Choose the second character (Enter corresponding number): ");
            secondCharacterIndex = scanner.nextInt() - 1;
        } while (secondCharacterIndex < 0 || secondCharacterIndex >= characters.size() || secondCharacterIndex == firstCharacterIndex);

        Character firstCharacter = characters.get(0);
        Character secondCharacter = characters.get(1);

        System.out.println("Let the battle begin between " + firstCharacter.getName() + " and " + secondCharacter.getName() + "!");
        int round = 1;
        while(firstCharacter.isAlive() && secondCharacter.isAlive()){
            firstCharacter.attack(secondCharacter);
            System.out.println(secondCharacter.getHp());
            secondCharacter.attack(firstCharacter);
            System.out.println(firstCharacter.getHp());
            Printer.asciiRoundStats(firstCharacter,secondCharacter,round);
            round++;
        }
        // Determine and print the winner. This can be added at the end of this code to announce the winner.
        Character winner = firstCharacter.isAlive() ? firstCharacter : secondCharacter;
        System.out.println("The winner is: " + winner.getName());
        Printer.asciiWinner();
    }
}
