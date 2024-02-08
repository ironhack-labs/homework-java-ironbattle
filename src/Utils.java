import java.util.Random;
public class Utils {
    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + min;
    }
    // Other utility methods to be added here
}




