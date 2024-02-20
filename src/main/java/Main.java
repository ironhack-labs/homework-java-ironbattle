import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int choiceMenu;
        Warrior newWarrior;
        Wizard newWizard;

        
        //Aqui comienza el programa batalla
        Scanner scanner = new Scanner(System.in);

        do {
            displayMenu();
            choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
                case 1:
                    newWarrior = createWarrior(scanner);
                    break;
                case 2:
                    newWizard = createWizard(scanner);
                    break;
                case 3:
                    //batalla
                case 4:
                    //batalla randomizada
                    Generator generator = new Generator();

                    //Random class selection
                    List<String> person = new ArrayList<>();
                    person.add("Warrior");
                    person.add("Wizard");

                    int randomIndex1= random.nextInt(person.size());
                    int randomIndex2= random.nextInt(person.size());

                    //Characters
                    String character1 = person.get(randomIndex1);
                    String character2 = person.get(randomIndex2);

                    //Class declaration
                    if (character1.equals("Wizard")){
                        Wizard ch1 = new Wizard( "Character1", generator.generatorWizard(), generator.generatorMana(), generator.generatorIntelligence() );
                    } else {
                        Warrior ch1 = new Warrior( "Character2", generator.generatorWarrior(), generator.generatorMana(), generator.generatorStrength());
                    }

                    if (character2.equals("Wizard")){
                        Wizard ch2 = new Wizard( "Character1", generator.generatorWizard(), generator.generatorMana(), generator.generatorIntelligence() );
                    } else {
                        Warrior ch2 = new Warrior( "Character2", generator.generatorWarrior(), generator.generatorMana(), generator.generatorStrength());
                    }
                case 5:
                    System.out.println("Closing program.");
                    scanner.close();
            }
        }while(choiceMenu != 5);

    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create Warrior");
        System.out.println("2. Create Wizard");
        System.out.println("3. Start Battle");
        System.out.println("4. Create random battle");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static Warrior createWarrior(Scanner scanner){
        int hp;
        int stamina;
        int strength;
        System.out.println("Enter your warrior's name:");
        scanner.nextLine();
        String name = scanner.nextLine();

        do{
            System.out.println("Enter your warrior's hp (100-200):");
            hp = scanner.nextInt();
            if(hp < 100 || hp > 200){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 100 and 200.");
            }
        }while(hp < 100 || hp > 200);

        do{
            System.out.println("Enter your warrior's stamina (10-50):");
            stamina = scanner.nextInt();
            if(stamina < 10 || stamina > 50){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 10 and 50.");
            }
        }while (stamina < 10 || stamina > 50);

        do {
            System.out.println("Enter your warrior's strength (1-10)");
            strength = scanner.nextInt();
            if(strength < 1 || strength > 10){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 1 and 10.");
            }
        }while (strength < 1 || strength > 10);

        Warrior warrior = new Warrior(name, hp, stamina, strength);
        System.out.println("Congratulations! Your warrior "+warrior.getName()+" is created.");
        return warrior;
    }

    private static Wizard createWizard(Scanner scanner){
        int hp;
        int mana;
        int intelligence;

        System.out.println("Enter your wizard's name:");
        scanner.nextLine();
        String name = scanner.nextLine();

        do{
            System.out.println("Enter your wizards's hp (50-100):");
            hp = scanner.nextInt();
            if(hp < 50 || hp > 100){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 50 and 100.");
            }
        }while(hp < 50 || hp > 100);

        do{
            System.out.println("Enter your wizard's mana (10-50):");
            mana = scanner.nextInt();
            if(mana < 10 || mana > 50){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 10 and 50.");
            }
        }while (mana < 10 || mana > 50);

        do {
            System.out.println("Enter your wizard's intelligence (1-50)");
            intelligence = scanner.nextInt();
            if(intelligence < 1 || intelligence > 50){
                System.out.println("Sorry the number you enter is wrong. Please, enter a number between 1 and 50.");
            }
        }while (intelligence < 1 || intelligence > 50);

        Wizard wizard = new Wizard(name, hp, mana, intelligence);
        System.out.println("Congratulations! Your wizard "+wizard.getName()+" is created.");
        return wizard;
    }
}
