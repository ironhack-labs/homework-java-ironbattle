package com.ironhack.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String menu_s = "menu.wav";
    public static String startbattle_s = "startbattle.wav";
    public static String success_s = "success.wav";
    public static String fireball_s = "fireball.wav";
    public static String staffhit_s = "staffhit.wav";
    public static String weakhit_s = "weakhit.wav";
    public static String stronghit_s = "stronghit.wav";
    public static MusicPlayer player = new MusicPlayer(menu_s);

    public static void main(String[] args) throws IOException {
        System.out.println("\nWelcome to the IronBattle System!!");
		startMenu();
	}

	private static void startMenu() throws IOException {
        player.startPlaying();


        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the Menu, please select:");
        System.out.println("1 - Random Battle");
        System.out.println("2 - Custom Battle");
        System.out.println("3 - View Characters");
        System.out.println("4 - Create and Save a Character");
        System.out.println("5 - Exit");
        System.out.println("\nInsert option:");
        option = scanner.nextInt();
        switch(option){
            case 1 :
                randomBattle();
                break;
            case 2:
                customBattle();
                break;
            case 3:
                viewCharacters();
                break;
            case 4:
                createAndSaveCharacter();
                break;
            case 5:
                System.out.println("Option '5 - Exit' selected. Exiting program..");
                break;
            default:
                System.out.println("Option "+option+" not found. Exiting program...");
        }

        scanner.close();


    }

    private static void createAndSaveCharacter() throws IOException {
        Character character1 = new Warrior("a",1,1,1);

        System.out.println("\nWelcome to the Character generator!!");
        int option;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease select which character you wish to create");
        System.out.println("1 - Create new Wizard");
        System.out.println("2 - Create new Warrior");
        System.out.println("\nInsert option:");
        option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1 :
                character1 = createWizard(scanner);
                break;
            case 2:
                character1 = createWarrior(scanner);
                break;
            default:
                System.out.println("Option "+option+" not found. Exiting program...");
        }

        scanner.close();
        System.out.println("\nSaving your character in the database...");
        saveCharacter(character1);

    }

    private static void saveCharacter(Character character1) throws IOException {
        String line="";

        // GET DATA FROM CHARACTER...
        //  type,id,name,hp,stat1,stat2 // stat2 = stamina/mana
        if (character1 instanceof Warrior warrior) {
            line = "warrior,"+warrior.getId()+","+warrior.getName()+","+warrior.getHp()+","+warrior.getStrength()+","+warrior.getStamina()+"\n";
        } else if (character1 instanceof Wizard wi) {
            line = "wizard,"+wi.getId()+","+wi.getName()+","+wi.getHp()+","+wi.getIntelligence()+","+wi.getMana()+"\n";
        }

        // WRITE DATA TO FILE
        FileWriter writer = new FileWriter("characters.csv", true);
        writer.write(line);
        writer.close();
    }

    private static void viewCharacters(){
        String path = "characters.csv"; // type,id,name,hp,stat1,stat2
        String line;
        String delimiter = ",";
        int counter = 1;
        System.out.println();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                // Split the line into values
                String[] values = line.split(delimiter);

                String type = values[0];
                String name = values[2];
                String id = values[1];
                int hp = Integer.parseInt(values[3]);
                int stat1 = Integer.parseInt(values[4]);
                int stat2 = Integer.parseInt(values[5]);

                if(type.equals("warrior")){
                    System.out.println(counter+" - "+name + " is a warrior with hp "+ hp + " and has a strength of "+stat1+" and a stamina of "+stat2);
                }else if(type.equals("wizard")){
                    System.out.println(counter+" - "+name + " is a wizard with hp "+ hp + " and has an intelligence of "+stat1+" and a mana of "+stat2);
                }else{
                    System.out.println("unrecognized type for character");
                }
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally{

        }

        /*
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                // Skip header if needed
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                // Split the line into values
                String[] values = line.split(delimiter);

                String type = values[0];
                String name = values[2];
                int id = Integer.parseInt(values[1]);
                int hp = Integer.parseInt(values[3]);
                int stat1 = Integer.parseInt(values[4]);
                int stat2 = Integer.parseInt(values[5]);

                if(type.equals("warrior")){
                    System.out.println(name + " is a warrior with hp "+ hp + " and has a strength of "+stat1+" and a stamina of "+stat2);
                }else if(type.equals("wizard")){
                    System.out.println(name + " is a wizard with hp "+ hp + " and has an intelligence of "+stat1+" and a mana of "+stat2);
                }else{
                    System.out.println("unrecognized type for character");
                }
                // Process or display the data
                //System.out.println("Name: " + name + ", Age: " + age + ", Favorite Color: " + color);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */


    }

    private static void customBattle() throws IOException {
        Character character1 = new Warrior("a",1,1,1);
        Character character2 = new Warrior("a",1,1,1);
		
        int option;
        int result = 0;
        
		Scanner scanner = new Scanner(System.in);
        System.out.println("\nCustom Battle selected.");
        System.out.println("Two characters must be selected.");
        System.out.println("1 - Create new Wizard");
        System.out.println("2 - Create new Warrior");
        System.out.println("3 - Pick from database.");
        System.out.println("\nInsert option:");
        option = scanner.nextInt();
        scanner.nextLine();
		
        switch(option){
            case 1 :
                character1 = createWizard(scanner);
                break;
            case 2:
                character1 = createWarrior(scanner);
                break;
            case 3:
                character1 = pickCharacterFromDatabase(scanner);
                break;
            default:
                System.out.println("\nOption "+option+" not found. Exiting program...");
        }
		
        System.out.println("\nGreat Job! Now you must create a second Character. Which one will it be?");
        System.out.println("1 - Create new Wizard");
        System.out.println("2 - Create new Warrior");
        System.out.println("3 - Pick from database.");
        System.out.println("\nInsert option:");
        option = scanner.nextInt();
        scanner.nextLine();
		
        switch(option){
            case 1 :
                character2 = createWizard(scanner);
                break;
            case 2:
                character2 = createWarrior(scanner);
                break;
            case 3:
                character2 = pickCharacterFromDatabase(scanner);
                break;
            default:
                System.out.println("\nOption "+option+" not found. Exiting program...");
        }
		
        System.out.println("\nFantastic! Now the two character are ready for a fight! Are you ready to start the battle?");
        System.out.println("    1 - Start Battle!!");
        System.out.println("    2 - Exit");
        option =  scanner.nextInt();
        scanner.nextLine();


        int character1InitialHp = character2.getHp();
        int character1InitialStat = getStat1(character1);
        int character2InitialHp = character2.getHp();
        int character2InitialStat = getStat1(character2);

        if(option==1){
            do{
            result = startBattle(character1,character2); // DEVUELVE UNO O MÁS SI HAY QUE REPETIR, CERO SI HAY GANADOR
                // SI HAY QUE REPETIR, SETEAMOS A VALORES INICIALES
                character1.setHp(character1InitialHp);
                if (character1 instanceof Warrior warrior) {
                    warrior.setStamina(character1InitialStat);
                } else if (character1 instanceof Wizard wizard) {
                    wizard.setMana(character1InitialStat);
                }
                character2.setHp(character2InitialHp);
                if (character2 instanceof Warrior warrior) {
                    warrior.setStamina(character2InitialStat);
                } else if (character2 instanceof Wizard wizard) {
                    wizard.setMana(character2InitialStat);
                }

            }while(result!=0);
        }else{
            System.out.println("\nExiting program...");
        }

        saveTheCharacters(character1,character2,character1InitialHp,character2InitialHp,character1InitialStat,character2InitialStat);

        scanner.close();


    }

    private static Character pickCharacterFromDatabase(Scanner scanner) {
        // display database ...  put into a list so selection is easy!
        Character character1 = new Warrior("a",1,1,1);
        int selection = 0;

        System.out.println("\nPick a Character From Database selected");
        viewCharacters();
        System.out.println("\nPlease enter the number of the Character you wish to select: ");
        selection = scanner.nextInt();
        scanner.nextLine();

        character1 = getCharacterFromDatabase(selection);

        // DISPLAY CHARACTER
        if (character1 instanceof Warrior warrior) {
            System.out.println("\nThe following Warrior has been selected:");
            System.out.println(warrior.warriorInfo());
        } else if (character1 instanceof Wizard wizard) {
            System.out.println("\nThe following Wizard has been selected:");
            System.out.println(wizard.wizardInfo());
        }

        return character1;
    }

    private static Character getCharacterFromDatabase(int index) {
        Character character1 = new Warrior("a",1,1,1);

        String path = "characters.csv"; // type,id,name,hp,stat1,stat2
        String line;
        String delimiter = ",";

        List<String> character = new ArrayList<>();

        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                character.add(line);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        line = character.get(index-1);
        // Split the line into values
        String[] values = line.split(delimiter);
        String type = values[0];
        String name = values[2];
        String id = values[1];
        int hp = Integer.parseInt(values[3]);
        int stat1 = Integer.parseInt(values[4]);
        int stat2 = Integer.parseInt(values[5]);

        if(type.equals("warrior")){
            character1 = new Warrior(name,hp,stat2,stat1);
        }else if(type.equals("wizard")){
            character1 = new Wizard(name,hp,stat2,stat1);
        }else{
            System.out.println("unrecognized type for character");
        }

        return character1;
    }

    private static int getStat1(Character character1) {
        if (character1 instanceof Warrior warrior) {
            return warrior.getStamina();
        } else if (character1 instanceof Wizard wizard) {
            //System.out.println("The following Wizard has been generated:");
            return wizard.getMana();
        }
        return 0;
    }

    private static Warrior createWarrior(Scanner scanner) {
        
		Warrior warrior1;
        String tempName;
        int tempHp;
        int tempStamina;
        int tempStrength;
		
        System.out.println("\nCreate new Warrior selected.");
        System.out.println("Please enter his name:");
        tempName = scanner.nextLine();
        System.out.println("Please enter his hp (100-200):");
        tempHp = scanner.nextInt();
        System.out.println("Please enter his strength (1-10):");
        tempStrength = scanner.nextInt();
        System.out.println("Please enter his stamina (10-50):");
        tempStamina = scanner.nextInt();

        warrior1 = new Warrior(tempName,tempHp,tempStamina,tempStrength);

        System.out.println("\nThe following warrior has been created: ");
        System.out.println(warrior1.warriorInfo());

        return warrior1;
    }

    private static Wizard createWizard(Scanner scanner) {
		
        Wizard wizard1;
        String tempName;
        int tempHp;
        int tempMana;
        int tempIntelligence;
		
        System.out.println("\nCreate new Wizard selected.");
        System.out.println("Please enter his name:");
        tempName = scanner.nextLine();
        System.out.println("Please enter his hp (50-100):");
        tempHp = scanner.nextInt();
        System.out.println("Please enter his intelligence (1-50):");
        tempIntelligence = scanner.nextInt();
        System.out.println("Please enter his mana (10-50):");
        tempMana = scanner.nextInt();

        wizard1 = new Wizard(tempName,tempHp, tempMana,tempIntelligence);

        System.out.println("\nThe following wizard has been created: ");
        System.out.println(wizard1.wizardInfo());

        return wizard1;
    }

    private static void randomBattle() throws IOException {

        Character character1 = new Warrior("a",1,1,1);
        Character character2 = new Warrior("a",1,1,1);
        int result = 0;
        int character1InitialHp = 0;
        int character1InitialStat = 0;
        int character2InitialHp = 0;
        int character2InitialStat = 0;

        String[] wizardNames = {"Albus","Morgana","Circe","Saruman","Gargamel","Medea","Yennefer","Nimue","Gedwyn"};
        String[] warriorNames = {"Alaric","Ares","Arjuna","Donovan","Heracles","Ragnar","Beowulf","Pelayo","Cleopatra"};
        System.out.println("\nRandom Battle selected.");

        System.out.println("\nGenerating first character...");
        boolean type = new Random().nextBoolean(); // creating a random boolean
        if(type){ // WARRIOR
            int hp =  (int) (Math.random() * 101) + 100; //  Random between 100-200
            int strength = (int) (Math.random() * 10) + 1; // Random between 1-10
            int stamina = (int) (Math.random() * 41 ) + 10; // Random between 10-50
            int name = (int) (Math.random() * 9 ); // Random between 0-8
            character1 = new Warrior(warriorNames[name],hp,stamina,strength);
            character1InitialHp = hp;
            character1InitialStat = stamina;

        }else{ //WIZARD
            int hp =  (int) (Math.random() * 51) + 50; // Random between 50-100
            int intelligence = (int) (Math.random() * 50 ) + 1; // Random between 1-50
            int mana = (int) (Math.random() * 41 ) + 10; // Random between 10-50
            int name = (int) (Math.random() * 9 ); // Random between 0-8
            character1 = new Wizard(wizardNames[name],hp,mana,intelligence);
            character1InitialHp = hp;
            character1InitialStat = mana;
        }

        // DISPLAY CHARACTER 1
        if (character1 instanceof Warrior warrior) {
            System.out.println("The following Warrior has been generated:");
            System.out.println(warrior.warriorInfo());
        } else if (character1 instanceof Wizard wizard) {
            System.out.println("The following Wizard has been generated:");
            System.out.println(wizard.wizardInfo());
        }

        pauseBattle(3);

        System.out.println("\nGenerating second character...");
        type = new Random().nextBoolean(); // creating a random boolean
        if(type){ // WARRIOR
            int hp =  (int) (Math.random() * 101) + 100; //  Random between 100-200
            int strength = (int) (Math.random() * 10) + 1; // Random between 1-10
            int stamina = (int) (Math.random() * 41 ) + 10; // Random between 10-50
            int name = (int) (Math.random() * 9 ); // Random between 0-8
            character2 = new Warrior(warriorNames[name],hp,stamina,strength);
            character2InitialHp = hp;
            character2InitialStat = stamina;
        }else{ //WIZARD
            int hp =  (int) (Math.random() * 51) + 50; // Random between 50-100
            int intelligence = (int) (Math.random() * 50 ) + 1; // Random between 1-50
            int mana = (int) (Math.random() * 41 ) + 10; // Random between 10-50
            int name = (int) (Math.random() * 9 ); // Random between 0-8
            character2 = new Wizard(wizardNames[name],hp,mana,intelligence);
            character2InitialHp = hp;
            character2InitialStat = mana;
        }

        // DISPLAY CHARACTER 2
        if (character2 instanceof Warrior warrior) {
            System.out.println("The following Warrior has been generated:");
            System.out.println(warrior.warriorInfo());
        } else if (character2 instanceof Wizard wizard) {
            System.out.println("The following Wizard has been generated:");
            System.out.println(wizard.wizardInfo());
        }

        pauseBattle(3);

        //START BATTLE
        do{
            result = startBattle(character1,character2); // DEVUELVE UNO O MÁS SI HAY QUE REPETIR, CERO SI HAY GANADOR
            // SI HAY QUE REPETIR, SETEAMOS A VALORES INICIALES
            character1.setHp(character1InitialHp);
            if (character1 instanceof Warrior warrior) {
                warrior.setStamina(character1InitialStat);
            } else if (character1 instanceof Wizard wizard) {
                wizard.setMana(character1InitialStat);
            }
            character2.setHp(character2InitialHp);
            if (character2 instanceof Warrior warrior) {
                warrior.setStamina(character2InitialStat);
            } else if (character2 instanceof Wizard wizard) {
                wizard.setMana(character2InitialStat);
            }
        }while(result!=0);

        saveTheCharacters(character1,character2,character1InitialHp,character2InitialHp,character1InitialStat,character2InitialStat);

    }

    private static void saveTheCharacters(Character character1, Character character2, int character1InitialHp, int character2InitialHp, int character1InitialStat, int character2InitialStat) throws IOException  {
        // ASK USER IF HE WANTS TO SAVE CHARACTER
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWould you like to save the Characters that participated in this battle?");
        System.out.println("1 - Yes, save "+character1.getName()+".");
        System.out.println("2 - Yes, save "+character2.getName()+".");
        System.out.println("3 - Yes, save them both.");
        System.out.println("4 - No, thank you.");
        System.out.println("\nInsert option:");
        option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1 :
                character1.setHp(character1InitialHp);
                //STAT1
                if (character1 instanceof Warrior warrior) {
                    warrior.setStamina(character1InitialStat);
                } else if (character1 instanceof Wizard wizard) {
                    wizard.setMana(character1InitialStat);
                }
                System.out.println("\nSaving your character in the database...");
                saveCharacter(character1);
                break;
            case 2:
                character2.setHp(character2InitialHp);
                //STAT1
                if (character2 instanceof Warrior warrior) {
                    warrior.setStamina(character2InitialStat);
                } else if (character2 instanceof Wizard wizard) {
                    wizard.setMana(character2InitialStat);
                }
                System.out.println("\nSaving your character in the database...");
                saveCharacter(character2);
                break;
            case 3:
                character1.setHp(character1InitialHp);
                //STAT1
                if (character1 instanceof Warrior warrior) {
                    warrior.setStamina(character1InitialStat);
                } else if (character1 instanceof Wizard wizard) {
                    wizard.setMana(character1InitialStat);
                }
                character2.setHp(character2InitialHp);
                //STAT1
                if (character2 instanceof Warrior warrior) {
                    warrior.setStamina(character2InitialStat);
                } else if (character2 instanceof Wizard wizard) {
                    wizard.setMana(character2InitialStat);
                }
                System.out.println("\nSaving both characters in the database...");
                saveCharacter(character1);
                saveCharacter(character2);
                break;
            case 4:
                System.out.println("\nThank you for using the IronBattle system! Until next time!");
                break;
            default:
                System.out.println("\nOption "+option+" not found. Exiting program...");
        }
        scanner.close();


    }

    private static int startBattle(Character character1, Character character2) {
        player.setFile(startbattle_s);

        System.out.println("\nWitness the battle between "+character1.getName()+" and "+character2.getName()+":\n");
        pauseBattle(5);

        int outcome = 0;
        int rounds = 1;
        while(character1.getHp()>0 && character2.getHp()>0){ //FIGHT WHILE THE GUYS ARE ALIVE
            System.out.println("\nROUND "+rounds+":");

            // FIRST ATTACK
            if (character1 instanceof Warrior warrior) {
                warrior.attack(character2);
            } else if (character1 instanceof Wizard wizard) {
                wizard.attack(character2);
            }
            // SECOND ATTACK
            if (character2 instanceof Warrior warrior) {
                warrior.attack(character1);
            } else if (character2 instanceof Wizard wizard) {
                wizard.attack(character1);
            }
            // DISPLAY CHARACTER 1
            if (character1 instanceof Warrior warrior) {
                System.out.println(warrior.battleInfo());
            } else if (character1 instanceof Wizard wizard) {
                System.out.println(wizard.battleInfo());
            }
            // DISPLAY CHARACTER 2
            if (character2 instanceof Warrior warrior) {
                System.out.println(warrior.battleInfo());
            } else if (character2 instanceof Wizard wizard) {
                System.out.println(wizard.battleInfo());
            }

            pauseBattle(3);

            rounds++;
        }
        //SOMEONE DIED
        //if(character1.getHp()<=0 && character2.getHp()<=0){
        if(!character1.isAlive() && !character2.isAlive()){
            //THEY BOTH DIED
            System.out.println("\nBoth Characters are DEAD!!!");
            outcome++; // PARA QUE SE REPITA
            if(outcome>5){
                outcome = 0;
                System.out.println("Max battles target reached. Exiting battle...");
            }
            /////////////////////////////////
            //Charapters must be iniciated again. For example, create a two auxiliar object
            //outcome++
            //outcome can be between 0, 10 because we avoid troubles with a small-level hp
            //////////////////////////

            System.out.println("Initiating a new battle...");
        //}else if(character1.getHp()<=0){
        }else if(!character1.isAlive()){
            outcome = 0;
            System.out.println("\n" + character2.getName() + " won the Battle!!!");
            player.setFile(success_s);
            pauseBattle(3);
        }else{
            outcome = 0;
            System.out.println("\n" + character1.getName() + " won the Battle!!!");
            player.setFile(success_s);
            pauseBattle(3);
        }

        return outcome;
    }

    private static void pauseBattle(int i) {

//////////////This code lines stop the machine for some seconds.
        try {
            Thread.sleep(i*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
//////////////////////////////////////
    }

}
