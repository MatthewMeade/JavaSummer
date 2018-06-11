import java.io.Serializable;

/**
 * Abstract class representing a shape
 */
public abstract class Shape implements Serializable{

    /**
     * Returns the area of the shape
     *
     * @return double area of the shape
     */
    public abstract double area();

    /**
     * Returns the description of the shape
     *
     * @return String description of the shape
     */
    public abstract String getDescription();
}
