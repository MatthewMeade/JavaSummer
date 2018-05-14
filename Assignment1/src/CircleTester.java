/**
 * Class used to test the Circle Class
 */
public class CircleTester {

    /**
     * Executes all Circle tests
     *
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("Testing the Circle Class");

        testGetterSetter();
        testAreaCalc();
    }

    /**
     * Generates a circle and tests the get and set functionality
     */
    public static void testGetterSetter() {
        Circle circle = new Circle(1.0);

        System.out.println("Radius Test " + (circle.getRadius() == 1.0 ? "Passed" : "Failed"));

        circle.setRadius(2.2);

        System.out.println("Radius Test " + (circle.getRadius() == 2.2 ? "Passed" : "Failed"));
    }

    /**
     * Generates a circle and tests the area calculation functionality
     */
    public static void testAreaCalc() {
        Circle circle = new Circle(1.0);
        System.out.println("Area Test " + (circle.area() == Math.PI ? "Passed" : "Failed"));

        circle.setRadius(Math.PI);
        System.out.println("Area Test " + (circle.area() == Math.pow(Math.PI, 3) ? "Passed" : "Failed"));
    }
}
