/**This fraction class will have two instance variables of a numerator and
 * a denominator, and will include methods to access and mutate the two
 * instances. It will also have a method to subtract two Fraction objects
 * from one another, so that it would be used in our Pizza class. This class
 * also implements from the Comparable class to override the compareTo method
 * into this class for comparing the value of two different fraction objects
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Fraction implements Comparable{
    private int numerator;
    private int denominator;

    /**this is the default constructor where it initializes the values of
     * numerator and denominator to equal 1
     *
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**this is a copy constructor that will make a deep copy of another
     * Fraction object
     * @param f the Fraction object copying from
     */
    public Fraction(Fraction f) {
        this.numerator = f.getNumerator();
        this.denominator = f.getDenominator();
    }

    /**this is a constructor that will initialize values of the numerator
     * and denominator into a Fraction object
     *
     */
    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    /**this method will get the fraction value of an object in decimal
     * form so that it will be able to be identified as a double when
     * comparing values
     * @return double the decimal form of the fraction value
     */
    public double getFractionValue() {

        return (double) getNumerator()/getDenominator();
    }

    /**this is the getter for the numerator of a Fraction object
     * @return int of the value of the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**this is the getter for the denominator of a Fraction object
     * @return int of the value of the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**this is the setter for the denominator that sets a new value
     * @param denominator the value to be changing the object denominator
     *  value into
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**this is the setter for the numerator that sets a new value
     * @param numerator the value to be changing the object numerator
     *  value into
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**this method will subtract a fraction object from another fraction object
     * @param f the Fraction object that will be subtracted by
     * @return the new Fraction object that is returned after the process of subtraction
     */
    public Fraction subFraction(Fraction f) {
        if(f.getDenominator() == 0) {
            throw new ArithmeticException();
        } else {
            int resultD = this.getDenominator()*f.getDenominator();
            int resultN = (this.getNumerator()*f.getDenominator()) - (this.getDenominator()*f.getNumerator());
            Fraction n = new Fraction(resultN, resultD);
            this.denominator = n.denominator;
            this.numerator = n.numerator;
            return this;
        }
    }

    /**this method will override the toString() method
     * to print a proper form of a Fraction object
     * @return String of the Fraction value
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**this method will override the equals method to compare the values of the
     * numerator and denominator values of the Fraction object to check if they
     * are the same.
     * @param that the object that will be comparing to
     * @return boolean value if equal or not
     */
    @Override
    public boolean equals(Object that) {
        if(that instanceof Fraction) {
            Fraction other = (Fraction) that;
            if (this.numerator == other.numerator && this.denominator == other.denominator) {
                return true;
            }
        }
        return false;
    }

    /**this method will override the compareTo() method from the Compareable
     * interface between the values of of two Fractions
     * @param o the object being comapred to
     * @return int of either 1, -1, or 0 if the fraction value is less than, greater
     * than, or equal to the
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Fraction) {
            Fraction other = (Fraction) o;
            if (this.getFractionValue() > other.getFractionValue()) {
                return 1;
            } else if (this.getFractionValue() < other.getFractionValue()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -2;
        }
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Fraction testing = new Fraction();
        testing.setDenominator(3);
        testing.setNumerator(4);
        System.out.println("testing: " + testing);

        Fraction compare = new Fraction(testing);
        System.out.println("compare: " + compare);
        System.out.println("is compare and testing equal? " + compare.equals(testing));
        System.out.println("test1 passed");
        System.out.println();

        compare.setDenominator(50);
        System.out.println("compare: " + compare);
        System.out.println("are compare and testing equal now? " + compare.equals(testing));
        System.out.println("test2 passed");
        System.out.println();

        System.out.println("after subtracting compare from testing: " + testing.subFraction(compare));
        System.out.println("test3 passed");
    }
}
