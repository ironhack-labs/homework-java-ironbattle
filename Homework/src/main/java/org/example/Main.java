package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner=new Scanner(System.in);
        Warrior warrior=new Warrior(scanner.next(),scanner.next(),scanner.nextInt(),scanner.nextBoolean());
        Wizard wizard=new Wizard(scanner.next(),scanner.next(),scanner.nextInt(),scanner.nextBoolean());
        System.out.println("Battle stars");
        System.out.println("Warrior's name: "+warrior.getName()+", Strength: "+warrior.getStrength()+", Stamina: "+warrior.getStamina());
        System.out.println("Wizard's name: "+wizard.getName()+", Intelligence: "+wizard.getIntelligence()+", Mana: "+wizard.getMana());
        System.out.println(battle(warrior,wizard));
    }
    public static String battle(Character character1,Character character2){
        final int firstCharacterHp=character1.getHp();
        final int secondCharacterHp=character2.getHp();
        while(character1.getHp()>0&&character2.getHp()>0){
            character1.attack(character2);
            character2.attack(character1);
        }
        if(character1.getHp()==0&&character2.getHp()==0){
            character1.setHp(firstCharacterHp);
            character2.setHp(secondCharacterHp);
            System.out.println("It's a tie\nBattle restarts");
            battle(character1,character2);
        }
        else if(character2.getHp()==0){
            return character1.getName()+" wins battle";
        }
        return character2.getName()+" wins battle";
    }
}
