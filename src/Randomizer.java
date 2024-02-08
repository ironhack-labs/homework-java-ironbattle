import java.util.Random;

public class Randomizer {
    // Attributes
    private static final Random RAND = new Random();

    // Static Methods
    public static int getRandomInt(int min, int max) {
        return (RAND.nextInt(max - min + 1) + min);
    }
}
