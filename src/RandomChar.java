import java.util.Random;

public class RandomChar {

    public static Character createRandomChar() {
        return CharacterClass.WIZARD == randomCharType() ? new Wizard() : new Warrior();
    }

    public static CharacterClass randomCharType() {
        Random random = new Random();
        int faceDice = random.nextInt(6) + 1;

        return faceDice%2 == 0 ? CharacterClass.WIZARD : CharacterClass.WARRIOR;
    }
}
