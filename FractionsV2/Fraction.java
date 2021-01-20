/**
 * This class calculates the ratio of the numerator and denominator of the
 * fraction. It also includes a method to find the reduced form of the fraction
 * in the list as whole numbers.
 *
 * @author Eunhee Kim
 * @version October 10, 2019
 */

public class Fraction {
    private double numerator;
    private double denominator;

    public Fraction() {
    }

    //the constructor for when the input are 2 integers to represent the fraction
    public Fraction(int n, int d) {
        int numerator = n;
        int denominator = d;
    }

    //the constructor for when the input are 2 doubles to represent the fraction
    public Fraction(double n, double d) {
        double numerator = n;
        double denominator = d;
    }

    //checking if the comparing fraction is the same as the first fraction
    public boolean equals(Fraction that) {
        if(this.numerator == that.numerator && this.denominator == that.denominator) {
            return true;
        }
        return false;
    }

    //Overriding the method toString to print out the fraction
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    //accessor for the numerator
    public double getNumerator() {
        return this.numerator;
    }

    //accessor for the denominator
    public double getDenominator() {
        return this.denominator;
    }

    //mutator for a fraction with an included input of a new numerator and denominator
    public void setFraction(int n, int d) {
        int numerator = n;
        int denominator = d;
    }

    //mutator for new values in a Fraction with a double input for numerator and denominator
    public void setFraction(double n, double d) {
        double numerator = n;
        double denominator = d;
    }

    //this method helps find the greatest common denominator between the inputs of
    //the numerator and denominator
    public int findGCD(int numerator, int denominator) {
        if(denominator == 0) {
            return numerator;
        }
        else {
            return findGCD(denominator, numerator%denominator);
        }
    }

    //this method reduces the fraction into a more simpler form
    public void reducedFraction(int numerator, int denominator) {
        int gcd = findGCD(numerator, denominator);
        this.numerator = (numerator/gcd);
        this.denominator = (denominator/gcd);
    }

}


