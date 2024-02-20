
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Random;

public class Main {
    // ID
    private static long idCounter = 0;

    public static void main(String[] args) {
        Random random = new Random();
        int choiceMenu;
        Warrior newWarrior;
        Wizard newWizard;
      
        //Esto deberia ser una clase aparte porque sera mas facil para debugear y manejar el codigo junto con los metodos. A debatir     
        // Random class selection
        List<String> person = new ArrayList<>();
        person.add("Warrior");
        person.add("Wizard");

        // Random index generator
        int randomIndex1= random.nextInt(person.size());
        int randomIndex2= random.nextInt(person.size());

        // Characters
        String character1 = person.get(randomIndex1);
        String character2 = person.get(randomIndex2);
        
        //El id por encapsulacion y abstraccion se hace dentro de la clase Character asi que hay que migrar el create ID
        
        // Class declaration
        if (character1.equals("Wizard")){
            Wizard ch1 = new Wizard(createID(), "Character1", generatorWizard(), generatorMana(), generatorIntelligence() );
        } else {
            Warrior ch1 = new Warrior(createID(), "Character2", generatorWarrior(), generatorMana(), generatorStrength());
        }

        if (character2.equals("Wizard")){
            Wizard ch2 = new Wizard(createID(), "Character1", generatorWizard(), generatorMana(), generatorIntelligence() );
        } else {
            Warrior ch2 = new Warrior(createID(), "Character2", generatorWarrior(), generatorMana(), generatorStrength());
        }

        // Tests
        System.out.println(character1);
        System.out.println(character2);
        
        //Aqui comienza el programa 
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
                case 5:
                    System.out.println("Closing program.");
                    scanner.close();
            }
        }while(choiceMenu != 5);

    }

  //Esto tiene que ir en Character
    public static synchronized String createID ()
    {
        return String.valueOf(idCounter++);
    }

  //Renombrar a generatorRandomWarrior
    public static int generatorWarrior(){
        Random random = new Random();

        List<Integer> hp_warrior = new ArrayList<>();
        for (int i = 100; i <= 200; i++) {
            hp_warrior.add(i);
        }

        int randomIndexWarrior = random.nextInt(hp_warrior.size());

        int hp = hp_warrior.get(randomIndexWarrior);

        return hp;
    }

  
    public static int generatorStrength(){
        Random random = new Random();

        List<Integer> strengthWarrior = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            strengthWarrior.add(i);
        }
      
    //Porque es wizard?
        int randomIndexWizard = random.nextInt(strengthWarrior.size());

        int hp = strengthWarrior.get(randomIndexWizard);

        return hp;
    }

  //Renombrar a generatorRandomWizard
    public static int generatorWizard(){
        Random random = new Random();

        List<Integer> hp_wizard = new ArrayList<>();
        for (int i = 50; i <= 100; i++) {
            hp_wizard.add(i);
        }

        int randomIndexWizard = random.nextInt(hp_wizard.size());

        int hp = hp_wizard.get(randomIndexWizard);

        return hp;
    }
  
  //Si es para ambos encontrar otra palabra que mana para que no sea confuso y renombrar todo wizard a character
    public static int generatorMana(){
        Random random = new Random();

        List<Integer> manaWizard = new ArrayList<>();
        for (int i = 10; i <= 50; i++) {
            manaWizard.add(i);
        }

        int randomIndexWizard = random.nextInt(manaWizard.size());

        int hp = manaWizard.get(randomIndexWizard);

        return hp;
    }

    public static int generatorIntelligence(){
        Random random = new Random();

        List<Integer> intelligenceWizard = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            intelligenceWizard.add(i);
        }

        int randomIndexWizard = random.nextInt(intelligenceWizard.size());

        int hp = intelligenceWizard.get(randomIndexWizard);

        return hp;
        
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
