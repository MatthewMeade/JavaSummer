import java.util.Random;

/**
 * Class used to generate random shapes
 */
public class ShapeGenerator {

    private static final int MAX_RADIUS = 25;
    private static final int MAX_WIDTH = 50;
    private static final int MAX_LENGTH = 50;
    private static final double NEGATIVE_CHANCE = 0.25;

    /**
     * Generate a random shape of a random size
     *
     * @return Shape random shape
     */
    public static Shape GenerateShape() {

        Shape shape = null;
        do {
            try {
                if (new Random().nextBoolean()) {
                    shape = new Circle(GenerateNumber(MAX_RADIUS));
                } else {
                    shape = new Rectangle(GenerateNumber(MAX_LENGTH), GenerateNumber(MAX_WIDTH));
                }
            } catch (InvalidShapeParameterException e) {
                System.out.println("Exception thrown when generating shape: (" + e.getMessage() + ") Retying shape generation");
            }
        } while (shape == null);

        return shape;
    }

    /**
     * Returns a random double between 0 and max
     *
     * @param max int Maximum number that can be generates
     * @return double Randomly generated double
     */
    private static double GenerateNumber(int max) {
        Random random = new Random();
        return (random.nextDouble() < NEGATIVE_CHANCE ? -1 : 1) * random.nextInt(max - 1) + random.nextDouble();
    }
}
