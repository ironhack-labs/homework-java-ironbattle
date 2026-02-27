package services;

import java.io.FileWriter;
import java.io.IOException;

public class BattleLog {

    private static final String FILE_NAME = "battleLogs.txt";

    // Fayla yazma helper metodu
    private static void writeToFile(String text) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBattleAction(characters.Character attacker, characters.Character defender) {
        String log =
                ">>> " + attacker.getName() + " attacked " + defender.getName() + "\n" +
                ">>> " + defender.getName() + "'s health is: " + defender.getHp() + "\n";

        writeToFile(log);
        System.out.print(log);
    }

    public static void writeRound(int round) {
        String log = "\n---ROUND " + round + "---\n";
        writeToFile(log);
        System.out.print(log);
    }

    public static void writeBattleResult(characters.Character winner, characters.Character loser) {
        String log =
                ">>> " + winner.getName() + " wins!\n" +
                loser.getName() + " has been defeated!\n";

        writeToFile(log);
        System.out.print(log);
    }

    public static void writeBattleResultTie() {
        String log = "It's a tie!\nMatch starts again!\n";

        writeToFile(log);
        System.out.print(log);
    }
}