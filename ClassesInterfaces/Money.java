import java.io.Serializable;

/**
 * The Money class will record the variables and values in integers
 * of dollars and cents. The methods it contain will include
 * getters and setters of the instances, as well as functions to add
 * from inputs of int dollars, int dollars and cents, another Money object,
 * and comparing two objects with an equal method, and a string method
 * to print out a statement of the money object.
 *
 * The Money class will also implement from the interfaces of Compare, Cloneable,
 * and Serializable, to add methods of compareTo() and clone()
 *
 * @author Eunhee Kim
 * @version November 21, 2019
 */
public class Money implements Comparable<Object>, Cloneable, Serializable {
    //instance variables of dollars and cents to keep track of
    private int dollars;
    private double cents;

    /**the clone method will make a clone of a Money object
     *
     * @throws CloneNotSupportedException
     * @return the result of the cloned Money object
     */
    public Money clone() throws CloneNotSupportedException {
        try{
            Money newMoney = (Money)super.clone();
            return newMoney;
        } catch(CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException is caught");
            return null;
        }
    }

    /**The compareTo method is implemented from the Comparable interface and will
     * check to see if an object is either before, after, or equal to the comparing object
     *
     * @param o Object o is what we are comparing our object to
     * @return an integer that returns 1 if the passing parameter object o occurs before, returns -1 if it occurs
     * after, returns 0 if it is the same
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Money) {
            Money other = (Money) o;
            if (this.getMoney() > other.getMoney()) {
                return 1;
            } else if (this.getMoney() < other.getMoney()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -2;
        }
    }

    /**
     * this constructor initializes using dollars input and assumes no cents to be added
     *
     * @param dol the integer of dollars that is passed in to initialize the amount of money
     * in an object
     *
     */
    public Money(int dol) {
        if(dol >=0) {
            dollars = dol;
        }
    }

    /**
     * this constructor initializes dollars and cents accordingly
     *
     * @param dol an integer of dollars to initialize the amount in a Money object
     * @param cent an integer of cents to initialize to add on to combine with the amount in a Money object
     */
    public Money(int dol, int cent) {
        if(dol>=0 && cent >=0 && cent<=99) {
            dollars = dol;
            cents = (cent*0.01);
        }
    }

    /**
     * this constructor could redirect to the one above
     * copy constructor
     *
     * @param other a Money object that copies over the instances and its values
     */
    public Money(Money other) {
        //checking if the object is not empty
        if(other == null) {
            System.out.println("Money object is empty");
            System.exit(0);
        }
        //checking if the dollars and cents are possible values and not a negative or over 99 cents
        if(other.dollars>=0 && other.cents>=0 && other.cents<=99) {
            this.dollars = other.dollars;
            this.cents = other.cents;
        } else {
            System.out.println("invalid values of Money object");
        }
    }


    /**
     * getter for dollars
     *
     * @return the dollars in integers of a Money object
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * getter for cents
     *
     * @return the cents in double of a Money object
     */
    public int getCents() {

        return (int)cents;
    }

    /**
     * setter for dollars
     *
     * @param d setting the value of dollars with an integer
     */
    public void setDollars(int d) {
        //checking if the input for setting the value of dollars is valid
        //and must be greater than 0
        if(d>=0) {
            dollars = d;
        } else {
            System.out.println("invalid amount of dollars");
            System.exit(0);
        }
    }

    /**
     * setter for cents
     *
     * @param c setting the value of cents with an integer
     */
    public void setCents(int c) {
        //checking if the input for setting the value of cents is valid
        //between 0 to 99 cents
        if(c>=0 && c<=99) {
            double p = 0.01;
            //converting the cents into a double so that format of cents will be more accurate
            //e.g. inputting 1 as c will be 0.01 and not 0.1 in cents
            cents = c*p;
        } else {
            //print for wrong input of the parameter
            System.out.println("invalid amount of cents");
            System.exit(0);
        }
    }

    /**
     * a getter for the total monetary amount, as a double
     * returns 5.75 for example
     *
     * @return a double value of the amount of money from a Money object
     */
    public double getMoney() {
        double money  = dollars + cents;
        return money;
    }

    /**
     * sets our dollars and cents, accordingly
     * this function should take use of setters for dollars and cents
     *
     * @param d integer dollars to set new values of d
     * @param c integer cents to set new values of c
     */
    public void setMoney(int d, int c) {
        //checking if the input of dollars and cents are possible values
        //before adding
        if(d>=0) {
            setDollars(d);
        } else {
            System.out.println("invalid amount of dollars");
            System.exit(0);
        }
        if(c>=0 && c<=99) {
            double p = 0.01;
            cents = c*p;
        } else {
            System.out.println("invalid amount of cents");
            System.exit(0);
        }

    }

    /**
     * adds the int passed into the function to dollars
     * should accept positive and negative arguments
     *
     * @param d adds integer d to dollars
     */
    public void add(int d) {
        if (d>=0) {
            dollars += d;
        }
    }

    /**
     * adds to dollars and cents the two ints passed into the function
     * should accept positive and negative arguments (though both
     * arguments have to be positive or negative)
     *
     * @param d adds the integer to add onto dollars
     * @param c adds the integer to add onto cents
     */
    public void add(int d, int c) {
        if (d>=0 && c>=0 && c<=99) {
            dollars += d;
            cents += c;
        } else {
            System.out.println("invalid amount");
        }
    }

    /**
     * adds to this object the dollars and cents stored in the other object
     *
     * @param other Money object that will add onto another Money object from the values implemented from other
     */
    public void add(Money other) {
        if(other.dollars>=0 && other.cents>=0 && other.cents<=99) {
            dollars = other.dollars + dollars;
            cents = other.cents + cents;
        } else {
            System.out.println("invalid amount");
        }
    }

    /**
     * determines if this money object is equal to that Money object
     *
     * @param o Object to compare a Money object to
     * @return boolean if the two objects are identical
     */
    public boolean equals(Object o) {
        if(o instanceof Money) {
            Money other =(Money) o;
            return other.cents == this.cents && other.dollars == this.dollars;
        }
        return false;
    }

    /**
     * prints out a Money object as a String, such as “$3.75”
     *
     * @return the print statement of proper money form
     */
    public String toString() {
        return "$" + getMoney();
    }


}
