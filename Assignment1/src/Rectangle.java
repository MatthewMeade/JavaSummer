/**
 * Created by 20136520 on 5/9/2018.
 */
public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return this.getLength() * this.getWidth();
    }

    @Override
    public String getDescription() {
        return "Rectangle with a length of " + this.getLength() + " and a width of " + this.getWidth();
    }

    @Override
    public void setDescription(String description) {

    }
}
