/**
 * @author Meng Li
 *
 */
public class Octagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Instance variable for area.
     */
    private double area;

    /**
     * Instance variable for perimeter.
     */
    private double perimeter;

    /**
     * Constructor to create Octagon with side.
     * @param newSide newSide
     */
    public Octagon(double newSide) {
        side = newSide;
        area = (Math.sqrt(2) + 1) * newSide * newSide * 2;
        perimeter = newSide * 8;
    }

    /**
     * Returns side value of a Octagon object.
     * @return double side value
     */
    public double getSide() {
        return side;
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
     * Returns String representation of Octagon object.
     * @return String representation of Octagon object.
     */
    @Override
    public String toString() {
        return "Octagon" + " " + outArea(area) + " " + outPerimeter(perimeter);
    }
}
