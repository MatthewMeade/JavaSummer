import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Class used to demonstrate object deserialization
 */
public class DeserializeShape {
    public static void main(String[] args) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("files/serializedObjects/shape.ser"));

            Shape shape = (Shape) input.readObject();

            System.out.println("Deserialized object description: " + shape.getDescription());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
