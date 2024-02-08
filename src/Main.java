import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Ironbattle!");
        //luego se puede añadir otra opción de selección automática de personajes y dar dos modos a elegir al usuario
        System.out.println("Player1, choose your character: 1-Warrior , 2-Wizard");
        Scanner scanner = new Scanner(System.in);
        //pedir al usuario elegir los personajes de cada jugador y ponerles nombre
        //simplificar ifs muy feos
        String player1 = scanner.nextLine();
        Character Player1 = null;
        Character Player2 = null;
        if (player1 == "1") {
            System.out.println("Player1, choose a name for your Warrior");
            String name = scanner.nextLine();
            Player1 = new Warrior(name);

        } else {
            System.out.println("Player1, choose a name for your Wizard");
            String name = scanner.nextLine();
            Player1 = new Wizard(name);
        }
        System.out.println("Player2, choose your character: 1-Warrior , 2-Wizard");
        String player2 = scanner.nextLine();
        if (player2 == "1") {
            System.out.println("Player2, choose a name for your Warrior");
            String name = scanner.nextLine();
            Player2 = new Warrior(name);

        } else {
            System.out.println("Player2, choose a name for your Wizard");
            String name = scanner.nextLine();
            Player2 = new Wizard(name);
        }
        //se han creado las dos instancias de los jugadores
        System.out.println("Player1: " + Player1.getName() + " has XX health points...");
        System.out.println("Player2: " + Player2.getName()+ " has XX health points...");


    }
}
