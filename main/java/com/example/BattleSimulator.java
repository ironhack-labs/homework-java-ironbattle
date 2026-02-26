package com.example;

import java.util.Random;

public class BattleSimulator {
  public static void duel(Character c1,Character c2){
      System.out.println("Duel Started - Player one: "
              + c1.getName()
              + " | Player two: "
              + c2.getName());
      int round = 1;
      boolean WinnerFound=false;

      while (c1.isAlive() && c2.isAlive()) {
          System.out.println("Round " + round + ":");


          if (c1 instanceof Attacker) ((Attacker)c1).Attack(c2);
          if (c2 instanceof Attacker) ((Attacker)c2).Attack(c1);

          System.out.println(c1.getName() + " HP: " + c1.getHp());
          System.out.println(c2.getName() + " HP: " + c2.getHp());
          System.out.println("-------------------\n");

          round++;


      }
      if (c1.isAlive() && !c2.isAlive()) {
          System.out.println(c1.getName() + " WINS!");
          WinnerFound=true;
      } else if (!c1.isAlive() && c2.isAlive()) {
          System.out.println(c2.getName() + " WINS!");
          WinnerFound=true;
      } else {
          System.out.println("It's a TIE! Restarting battle...");
          c1.setHp(100 + new Random().nextInt(101));
          c1.setAlive(true);
          c2.setHp(100 + new Random().nextInt(101));
          c2.setAlive(true);

      }


  }

}
