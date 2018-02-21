/**
 * @author Meng Li
 */
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;

    /**
     * Instance variable for area.
     */
    private double area;

    /**
     * Instance variable for perimeter.
     */
    private double perimeter;

    /**
     * Constructor to create Circle with radius.
     * @param newRadius radius value of circle
     */
    public Circle(double newRadius) {
        radius = newRadius;
        area = Math.PI * newRadius * newRadius;
        perimeter = Math.PI * newRadius * 2;
    }

    /**
     * Returns radius value of a Circle object.
     * @return double radius value
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Returns String representation of Circle object.
     * @return String representation of Circle object.
     */
    @Override
    public String toString() {
        return "Circle" + " " + outArea(area) + " " + outPerimeter(perimeter);
    }
}
