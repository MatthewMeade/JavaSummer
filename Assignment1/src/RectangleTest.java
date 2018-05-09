/**
 * Created by 20136520 on 5/9/2018.
 */
public class RectangleTest {
    public static void main(String[] args){
        System.out.println("Testing the Rectangle Class");

        testGetterSetter();
        testAreaCalc();
    }

    public static void testGetterSetter(){
        Circle circle = new Circle(1.0);

        System.out.println("Radius Test " + (circle.getRadius() == 1.0 ? "Passed" : "Failed"));

        circle.setRadius(2.2);

        System.out.println("Radius Test " + (circle.getRadius() == 2.2 ? "Passed" : "Failed"));
    }

    public static void testAreaCalc(){
        Circle circle = new Circle(1.0);
        System.out.println("Area Test " + (circle.area() == Math.PI ? "Passed" : "Failed"));

        circle.setRadius(Math.PI);
        System.out.println("Area Test " + (circle.area() == Math.pow(Math.PI, 3) ? "Passed" : "Failed"));
    }
}
