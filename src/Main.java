import java.util.Scanner;
public class Main {
    private static int variableGlobal;Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Iron Battle!");

        System.out.println("Let's create first character!");
        Character firstCharacter = charactersConstructor();
        System.out.println("Character 1 finished! Let's create the second character!");
        Character secondCharacter = charactersConstructor();
        System.out.println("Character 2 finished!");
    }

    public static Character charactersConstructor(){
        CharacterInput characterInput = new CharacterInput();
        if (characterInput.getType() == 1){
            return( new Warrior(characterInput.getName(), characterInput.getHP(),
                    characterInput.getAttribute1(), characterInput.getAttribute2()));
        }
        else{
            return(new Wizard(characterInput.getName(), characterInput.getHP(),
                    characterInput.getAttribute1(), characterInput.getAttribute2()));
        }
    }
}

