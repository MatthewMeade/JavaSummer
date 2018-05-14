/**
 * Class that generates and prints shapes
 */
public class AreaCalculator {
    /**
     * Generate 5 random shapes and print their descriptions
     * @param args none
     */
    public static void main(String[] args) {

        Shape[] shapes = new Shape[5];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = ShapeGenerator.GenerateShape();
            System.out.println(shapes[i].getDescription());
        }
    }
}
