package com.example;

import java.util.Random;

import static com.example.BattleSimulator.duel;

public class Main {
   public static void main(String[] args){
      try{
          Random random=new Random();
          Warrior warrior = new Warrior(
                  "Knight",
                  150 + random.nextInt(51),
                  20 + random.nextInt(31),
                  5 + random.nextInt(6)
          );

          Wizard wizard = new Wizard(
                  "Saruman",
                  80 + random.nextInt(41),
                  15 + random.nextInt(21),
                  8 + random.nextInt(16)
          );

          duel(warrior,wizard);
      }
      catch (IllegalArgumentException e) {
          System.out.println("Invalid number: " + e.getMessage());
      }
      finally {
          System.out.println("Code was executed");
      }
   }
}
