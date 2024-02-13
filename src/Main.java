import java.util.Scanner;

public class Main {


    public static void main(String[] args){
      //  Warrior war1 = new Warrior("Aragorn", 100);
     //   Warrior war2 = new Warrior("Boromir", 50);
  
        StartGame start = new StartGame();
        start.setUp();

        Battle battle = new Battle(war1, war2);

        for (String s: battle.getBattleRecord()){
            System.out.println(s);
            waitingTime();
        }

    }

    private static void waitingTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      
    }

}
