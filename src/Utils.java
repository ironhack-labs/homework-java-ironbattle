import java.util.concurrent.ThreadLocalRandom;
public class Utils {
     // Generates a random integer within a specified range.
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    // Other utility methods to be added here
}
