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

        try {
            Circle circle = new Circle(-1.0);

            System.out.println("Radius Test " + (circle.getRadius() == 1.0 ? "Passed" : "Failed"));

            circle.setRadius(2.2);

            System.out.println("Radius Test " + (circle.getRadius() == 2.2 ? "Passed" : "Failed"));
        } catch (InvalidShapeParameterException e) {
            System.out.println("Radius Test failed, unexpected exception. " + e);
        }

        try {
            new Circle(-1);
            System.out.println("Test failed! Circle constructor did not throw an exception given an invalid radius");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test passed! Circle constructor threw an exception when given an invalid radius");
        }

        try {
            new Circle(5).setRadius(-5);
            System.out.println("Test failed! Circle's set method did not throw an exception given an invalid radius");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test passed! Circle's set method threw an exception when given an invalid radius");
        }
    }

    /**
     * Generates a circle and tests the area calculation functionality
     */
    public static void testAreaCalc() {
        try {
            Circle circle = new Circle(1.0);
            System.out.println("Area Test " + (circle.area() == Math.PI ? "Passed" : "Failed"));

            circle.setRadius(Math.PI);
            System.out.println("Area Test " + (circle.area() == Math.pow(Math.PI, 3) ? "Passed" : "Failed"));
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test failed! Circle threw exception when given valid parameters");
        }
    }
}
