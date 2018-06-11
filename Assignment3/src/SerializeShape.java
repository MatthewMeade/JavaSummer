import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class used to demonstrate object serialization
 */
public class SerializeShape {
    public static void main (String[] args) {
        Shape shape = ShapeGenerator.GenerateShape();
        System.out.println("Generated Shape Description: " + shape.getDescription());

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("files/serializedObjects/shape.ser"));
            output.writeObject(shape);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
