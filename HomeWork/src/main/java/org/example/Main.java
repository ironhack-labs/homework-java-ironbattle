package org.example;



public class Main {
    static void main() {
        Warrior warrior = new Warrior("Thor", 150, 30, 8);
        Wizard wizard = new Wizard("Merlin", 80, 40, 25);

        int round=1;
        while(warrior.getIsAlive() && wizard.getIsAlive()){
            System.out.println("-----Round "+round+"------");

            warrior.attack(wizard);
            wizard.attack(warrior);

            System.out.println(warrior.getName()+"Hp:"+warrior.getHp());
            System.out.println(wizard.getName()+"Hp:"+wizard.getHp());
            round++;

        }
        System.out.println("\n --------Battle Over-------- ");
        if(warrior.getIsAlive() && !wizard.getIsAlive()){
            System.out.println("-------Winner:"+warrior.getName()+"-------");
        }
        else if(wizard.getIsAlive() && !warrior.getIsAlive()){
            System.out.println("-------Winner:"+wizard.getName()+"-------");
        }
        else{
            System.out.println("It is a tie! Restarting again....... ");
        }
    }
}
