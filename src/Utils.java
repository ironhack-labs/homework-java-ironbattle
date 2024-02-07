import java.util.Random;
public class Utils {
    // Generates a random integer within a specified range.
    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    // Other utility methods to be added here


}
