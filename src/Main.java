import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)throws IOException{
        characterSelector();
        //Temporary creation of characters, can be deleted
        Character char1 = new Warrior("guerrero",180,12,2);
        Character char2  = new Wizard("wizard",100,12,2);
        //Call for the method that will do the combat
        //combat(char1,char2);
    }

    public static void characterSelector(){
        Scanner scanner = new Scanner(System.in);
        boolean optionSelected = false;
        System.out.println("Bienvenid@ al IronBattle! programado por el grupo CodeCrafters: Heroes of the Binary Realms. \n" +
                "Estás apunto de embarcarte en un emocionante combate entre dos peleadores que darán su vida para declararse el vencedor.\n" +
                "A continuación, seleccionar entre una de las siguientes opciones: ");

        while(optionSelected==false){
            System.out.println("1. Creador manual de personajes.\n2. Creador aleatorio de personajes \n3. Importación de personajes (formato CSV)");
            int option = 0;
            try{
                option = scanner.nextInt();
            }
            catch(InputMismatchException ime){
                option = 0;
                scanner.nextLine();
            }
            switch (option) {
                case 1:
                    //TODO Llamada al creador manual de personajes
                    manualCharacterCreator(scanner);
                    System.out.print("mec");
                    optionSelected = true;
                    break;
                case 2:
                    //TODO Llamada al creador aleatorio de personajes
                    System.out.print("moc");
                    optionSelected = true;
                    break;
                case 3:
                    //TODO Llamada al importador de CSV
                    System.out.print("mic");
                    optionSelected = true;
                    break;
                default:
                    System.out.println("Vaya! parece que has seleccionado una opción que no está disponible. \nPor favor, vuelve a seleccionar una opción válida escribiendo el número que hay al princpio de la opción deseada:");
            }
        }
    }


    public static void manualCharacterCreator(Scanner scanner){
    }


    public static void combat(Character char1, Character char2){
        boolean finished = false;
        Character initChar1 = char1.clone();
        Character initChar2 = char2.clone();

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive()&&char2.isAlive()){
                char1.attack(char2);
                char2.attack(char1);
                if (char1.getHp() <= 0) {
                    char1.setAlive(false);
                }
                if (char2.getHp() <= 0) {
                    char2.setAlive(false);
                }
            }

            //Once the battle is finished, let's check who wins the battle
            if (!char2.isAlive()&&!char1.isAlive()){
                //The battle result is a tie
                System.out.println("The battle results in a tie! The battle will be repeated");
                char1=initChar1.clone();
                char2=initChar2.clone();

            }else if (!char2.isAlive()){
                //Character 2 wins the battle
                System.out.println("The player "+char1.getName()+" wins the battle!");
                finished = true;
            }else if(!char1.isAlive()){
                //Character 1 wins the battle
                System.out.println("The player "+char2.getName()+" wins the battle!");
                finished = true;
            }
        }
    }
}
