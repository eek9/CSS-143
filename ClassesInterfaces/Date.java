import java.io.Serializable;
import java.util.Comparator;

/**
 * The Date class will assign the values of the Date objects into integers
 * of a month, date, and year. It will also contain methods of getters
 * and setters of each instance, and also making sure that
 * there will be no privacy leaks happening.
 *
 * The Date class will also implement from the interfaces of Compare, Cloneable,
 * and Serializable, to add methods of compareTo() and clone()
 *
 * @author Eunhee Kim
 * @version November 21, 2019
 */
public class Date implements Comparable<Object>, Cloneable, Serializable {
    //instance variables of integer in month, day, and year
    public int month;
    public int day;
    public int year;

    /**the clone method will make a clone of a Date object
     *
     * @throws CloneNotSupportedException
     * @return the result from the cloned Date object
     */
    public Date clone() throws CloneNotSupportedException{
        try {
            Date newDate = (Date) super.clone();
            return newDate;
        } catch(CloneNotSupportedException e) {
            System.out.println("CloneNoteSupportedException is caught");
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
        if(o instanceof Date) {
            Date other = (Date) o;
            return this.getDate().compareTo(other.getDate());
        }
        else {
            return -2;
        }
    }

    /**
     * constructor of setting/initializing the month, day and year from the user
     *
     * @param m integer month to initialize the values of the Date object
     * @param d integer day to initialize the values of the Date object
     * @param y integer year to initialize the values of the Date object
     */
    public Date(int m, int d, int y) {
        if(m>=1 && m<=12) {
            this.month = m;
        } else {
            System.out.println("invalid month");
        }
        if(d>=1 && d<=31) {
            this.day = d;
        } else {
            System.out.println("invalid day");
        }
        if(y>=2001 && y<=2024) {
            this.year = y;
        } else {
            System.out.println("invalid year");
        }
    }

    /**
     * copy constructor
     *
     * @param other object of Date class to copy values over to
     */
    public Date(Date other) {
        if(other == null) {
            System.out.println("object is empty");
        } if(other.month<=12 && other.month>=1 &&
                other.day<=31 && other.day>=1 &&
                other.year>=2001 && other.year<=2024) {
            month = other.month;
            day = other.day;
            year = other.year;
        }
    }

    /**
     * getter for date
     *
     * @return date of the object
     */
    public Date getDate() {
        return this;
    }

    /**
     * getter for month
     *
     * @return integer value of month from object
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * getter for day
     *
     * @return integer of the current value of day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * getter for year
     *
     * @return integer of the current value of year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * setter for month
     *
     * @param m integer month to set new value of month in object
     */
    public void setMonth(int m) {
        //checking the instances of making sure that the month is between
        //the first and last month of the year
        if (m <= 12 && m >= 1) {
            this.month = m;
        } else {
            System.out.println("month is invalid");
        }
    }

    /**
     * setter for day
     *
     * @param d integer day to set new value of day in object
     */
    public void setDay(int d) {
        //checking if the input is a possible value of day and is between
        //1 and 31
        if(d <= 31 && d >= 1) {
            this.day = d;
        } else {
            System.out.println("day is invalid");
        }
    }

    /**
     * setter for year
     *
     * @param y integer year to set new value of year in object
     */
    public void setYear(int y) {
        //checking if the year is between the required boundaries of 2001-2024
        if(y <= 2024 && y >= 2001) {
            this.year = y;
        } else {
            System.out.println("year is invalid");
        }
    }

    /**
     * method that compares two objects
     *
     * @param o other Object comparing to
     * @return boolean statement if comparing objects are equal
     */
    public boolean equals(Object o) {
        if(o!= null) {
            //checking if the instance of comparing object is from same class
            if (o instanceof Date) {
                Date other = (Date) o;
                //comparing each variable of objects with one another
                return this.year == other.year && this.day == other.day && this.month == other.month;
            }
        }
        return false;
    }

    /**
     * method that prints out a statement of the date
     *
     * @return printed statement of date with slashes to divide the month, day, and year
     */
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

}
