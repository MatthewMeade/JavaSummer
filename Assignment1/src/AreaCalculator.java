/**
 * Created by 20136520 on 5/9/2018.
 */
public class AreaCalculator {
    public static void main(String[] args){

        Shape[] shapes = new Shape[5];
        for (int i = 0; i < shapes.length; i++){
            shapes[i] = ShapeGenerator.GenerateShape();
        }

        for (int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i].getDescription() + ". Area: " + shapes[i].area());
        }
    }
}
