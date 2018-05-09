/**
 * Created by 20136520 on 5/9/2018.
 */

import java.util.Random;

public class ShapeGenerator{

    private static final int MAX_RADIUS = 100;
    private static final int MAX_WIDTH = 100;
    private static final int MAX_LENGTH = 100;
    /**
     * Generate a random shape of a random size
     * @return Shape random shape
     */
    public static Shape GenerateShape(){
        Random random = new Random();

        if (random.nextBoolean()){
            return new Circle(random.nextInt(MAX_RADIUS));
        } else {
            return new Rectangle(random.nextInt(MAX_LENGTH), random.nextInt(MAX_WIDTH));
        }
    }
}
