/**
 * The Math2 Class will demonstrate the use of a final constant and the methods
 * coming from the Math wrapper class.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class Math2 {
    //Class Invariants:
    //All methods & data must be static

    //Data Items:
    //Define a static constant (use final) for the mathematical constant pi.
    public static final double pi = 3.14;
    //Define a second constant for E.
    public static final double e = 2.72;
    //Should we make this data private? public?
    //We should make this data public so that it can be accessible with other users
    //and it is already labeled as a final value of a constant, which cannot be changed

    //Note that we avoid calling this section Data Members, as these are not
    //instance variables but rather static, shared data.

    //Methods:
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public double max(double a, double b) {
        return Math.max(a, b);
    }

    public int pow(int base, int exp) {
        return (int)Math.pow(base, exp);
    }
}