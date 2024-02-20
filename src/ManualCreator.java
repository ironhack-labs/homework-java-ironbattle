import java.util.InputMismatchException;
import java.util.Scanner;

public class ManualCreator {

    public static Character startManualCreator(Scanner scanner, Character char1, Character char2){
        System.out.println("First, select your character class:\n");
        String characterName = "Default";
        int characterClass = 0;
        int characterHp = 100;
        int characterParameter1 = 20;
        int characterParameter2 = 20;
        Character character;

        //Selector for class
        boolean optionSelected = false;
        while (optionSelected == false) {
            System.out.println("1.Warrior\n2.Wizard\n");
            try {
                characterClass = scanner.nextInt();
                scanner.nextLine();
                if(characterClass ==1 || characterClass == 2 ){
                    optionSelected = true;
                }else{
                    System.err.println("Ops! You select an non available option. Please, try it again:");
                }
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.err.println("Ops! seems that you insert a non valid value. Please, try it again:");
            }
        }


        //Selector for Name
        optionSelected = false;
        while (optionSelected == false) {
            System.out.println("Write a name for the character");
            try {
                characterName = scanner.next();
                scanner.nextLine();
                optionSelected = true;
            } catch (InputMismatchException ime) {
                scanner.nextLine();
                System.err.println("Ops! seems that you insert a non valid value. Please, try it again:");
            }
        }

        boolean statsOk = false;

        while(statsOk == false){
            //Selector for HP
            optionSelected = false;
            int [] hpMinMax = {0,0};
            if(characterClass == 1){
                hpMinMax = Warrior.getHP_RANGE();
            }else{
                hpMinMax = Wizard.getHP_RANGE();
            }
            System.out.println("Set a value for HP between "+hpMinMax[0] +" and "+ hpMinMax[1]+" for the character:");
            while (optionSelected == false) {
                try {
                    characterHp = scanner.nextInt();
                    scanner.nextLine();
                    optionSelected = true;
                } catch (InputMismatchException ime) {
                    scanner.nextLine();
                    System.err.println("Ops! seems that you insert a non valid value. Please, try it again:");
                }
            }


            //Selector for parameter 1
            optionSelected = false;
            String parameter1;
            int [] parameter1Range = {0,0};
            if(characterClass == 1){
                parameter1Range = Warrior.getSTAMINA_RANGE();
                parameter1 = "stamina";
            }else{
                parameter1Range = Wizard.getMANA_RANGE();
                parameter1 =  "mana";
            }
            System.out.println("Set a value for "+parameter1+" between "+parameter1Range[0] +" and "+ parameter1Range[1]+" for the character:");
            while (optionSelected == false) {
                try {
                    characterParameter1 = scanner.nextInt();
                    scanner.nextLine();
                    optionSelected = true;
                } catch (InputMismatchException ime) {
                    scanner.nextLine();
                    System.err.println("Ops! seems that you insert a non valid value. Please, try it again:");
                }
            }


            //Selector for parameter 2
            optionSelected = false;
            String parameter2;
            int [] parameter2Range = {0,0};
            if(characterClass == 1){
                parameter2Range = Warrior.getSTRENGTH_RANGE();
                parameter2 = "strength";
            }else{
                parameter2Range = Wizard.getINTELLIGENCE_RANGE();
                parameter2 =  "intelligence";
            }
            System.out.println("Set a value for "+parameter2+" between "+parameter2Range[0] +" and "+ parameter2Range[1]+" for the character:");
            while (optionSelected == false) {
                try {
                    characterParameter2 = scanner.nextInt();
                    optionSelected = true;
                    scanner.nextLine();
                } catch (InputMismatchException ime) {
                    scanner.nextLine();
                    System.err.println("Ops! seems that you insert a non valid value. Please, try it again:");
                }
            }

            if(characterClass == 1){
                if(Warrior.validateInput(characterHp,characterParameter1,characterParameter2)){
                    statsOk = true;
                }else{
                    System.err.println("Please, try it again");
                }
            }else{
                if(Wizard.validateInput(characterHp,characterParameter1,characterParameter2)){
                    statsOk = true;
                }else{
                    System.err.println("Please, try it again");
                }
            }
        }

        //Creation of the character
        if (characterClass == 1) {
            character = new Warrior(characterName, characterHp, characterParameter1, characterParameter2);
        } else {
            character = new Wizard(characterName, characterHp, characterParameter1, characterParameter2);
        }
        return character;
    }
}
