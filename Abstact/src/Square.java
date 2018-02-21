/**
 * @author Meng Li
 */
public class Square extends Rectangle {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor of Square with side parameter.
     * @param newSide side
     */
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }

    /**
     * Returns side value of Square object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Square object.
     * @return String representation of Square object
     */
    @Override
    public String toString() {
        return "Square" + " " + outArea(getArea()) + " " + outPerimeter(getPerimeter());
    }
}
