package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Character StartBattle(Attacker a, Attacker b){
        Character winner = null;
        Character aChar = (Character) a;
        Character bChar = (Character) b;
        int originalHpA = aChar.getHp();
        int originalHpB = bChar.getHp();
        boolean fighting = true;
        while (fighting) {
            a.attack(aChar);
            b.attack(bChar);
            if(!aChar.isAlive() && !bChar.isAlive()){
                aChar.setAlive(true);
                aChar.setHp(originalHpA);
                bChar.setAlive(true);
                bChar.setHp(originalHpB);
                System.out.println("Ambos personajes han muerto, se reinicia la batalla hasta encontrar un ganador");
                continue;
            }else{
                if(!aChar.isAlive()){
                    winner = bChar;
                    fighting = false;
                }else if(!bChar.isAlive()){
                    winner = aChar;
                    fighting = false;
                }
            }
        }

        return winner;
    }

    public static void main(String[] args) {

        // hacer batalla
        // salir
        boolean executing = true;
        boolean validOption = false;
        var scanner = new Scanner(System.in);


        System.out.println("Bienvenido a Iron Battle. Elige una opción : \n");
        while(executing){

            System.out.println("1 - Batalla");
            System.out.println("2 - Salir");

            switch(scanner.nextInt()){
                case 1 :
                    while(!validOption) {


                        System.out.println("1 - Crear personajes manualmente");
                        System.out.println("2 - Crear personajes aleatoriamente");
                        System.out.println("3 - Importar personajes desde CSV");

                        switch (scanner.nextInt()) {
                            case 1:
                                Attacker a = null;
                                Attacker b = null;

                                while(!validOption){
                                    System.out.println("Añade al primer combatiente\n");
                                    //switch para elegir entre Guerrero y Mago
                                    System.out.println("1 - Guerrero");
                                    System.out.println("2 - Mago");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            System.out.println("Introduce el nombre del Guerrero");
                                            String name = scanner.next();
                                            System.out.println("Introduce la vida del Guerrero");
                                            int hp = scanner.nextInt();
                                            System.out.println("Introduce la stamina del Guerrero");
                                            int stamina = scanner.nextInt();
                                            System.out.println("Introduce la fuerza del Guerrero");
                                            int strength = scanner.nextInt();
                                            a = new Warrior(name, hp, stamina, strength);
                                            validOption = true;
                                            break;
                                        case 2:
                                            System.out.println("Introduce el nombre del Mago");
                                            String name2 = scanner.next();
                                            System.out.println("Introduce la vida del Mago");
                                            int hp2 = scanner.nextInt();
                                            System.out.println("Introduce el mana del Mago");
                                            int mana = scanner.nextInt();
                                            System.out.println("Introduce la inteligencia del Mago");
                                            int intelligence = scanner.nextInt();
                                            a = new Wizard(name2, hp2, mana, intelligence);
                                            validOption = true;
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                }

                                validOption = false;

                                while(!validOption) {
                                    System.out.println("Añade al segundo combatiente\n");
                                    //switch para elegir entre Guerrero y Mago
                                    System.out.println("1 - Guerrero");
                                    System.out.println("2 - Mago");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            System.out.println("Introduce el nombre del Guerrero");
                                            String name3 = scanner.next();
                                            System.out.println("Introduce la vida del Guerrero");
                                            int hp3 = scanner.nextInt();
                                            System.out.println("Introduce la stamina del Guerrero");
                                            int stamina2 = scanner.nextInt();
                                            System.out.println("Introduce la fuerza del Guerrero");
                                            int strength2 = scanner.nextInt();
                                            b = new Warrior(name3, hp3, stamina2, strength2);
                                            validOption = true;
                                            break;
                                        case 2:
                                            System.out.println("Introduce el nombre del Mago");
                                            String name4 = scanner.next();
                                            System.out.println("Introduce la vida del Mago");
                                            int hp4 = scanner.nextInt();
                                            System.out.println("Introduce el mana del Mago");
                                            int mana2 = scanner.nextInt();
                                            System.out.println("Introduce la inteligencia del Mago");
                                            int intelligence2 = scanner.nextInt();
                                            b = new Wizard(name4, hp4, mana2, intelligence2);
                                            validOption = true;
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                }

                                Character winner = StartBattle(a,b);
                                System.out.println("El ganador es: " + winner.getName());
                                break;
                            case 2:
                                validOption = true;
                                break;
                            case 3:
                                validOption = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                validOption = false;
                                break;
                        }
                    }
                    validOption = false;
                    break;
                case 2 :
                    executing = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}