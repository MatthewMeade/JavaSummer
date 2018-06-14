import java.util.*;

/**
 * Class used to demonstrate collections
 */
public class ShapeProgram {

    private static final int NUM_SHAPES = 15;

    /**
     * Generates a random ArrayList of shapes then prints and sorts them
     * @param args none
     */
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<Shape>();

        for (int i = 0; i < NUM_SHAPES; i++) {
            shapes.add(ShapeGenerator.GenerateShape());
        }

        System.out.println("Generated List of Shapes:");
        printCollection(shapes);

        System.out.println("\nSorted List of Shapes:");
        sortShapeList(shapes);
        printCollection(shapes);

    }

    /**
     * Prints a given collection to std out
     * @param collection List collection to print
     */
    public static void printCollection(List collection) {
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            Shape shape = (Shape) iterator.next();
            System.out.println(shape.getDescription());
        }
    }

    /**
     * Sorts a given collection of shapes by area
     * @param collection List list of shapes to sort
     */
    public static void sortShapeList(List collection) {

        for (int i = 0; i < collection.size(); i++) {

            ListIterator iterator = collection.listIterator();
            Shape s1 = (Shape) iterator.next();
            Shape s2 = (Shape) iterator.next();

            for (int j = 0; j < collection.size(); j++) {
                if (s1.compareTo(s2) > 0) {
                    iterator.remove();
                    iterator.previous();
                    iterator.add(s2);
                    iterator.next();
                }

                if (iterator.hasNext()) {
                    s1 = s2;
                    s2 = (Shape) iterator.next();
                } else {
                    break;
                }


            }
        }


    }
}
