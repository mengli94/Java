/**
 * @author Meng Li
 *
 */
public class Test {
    /**
     * Demo code to test different shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(0.1);
        System.out.println(c);

        Shape r = new Rectangle(5, 3);
        System.out.println(((Rectangle) r).getHeight());

        Square sq = new Square(3);
        System.out.println(sq);
        
        Octagon o = new Octagon(1);
        System.out.println(o);
        
        Hexagon h = new Hexagon(1);
        System.out.println(h);

    }
}
