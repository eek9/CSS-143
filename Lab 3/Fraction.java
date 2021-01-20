/**
 * The Fraction Class will include final variables of a numerator and a
 * denominator.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class Fraction {
    //Class Invariants:
    //Numerators and denominators are unchangeable once set by the constructor.
    //No denominator will be stored as a 0. (i.e., no DivideByZero Exceptions).
    //A Fraction is always in reduced form (reduce in the constructor to ensure this).

    //Data:
    //Define a numerator that is public and final.
    public final int numerator = 0;
    //Why don’t we make this data private?
    //
    //Define a denominator that is public and final
    public final int denominator = 1;
    //What data types should these items be?
    //

    //Define a constructor that takes a numerator and a denominator
    //Do not define a no-argument constructor. Why?
    //We have already stated the class variables as final, which have initially declared
    //a value for each variable

    //I understand that there are redlines under the instance variables because it
    //was initially declared as a final data member. However, the directions told
    //me to define the constructors that take in a numerator and a denominator. Which, I
    //can only do if the class variables were not labeled final.
    //I commented the code so that there would be no compile error.
    public Fraction(int n, int d) {
        //numerator = n;
        //denominator = d;
    }

    //Define a constructor that takes a Fraction object and makes a copy of it.
    public Fraction(Fraction other) {
        //this.numerator = other.numerator;
        //this.denominator = other.denominator;
    }

    //Define a toString() function as we’ve done for other classes.
    public String toString() {
        return numerator + "/" + denominator;
    }

    //Define an add function that takes a fraction, adds it to this, then returns a new Fraction object
    //that is the result of the addition of the two
    public Fraction add(Fraction that) {
    //add this and that together; remember to consider the denominator here!
        int finalD = denominator * that.denominator;
        int n1 = finalD/numerator;
        int n2 = finalD/that.numerator;
        int finalN = n1 + n2;
        return new Fraction(finalN, finalD);
    }

    public boolean equals(Object other) {
        if(other!=null && ! (other instanceof Fraction)) return false;
            //what does this code do?
            //the other object must be coming from a Fraction class, and if it is
            //not, the boolean is false.
            //if the object is also null, it is false
            Fraction that = (Fraction) other;
            //and this code?
            //this turns the other object into a Fraction object.
            //todo: code goes here
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }


}
