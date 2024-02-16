//import java.util.List;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Iron Battle!");
        System.out.println("Let's create the first character!");
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

        Character firstCharacter = characters.get(firstCharacterIndex);
        Character secondCharacter = characters.get(secondCharacterIndex);

        System.out.println("Let the battle begin between " + firstCharacter.getName() + " and " + secondCharacter.getName() + "!");
        while (firstCharacter.isAlive() && secondCharacter.isAlive()) {
            firstCharacter.attack(secondCharacter);
            System.out.println(secondCharacter.getHp());
            secondCharacter.attack(firstCharacter);
            System.out.println(firstCharacter.getHp());
        }

        // Determine and print the winner. This can be added at the end of this code to announce the winner.
        Character winner = firstCharacter.isAlive() ? firstCharacter : secondCharacter;
        System.out.println("The winner is: " + winner.getName());
    }
        */
        Character firstCharacter = charactersConstructor();
        System.out.println("Character 1 finished! Let's create the second character!");
        Character secondCharacter = charactersConstructor();
        System.out.println("Character 2 finished!");

        System.out.println("Let the battle begin between " + firstCharacter.getName() + " and " + secondCharacter.getName() + "!");
        while(firstCharacter.isAlive() && secondCharacter.isAlive()){
            firstCharacter.attack(secondCharacter);
            System.out.println(secondCharacter.getHp());
            secondCharacter.attack(firstCharacter);
            System.out.println(firstCharacter.getHp());

        }
    }

    public static Character charactersConstructor(){
        CharacterInput characterInput = new CharacterInput();
        if (characterInput.getType() == 0){
            return( new Warrior(characterInput.getName(), characterInput.getHP(),
                    characterInput.getAttribute1(), characterInput.getAttribute2()));
        }
        else{
            return(new Wizard(characterInput.getName(), characterInput.getHP(),
                    characterInput.getAttribute1(), characterInput.getAttribute2()));
        }
    }
}