import java.util.*;

public class CharacterFightMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Character Fight Menu ===");
            System.out.println("1. View Characters");
            System.out.println("2. Build Character");
            System.out.println("3. Fight!");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewCharacters();
                    break;
                case 2:
                    buildCharacter();
                    break;
                case 3:
                    fight();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        System.out.println("Exiting program. Goodbye!");
    }

    private static void buildCharacter() {

        if(characters.size()==2){
            System.out.println("You can only have 2 characters");
            return;
        }

        System.out.println("\n=== Build Character ===");
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        System.out.print("For Warrior press 1, for Wizard press 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice== 1) {
            characters.add(new Warrior(name, 0, 0, 0));
        }else if(choice == 2) {
//            characters.add(new Wizard(name,0,0,0));
            System.out.println();
        }else{
            System.out.println("Invalid choice. Please enter a number between 1 and 2.");
        }

//        characters.add(new Warrior(name,0,0,0));
        System.out.println("Character " + name + " created!");
    }

    private static void viewCharacters() {
        System.out.println("\n=== Characters ===");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i).getName());
        }
    }

    private static void fight() {
        if (characters.size() < 2) {
            System.out.println("Not enough characters to fight. ");
            return;
        }

        Random random = new Random();
        Character char1 = characters.get(random.nextInt(characters.size()));
        Character char2;
        do {
            char2 = characters.get(random.nextInt(characters.size()));
        } while (char2 == char1);

        System.out.println("\n=== Fight! ===");
        System.out.println(char1.getName() + " vs " + char2.getName());

        // FIGHT
        while (char1.isAlive() && char2.isAlive()) {

            char1.attack(char2);
            char2.attack(char1);

            System.out.println(char1.getName() + " HP: " + char1.getHp() + " | " + char2.getName() + " HP: " + char2.getHp());
            System.out.println();
        }

        // Determine winner
        if (char1.isAlive()) {
            System.out.println(char1.getName() + " wins!");
        } else {
            System.out.println(char2.getName() + " wins!");
        }

        // Reestablish Fighters HP
        for(Character c:characters){
            c.reestablishHp();

        }



    }


}
