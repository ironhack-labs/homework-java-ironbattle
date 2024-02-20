import java.util.List;

public class Main {

    public static void main(String[] args){

        StartGame start = new StartGame();
        List<Character> players = start.setUp();
        Character Player1 = players.get(0);
        Character Player2 = players.get(1);

        Battle battle = new Battle();
        battle.startBattle(Player1, Player2);

        battle.battlePrinter(battle.getBattleRecord(), 333);

    }

}
