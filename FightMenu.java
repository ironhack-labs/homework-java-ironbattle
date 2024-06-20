import java.util.*;

public class FightMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Character> characters = new ArrayList<>();
    private static final int MAX_CHARACTERS = 2;

    FightMenu(){
        showMenu();
    }

    private static void showMenu() {
        boolean exit = false;
        while (!exit) {

            System.out.println("\n⚔\uFE0F WELCOME TO THE IRONBATTLE! ⚔\uFE0F \n === Character Fight Menu ===");
            System.out.println("1. Create Random Character");
            System.out.println("2. Build Character");
            System.out.println("3. Fight!");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        if(characters.size()==MAX_CHARACTERS){System.out.println("You can only have 2 characters");}
                        else{createRandomCharacter();}
                        break;

                    case 2:
                        if(characters.size()==MAX_CHARACTERS){System.out.println("You can only have 2 characters");}
                        else{buildCharacter();}
                        break;

                    case 3:
                        if (characters.size() < MAX_CHARACTERS) {System.out.println("Not enough characters to fight. ");}

                        else{
                            new Battleground(characters.get(0), characters.get(1));
                            characters.get(0).resetHp();
                            characters.get(1).resetHp();
                        }
                        break;

                    case 4:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }
        System.out.println("Exiting program. See you later :) !");
    }

    private static void createRandomCharacter() {
        String type="";
        Random random = new Random();

        int characterType = random.nextInt(2) + 1;

        if (characterType == 1) {
            type="Warrior"+(characters.size() + 1);
            characters.add(new Warrior(type, 0, 0, 0));

        } else {
            type="Wizard"+(characters.size() + 1);
            characters.add(new Wizard(type, 0, 0, 0));

        }

        System.out.println("Random "+ type+ " created!");
    }

    private static void buildCharacter() {
        String type = "";

        System.out.println("\n=== Build Character ===");
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        System.out.print("For Warrior press 1, for Wizard press 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice== 1) {
            characters.add(new Warrior(name, 0, 0, 0));
            type="Warrior";

        }else if(choice == 2) {
            characters.add(new Wizard(name,0,0,0));
            type="Wizard";

        }else{
            System.out.println("Invalid choice. Please enter a number between 1 and 2.");
        }

        System.out.println();
        System.out.println(type +" " + name + " created!");
    }

}
