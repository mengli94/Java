/*
 * Meng Li
 * mengl1
 */

/**
 * @author Administrator
 *
 */
public class HelloYum {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int x = 11;
        System.out.println(x);
        char[] a = new char[5];
        a[0] = 'a';
        a[4] = 'a';
        String b = new String(a); 
        //String c = null; 
        String d = ""; 
        //String e = null; 
        System.out.println(b);
        System.out.println(String.valueOf(500).equals(Integer.valueOf(500)));
        System.out.println(Integer.valueOf(500)==500);
        System.out.println(d instanceof String);
    }
}
