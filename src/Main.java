
import java.util.Scanner;
public class Main {
    private static int variableGlobal;Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Iron Battle!");

        CharacterInput firstCharacter = new CharacterInput();

        System.out.println("Character 1 finished! Let's create the second character!");
        CharacterInput secondCharacter = new CharacterInput();

        System.out.println("Character 2 finished!");
    }
}
