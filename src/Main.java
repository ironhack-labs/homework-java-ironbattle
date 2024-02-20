import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        StartGame start = new StartGame();
        List<Character> players = start.setUp();
        Character Player1 = players.get(0);
        Character Player2 = players.get(1);

        Battle battle = new Battle(Player1, Player2);
        battle.startBattle(Player1, Player2);

        battle.battlePrinter(battle.getBattleRecord(), 333);

    }

}
