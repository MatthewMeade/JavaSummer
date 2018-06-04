/**
 * Class representing a Rectangle, extends Shape
 */
public class Rectangle extends Shape {
    private double length;
    private double width;

    /**
     * Rectangle Constructor
     *
     * @param length Length of rectangle
     * @param width  Width of rectangle
     */
    public Rectangle(double length, double width) throws InvalidShapeParameterException{
        setLength(length);
        setWidth(width);
    }

    /**
     * Returns the length of the rectangle
     *
     * @return double Length of rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangle
     *
     * @param length Length of the rectangle
     */
    public void setLength(double length) throws InvalidShapeParameterException{
        if (length < 0){
            throw new InvalidShapeParameterException("Invalid Rectangle Length");
        }
        this.length = length;
    }

    /**
     * Returns the width of the rectangle
     *
     * @return double Width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle
     *
     * @param width double width of the rectangle
     */
    public void setWidth(double width) throws InvalidShapeParameterException{
        if (width < 0) {
            throw new InvalidShapeParameterException("Invalid Rectangle Width");
        }
    }

    /**
     * Returns the area of the rectangle
     *
     * @return double area of the rectangle
     */
    @Override
    public double area() {
        return this.getLength() * this.getWidth();
    }

    /**
     * Returns the description of the rectangle
     *
     * @return String description of the rectangle
     */
    @Override
    public String getDescription() {
        return String.format("Rectangle with a length of %.2f, a width of %.2f, and an area of %.2f", this.getLength(), this.getWidth(), this.area());
    }
}
