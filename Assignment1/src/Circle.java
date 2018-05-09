/**
 * Created by 20136520 on 5/9/2018.
 */
public class Circle extends Shape{
    private double radius;

    /**
     * Constructor to create a circle
     * TODO handle negative
     * @param radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Radius Getter
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Radius Setter
     * @return
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public void setDescription(String description) {

    }

    public String getDescription(){
        return "Circle with radius of " + this.getRadius();
    }

}
