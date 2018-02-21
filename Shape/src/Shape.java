import java.text.DecimalFormat;

/**
 * @author Meng Li
 */
public class Shape {
    /**
     * Instance variable for area.
     */
    private double area;

    /**
     * Instance variable for perimeter.
     */
    private double perimeter;

    /**
     * Constructor with area parameter.
     * @param newArea area
     * @param newPerimeter perimeter
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns area value of shape object.
     * @return area value in String
     */
    public String outArea() {
    DecimalFormat a = new DecimalFormat("0.000");
    return a.format(area);
    }

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in String
     */
    public String outPerimeter() {
        DecimalFormat p = new DecimalFormat("0.000");
        return p.format(perimeter);
    }

    /**
     * Returns String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        return "Shape" + " " + outArea() + " " + outPerimeter();
    }
}
