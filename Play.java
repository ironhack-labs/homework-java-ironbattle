import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Play {

    private static void battle(Character character1, Character character2){
        int round = 0;
        while (character1.isAlive() && character2.isAlive()){
            round++;
            System.out.println("Round " + round);
            System.out.println(character1.getName() + " vs " + character2.getName());
            character1.attack(character2);
            character2.attack(character1);
        }
    }

    //If fight until one of them wins, modify method to return and push the winner back to a new winner stack for loop until stacks are empty
    private static void battle(Stack<Character> characters){
        if (characters.size() % 2 != 0) {
            System.out.println("Odd number of characters," +  characters.pop().getName() +" will be left out.");
        }
        int counter = 0;
        while (characters.size() > 1){
            counter++;
            System.out.println("Battle " + counter);
            System.out.println("====================================");
            var character1 = characters.pop();
            var character2 = characters.pop();
            battle (character1,character2);
        }
    }

    private static Stack<Character> readFromCSV(File file) throws FileNotFoundException {
        Stack<Character> characters = new Stack<>();
        var fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            var line = fileScanner.nextLine();
            var data = line.split(",");

            String characterType = data[0];
            String characterName = data[1];

            if (characterType.equals("Warrior")) {
                characters.push(new Warrior(characterName));
            } else if (characterType.equals("Wizard")) {
                characters.push(new Wizard(characterName));
            }
        }
        fileScanner.close();
        return characters;
    }

    //Can use Faker or read names from CSV and generate random characters
    private static Stack<Character> charactersFactory(int numberOfCharacters) {
        Stack<Character> characters = new Stack<>();
        var random = new Random();
        for (int i = 0; i < numberOfCharacters; i++) {
            if(random.nextDouble()>0.5){
                characters.push(new Warrior("Warrior " + i));
            } else {
                characters.push(new Wizard("Wizard " + i));
            }
        }
        return characters;
    }


    private static void menu() {
      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while (running) {
          displayMenu();
          String option = scanner.nextLine();

          switch (option) {
              case "1":
                  try {
                      var file = new File("characters.csv");
                      battle(readFromCSV(file));
                  } catch (FileNotFoundException e) {
                      System.out.println("Error: File not found");
                  }
                  break;

              case "2":
                  System.out.println("Enter a odd number of characters to generate (each battle must be between two characters): ");
                  try {
                      int numberOfCharacters = Integer.parseInt(scanner.nextLine());
                      battle(charactersFactory(numberOfCharacters));
                  } catch (NumberFormatException e) {
                      System.out.println("Error: Please enter a valid number");
                  }
                  break;

              case "3":
                  System.out.println("Select the type of characters to create:");
                  System.out.println("Enter 1 for Wizard or 2 for Warrior");
                  var character1= new Character();
                  String type = scanner.nextLine();
                    if(type.equals("1")) {
                        System.out.println("Enter the Wizard name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the health points of the Wizard between 50 and 100: ");
                        String hp = scanner.nextLine();
                        System.out.println("Enter the intelligence of the Wizard between 1 and 50: ");
                        String intelligence = scanner.nextLine();
                        System.out.println("Enter the mana point of the Wizard between 10 and 50: ");
                        String mana = scanner.nextLine();
                        character1 = new Wizard(name, Integer.parseInt(hp), Integer.parseInt(intelligence), Integer.parseInt(mana));
                    }else if(type.equals("2")){
                        System.out.println("Enter the Warrior name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the health points of the Warrior between 100 and 200: ");
                        String hp = scanner.nextLine();
                        System.out.println("Enter the stamina of the Warrior between 10 and 50: ");
                        String stamina = scanner.nextLine();
                        System.out.println("Enter the strength point of the Warrior between 1 and 10: ");
                        String strength = scanner.nextLine();
                        character1 = new Warrior(name, Integer.parseInt(hp), Integer.parseInt(stamina), Integer.parseInt(strength));
                    }else{
                        System.out.println("Invalid option. Please try again.");
                        break;
                    }

                  System.out.println("Select the type of the second character to create:");
                  System.out.println("Enter 1 for Wizard or 2 for Warrior");
                  var character2 = new Character();
                  type = scanner.nextLine();
                  if (type.equals("1")) {
                      System.out.println("Enter the Wizard name: ");
                      String name = scanner.nextLine();
                      System.out.println("Enter the health points of the Wizard between 50 and 100: ");
                      String hp = scanner.nextLine();
                      System.out.println("Enter the intelligence of the Wizard between 1 and 50: ");
                      String intelligence = scanner.nextLine();
                      System.out.println("Enter the mana point of the Wizard between 10 and 50: ");
                      String mana = scanner.nextLine();
                      character2 = new Wizard(name, Integer.parseInt(hp), Integer.parseInt(intelligence), Integer.parseInt(mana));
                  }else if(type.equals("2")){
                      System.out.println("Enter the Warrior name: ");
                      String name = scanner.nextLine();
                      System.out.println("Enter the health points of the Warrior between 100 and 200: ");
                      String hp = scanner.nextLine();
                      System.out.println("Enter the stamina of the Warrior between 10 and 50: ");
                      String stamina = scanner.nextLine();
                      System.out.println("Enter the strength point of the Warrior between 1 and 10: ");
                      String strength = scanner.nextLine();
                      character2 = new Warrior(name, Integer.parseInt(hp), Integer.parseInt(stamina), Integer.parseInt(strength));
                  }else{
                      System.out.println("Invalid option. Please try again.");
                      break;
                  }

                  battle(character1, character2);
                  break;

              case "4", "exit":
                  running = false;
                  break;

              default:
                  System.out.println("Invalid option. Please try again.");
          }
      }
      scanner.close();
  }

    private static void displayMenu() {
        System.out.println("\n======== Iron Battle ========");
        System.out.println("1. Read from CSV");
        System.out.println("2. Generate random characters");
        System.out.println("3. Create your own characters");
        System.out.println("4. Exit");
        System.out.println("=============================");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {

        menu();
    }
}


