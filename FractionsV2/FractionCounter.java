/**
 * The FractionCounter class will keep track of what Fraction object to refer to
 * while also counting the amount of occurrences it has throughout the
 * input file.
 *
 * @author Eunhee Kim
 * @version October 10, 2019
 */

public class FractionCounter {
    //instance variables:
    //an objece from the Fraction class
    private Fraction aFraction;
    //an integer variable to keep track of how many counts of the fraction there are
    private int count;

    //constructor that takes in an object from the Fractions class
    public FractionCounter(Fraction theFraction) {
        this.aFraction = theFraction;
    }

    //comparing if the passing fraction is the same as the first fraction while
    //keeping track of the counts
    public boolean compareAndIncrement(Fraction newFraction) {
        boolean isEqual = false;
        if(aFraction.equals(newFraction)) {
            count++;
            isEqual = true;
        }
        return isEqual;
    }

    //prints out the statement of the fractions and how many occurrences it had
    @Override
    public String toString() {
        return aFraction + " has a count of " + count;
    }
}
