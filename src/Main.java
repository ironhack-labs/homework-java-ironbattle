import java.util.List;

public class Main {

    public static void main(String[] args){


        StartGame start = new StartGame();
        List<Character> players = start.setUp();
        Character player1 = players.get(0);
        Character player2 = players.get(1);

        Battle battle = new Battle();
        battle.startBattle(player1, player2);

        battle.battlePrinter(battle.getBattleRecord(), 700);

    }

}
