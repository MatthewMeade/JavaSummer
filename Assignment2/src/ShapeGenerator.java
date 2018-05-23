import java.util.Random;

/**
 * Class used to generate random shapes
 */
public class ShapeGenerator{

    private static final int MAX_RADIUS = 25;
    private static final int MAX_WIDTH = 50;
    private static final int MAX_LENGTH = 50;

    /**
     * Generate a random shape of a random size
     * @return Shape random shape
     */
    public static Shape GenerateShape(){
        if (new Random().nextBoolean()){
            return new Circle(GenerateNumber(MAX_RADIUS));
        } else {
            return new Rectangle(GenerateNumber(MAX_LENGTH), GenerateNumber(MAX_WIDTH));
        }
    }

    /**
     * Returns a random double between 0 and max
     * @param max int Maximum number that can be generates
     * @return double Randomly generated double
     */
    private static double GenerateNumber(int max){
        Random random = new Random();
        return random.nextInt(max - 1) + random.nextDouble();
    }
}
