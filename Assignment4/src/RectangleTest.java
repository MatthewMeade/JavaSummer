/**
 * Class used to test the Rectangle class
 */
public class RectangleTest {

    /**
     * Executes all Rectangle tests
     *
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("Testing the Rectangle Class");

        testGetterSetter();
        testAreaCalc();
    }

    /**
     * Generates a rectangle and tests get and set functionality
     */
    public static void testGetterSetter() {

        try {
            Rectangle rectangle = new Rectangle(5, 10);

            System.out.println("Get Length Test " + (rectangle.getLength() == 5.0 ? "Passed" : "Failed"));
            System.out.println("Get Width Test " + (rectangle.getWidth() == 10.0 ? "Passed" : "Failed"));

            rectangle.setLength(6);
            rectangle.setWidth(6.5);

            System.out.println("Set Length Test " + (rectangle.getLength() == 6.0 ? "Passed" : "Failed"));
            System.out.println("Set Width Test " + (rectangle.getWidth() == 6.5 ? "Passed" : "Failed"));
        } catch (InvalidShapeParameterException ex) {
            System.out.println("Rectangle test failed when given valid parameters:\n\t" + ex);
        }

        try {
            new Rectangle(-5, 10);
            System.out.println("Test failed! Rectangle constructor did not throw exception when given invalid length");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test Passed! Rectangle constructor threw exception when given invalid length");
        }

        try {
            new Rectangle(5, -10);
            System.out.println("Test failed! Rectangle constructor did not throw exception when given invalid width");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test Passed! Rectangle constructor threw exception when given invalid width");
        }

        try {
            new Rectangle(5, 10).setLength(-5);
            System.out.println("Test failed! Rectangle setLength did not throw exception when given invalid length");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test Passed! Rectangle setLength threw exception when given invalid length");
        }

        try {
            new Rectangle(5, 10).setWidth(-10);
            System.out.println("Test failed! Rectangle setWidth did not throw exception when given invalid width");
        } catch (InvalidShapeParameterException e) {
            System.out.println("Test Passed! Rectangle setWidth threw exception when given invalid width");
        }
    }

    /**
     * Generates a rectangle and tests the area calculation functionality
     */
    public static void testAreaCalc() {

        try {
            Rectangle rectangle = new Rectangle(5, 5);
            System.out.println("Area Test 1 " + (rectangle.area() == 25.0 ? "Passed" : "Failed"));

            rectangle.setLength(10);
            System.out.println("Area Test 2 " + (rectangle.area() == 50 ? "Passed" : "Failed"));
        } catch (InvalidShapeParameterException e) {
            System.out.println("Rectangle area test failed, threw an exception when given valid parameters:" + e);
        }
    }
}
