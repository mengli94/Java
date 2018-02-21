import java.util.Calendar;

/**
 * Example code for lecture 9.
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Now4 {
    /**
     * Simple program to use Calendar in java.util package.
     * @param args arguments
     */
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(10);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int dow = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("year = " + year);
        System.out.println("mon  = " + month);
        System.out.println("day  = " + day);
        System.out.println("dow  = " + dow);
    }
}