/**
 * @author Meng Li
 *
 */
public class Hexagon extends Shape {
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
     * Constructor to create Hexagon with side.
     * @param newSide newSide
     */
    public Hexagon(double newSide) {
        side = newSide;
        area = 1.5 * Math.sqrt(3) * newSide * newSide;
        perimeter = newSide * 6;
    }

    /**
     * Returns side value of a Hexagon object.
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
     * Returns String representation of Hexagon object.
     * @return String representation of Hexagon object.
     */
    @Override
    public String toString() {
        return "Hexagon" + " " + outArea(area) + " " + outPerimeter(perimeter);
    }

}
