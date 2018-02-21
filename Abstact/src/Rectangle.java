/**
 * @author Meng Li
 */
public class Rectangle extends Shape {
    /**
     * Instance variable for width.
     */
    private double width;

    /**
     * Instance variable for height.
     */
    private double height;

    /**
     * Instance variable for area.
     */
    private double area;

    /**
     * Instance variable for perimeter.
     */
    private double perimeter;

    /**
     * Constructor with width and height.
     * @param newWidth width value
     * @param newHeight height value
     */
    public Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
        area = newWidth * newHeight;
        perimeter = 2 * newWidth + 2 * newHeight;
    }

    /**
     * Returns width value of rectangle object.
     * @return width value in double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height value of rectangle object.
     * @return height value in double
     */
    public double getHeight() {
        return height;
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
     * Returns Spring representation of rectangle object.
     * @return String representation of rectangle object
     */
    @Override
    public String toString() {
        return "Rectangle" + " " + outArea(area) + " " + outPerimeter(perimeter);
    }
}
