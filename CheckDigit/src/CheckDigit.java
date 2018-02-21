/**
 * Homework 2 solution to compute check digit.
 * @author Meng Li (mengl1@andrew.cmu.edu)
 *
 */
public class CheckDigit {
    /**
     * Computes the check digit for a 12-digit UPC number.
     * @param args arguments
     */
    public static void main(String[] args) {
        long ups = Long.parseLong(args[0]);
        long a = ups / 10000000000L;
        long b = ups / 1000000000L % 10;
        long c = ups / 100000000L % 10;
        long d = ups / 10000000L % 10;
        long e = ups / 1000000L % 10;
        long f = ups / 100000L % 10;
        long g = ups / 10000L % 10;
        long h = ups / 1000L % 10;
        long i = ups / 100L % 10;
        long j = ups / 10L % 10;
        long k = ups % 10L;
        System.out.println("" + a + b + c + d + e + f + g + h + i + j + k);
        long y = (3 * a + b + 3 * c + d + 3 * e + f + 3 * g + h + 3 * i + j + 3 * k) % 10;
        long x = (10 - y) % 10;
        System.out.println(x);
    }
}
