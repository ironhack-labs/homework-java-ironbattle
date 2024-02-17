import java.util.List;
import java.util.Scanner;

/**
 * TODO: @Katia
 * P1 y P2 revisar copia clonar!
 *
 * TODO: @Diego
 * Imprimir en bloque el round:
 *
 * 1era vez:
 * Round 1 start:
 * Accion player 1:
 * Accion player 2:
 * Espero
 * -----
 * 2 vez que imprimo
 * Round 2 start:
 * Accion player 1:
 * Accion player 2:
 *
 * TODO: @Diego
 * Revisar numeración de round (probar si funciona realmente el setRound(1))
 *
 * TODO: @David y @Diego
 *
 * Revisar formato output del recorder para ser mas friendly
 *
 * TODO: @Ana
 * comentar o borrar println de atack de wizard y warrior
 *
 * TODO: @Ana
 * Readme
 *
 */

public class Main {

    public static void main(String[] args){

        StartGame start = new StartGame();
        List<Character> players = start.setUp();
        Character Player1 = players.get(0);
        Character Player2 = players.get(1);

        Battle battle = new Battle(Player1, Player2);
        battle.startBattle(Player1, Player2);

        battle.battlePrinter(battle.getBattleRecord(), 1);

    }

}
