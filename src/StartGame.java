import java.util.Scanner;
public class StartGame {
    public void setUp() {
        System.out.println("Welcome to the Ironbattle!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player1, choose your character: 1-Warrior , 2-Wizard");
        Character Player1 = createCharacter(scanner);

        System.out.println("Player2, choose your character: 1-Warrior , 2-Wizard");
        Character Player2 = createCharacter(scanner);
        scanner.close();

        System.out.println("Player1: " + Player1.getName() + " has " + Player1.getHP() + " health points...");
        System.out.println("Player2: " + Player2.getName() + " has " + Player2.getHP() + " health points...");
    }

    private Character createCharacter(Scanner scanner) {
        Character player =null; //así el compilador es feliz
        String playerChoice;
        //se ejecuta al menos una vez antes de comprobar las condiciones
        do {
            if (scanner.hasNextLine()) {
                playerChoice = scanner.nextLine();
            } else {
                break;
            }

            if (playerChoice.equals("1")) {
                System.out.println("Choose a name for your Warrior");
                String name = scanner.nextLine();
                player = new Warrior(name);
                break;
            } else if (playerChoice.equals("2")) {
                System.out.println("Choose a name for your Wizard");
                String name = scanner.nextLine();
                player = new Wizard(name);
                break;
            } else {
                System.out.println("Invalid input. Please enter 1 or 2");
                System.out.println("Choose your character: 1-Warrior , 2-Wizard");
            }


        } while (true);

        return player;
    }
}
