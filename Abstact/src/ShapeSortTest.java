/**
 * Two arrays of objects and for loop and sorting.
 * @author Meng Li
 */
public class ShapeSortTest {
    /**
     * Build Shape objects and sort them using nested for loops.
     * @param args arguments
     */
    public static void main(String[] args) {
        Shape[] s = new Shape[args.length];
        for (int i = 0; i < args.length; i++) {
            double a = Double.parseDouble(args[i].substring(1));
            char b = args[i].charAt(0);
            switch (b) {
            case 'C':
            s[i] = new Circle(a);
            break;
            case 'S':
            s[i] = new Square(a);
            break;
            case 'H':
            s[i] = new Hexagon(a);
            break;
            case 'O':
            s[i] = new Octagon(a);
            break;
            default:
            break;
            }
        }

        for (int i = 0; i < s.length-1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[j].getArea() < s[i].getArea()) {
                    Shape temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        for (Shape sh : s) {
            System.out.println(sh);
        }

        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[j].getPerimeter() > s[i].getPerimeter()) {
                    Shape temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }

        for (Shape sh : s) {
            System.out.println(sh);
        }
    }
}
