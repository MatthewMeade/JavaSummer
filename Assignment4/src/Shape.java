import java.io.Serializable;

/**
 * Abstract class representing a shape
 */
public abstract class Shape implements Serializable, Comparable<Shape> {

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

    /**
     * Compares the area of two shapes
     * @param s Shape to compare to
     * @return int Positive int if greater, negative in if lesser, 0 if equal
     */
    @Override
    public int compareTo(Shape s) {
        return Double.compare(area(), s.area());
    }
}
