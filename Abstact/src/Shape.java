import java.text.DecimalFormat;

/**
 * @author Meng Li
 */
public abstract class Shape {
    /**
     * Default Constructor.
     */
    public Shape() {
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public abstract double getArea();

    /**
     * Returns area value of shape object.
     * @param x x
     * @return x value in String
     */
    public String outArea(double x) {
    DecimalFormat a = new DecimalFormat("0.000");
    return a.format(x);
    }

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public abstract double getPerimeter();

    /**
     * Returns perimeter value of shape object.
     * @param y y
     * @return y value in String
     */
    public String outPerimeter(double y) {
        DecimalFormat p = new DecimalFormat("0.000");
        return p.format(y);
    }
}
