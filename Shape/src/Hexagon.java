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
     * Constructor to create Hexagon with side.
     * @param newSide newSide
     */
    public Hexagon(double newSide) {
        super(1.5 * Math.sqrt(3) * newSide * newSide, newSide * 6);
        side = newSide;
    }

    /**
     * Returns side value of a Hexagon object.
     * @return double side value
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Hexagon object.
     * @return String representation of Hexagon object.
     */
    @Override
    public String toString() {
        return "Hexagon" + " " + outArea() + " " + outPerimeter();
    }

}
