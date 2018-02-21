/**
 * @author Meng Li
 */
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;

    /**
     * Constructor to create Circle with radius.
     * @param newRadius radius value of circle
     */
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius, 2 * Math.PI * newRadius);
        radius = newRadius;
    }

    /**
     * Returns radius value of a Circle object.
     * @return double radius value
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns String representation of Circle object.
     * @return String representation of Circle object.
     */
    @Override
    public String toString() {
        return "Circle" + " " + outArea() + " " + outPerimeter();
    }
}
