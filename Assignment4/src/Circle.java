/**
 * Class representing a circle, extending Shape
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Circle Constructor
     *
     * @param radius double Radius of the circle
     */
    public Circle(double radius) throws  InvalidShapeParameterException{
        setRadius(radius);
    }

    /**
     * Returns the radius of the circle
     *
     * @return double radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle
     *
     * @param radius double Radius of the circle
     */
    public void setRadius(double radius) throws InvalidShapeParameterException{
        if (radius < 0) {
            throw new InvalidShapeParameterException("Circle radius cannot be negative");
        }
        this.radius = radius;
    }

    /**
     * Returns the circle's area
     *
     * @return double Area of circle
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Returns the description of the circle
     *
     * @return String description of the circle
     */
    @Override
    public String getDescription() {
        return String.format("Circle with a radius of %.2f and an area of %.2f", this.getRadius(), this.area());
    }

}
