import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import characters.Warrior;
import characters.Wizard;
import services.BattleSimulator;
import services.Creating1v1;
import services.CreatingBattleGround;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {

        List<characters.Character> characters;
        String choise;

        System.out.println("--- WELCOME TO IRONBATTLE ---");
        System.out.println("PLEASE SELECT WHAT DO YOU WANT");
        System.out.println("TYPE 'W' IF YOU WANT WATCH BATTLEGROUND, 'Q' IF YOU WANT 1V1");
        
        do {
            choise = sc.next();
        } while(!choise.equals("Q") && !choise.equals("W") && !choise.equals("q") && !choise.equals("w"));


        
        if(choise.equals("w")|| choise.equals("W")){
            characters = CreatingBattleGround.addCharactersToBattleGround();
        }
        else{
            characters = Creating1v1.prepareCharacters();
        }
        
        // System.out.println("\n---GAME STARTS---\n");

        new BattleSimulator().startTheGame(characters); //en boyuk listi verir
            
            
        // }
        
    }

    


}