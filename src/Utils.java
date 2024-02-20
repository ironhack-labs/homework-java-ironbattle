import java.util.Random;

public class Utils {
    static Random random = new Random();

    public static int generateRandomNumber(){
        return random.nextInt(2);
    }

    //Overload
    public static int generateRandomNumber(int min, int max){
        if(max < min)
            throw new IllegalArgumentException("The maximum value for this method cannot be smaller than the declared minimum.");
        return random.nextInt(max - min + 1) + min;
    }
}
