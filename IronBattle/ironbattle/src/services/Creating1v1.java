package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import characters.*;
import characters.Character;
//everywhere in project i wrote as characters.Character 
// to remember and don't make that mistake again
// Even a donkey falls into mud once

public class Creating1v1 {

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    static List<characters.Character> characters = new ArrayList<>();

    public static List<characters.Character> prepareCharacters(){


        System.out.println("\n---GAME PREPARATION---\n");

        System.out.println("PLAYER 1 SELECT YOUR CHARACTER\n");

        boolean p1Character = selectCharacter();
        System.out.println("Write your name: ");
        String p1Name = sc.next();



        System.out.println("PLAYER 2 SELECT YOUR CHARACTER");

        boolean p2Character = selectCharacter();
        System.out.print("Write your name: ");
        String p2Name = sc.next();


        characters.add(createPlayer(p1Character, p1Name));
        characters.add(createPlayer(p2Character, p2Name));

        return characters;

    }

    private static boolean selectCharacter(){

        System.out.println("press 1 if 'WARRIOR', press 0 if 'WIZARD'");
        
        while(true){
            
            int eded = sc.nextInt();

            if(eded == 1){
                return true;
            }
            if(eded == 0){
                return false;
            }
            else{
                System.out.println("PLEASE ENTER 1 OR 0 !!!");
                sc.nextInt();
            }

        }
    }

       private static characters.Character createPlayer(boolean character, String name){
        if(character == true){
            System.out.println("Creating WARRIOR for "+name+"...");
            return Warrior.createWarrior(name);}
        else{
            System.out.println("Creating WIZARD for "+name+"...");
            return Wizard.createWizard(name);}

    }

}
