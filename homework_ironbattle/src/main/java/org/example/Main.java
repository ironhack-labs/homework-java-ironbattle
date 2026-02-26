package org.example;
public class Main {
  public static void main(String[] args){
      Warrior warrior=new Warrior("Shebnem");
      Wizard wizard=new Wizard("Mehemmed");
      System.out.println("--- Battle Setup ---");
      System.out.println(warrior.getName() + " (Warrior) HP: " + warrior.getHp());
      System.out.println(wizard.getName() + " (Wizard) HP: " + wizard.getHp());
      System.out.println("--------------------\n");

      while(warrior.getHp()>0 && wizard.getHp()>0){
          warrior.attack(wizard);
          if (wizard.getHp() <= 0) {
              break;
          }
          wizard.attack(warrior);
          System.out.println("----------");
      }
      System.out.println("\n*** THE BATTLE IS OVER ***");
      if(warrior.getHp()<=0 && wizard.getHp()<=0){
          System.out.println("It's a draw! Both heroes fell in glory.");
      }
      else if(warrior.getHp()<=0 ){
          System.out.println("Winner is "+wizard.getName() + "!");
      }
      else{
          System.out.println("Winner is "+warrior.getName() + "!");
      }

  }

}