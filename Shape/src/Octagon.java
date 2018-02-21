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
     * Constructor to create Octagon with side.
     * @param newSide newSide
     */
    public Octagon(double newSide) {
        super((Math.sqrt(2) + 1) * newSide * newSide * 2, newSide * 8);
        side = newSide;
    }

    /**
     * Returns side value of a Octagon object.
     * @return double side value
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Octagon object.
     * @return String representation of Octagon object.
     */
    @Override
    public String toString() {
        return "Octagon" + " " + outArea() + " " + outPerimeter();
    }
}
