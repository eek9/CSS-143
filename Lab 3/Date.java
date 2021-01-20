/**
 * The date class will take in data for the month, day, and year.
 * It will also make sure that the values are possible and detect basic
 * errors.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */

public class Date {

    //Define these as private? public?
    //private

    //1. What is the difference between the public and private access modifiers?
    //public access modifiers allow other programmers to obtain and change the
    //data

    //2. When data is defined as static...
    //Can it be accessed or read?
    //It can be accessed by the class name and without an object

    //Can it be written to?
    //It can be written to, however there is only one copy of that data for the whole
    //class

    //If we had declared one static variable and 10 objects declared in RAM,
    //how many static variables would also be in memory?
    //There will be only one static variable in memory of being shared with all
    //10 objects

    //3. When data is defined as final...
    //Can it be accessed/used or read?
    //Yes

    //Can it be written to other than the first initialization?
    //No, it keeps the final/initial value as it was declared

    //Why would it be ok to declare a final (or static final) variable as public?
    //This way, the value of the variable will stay the same, while also being easily
    //accessed by other users

    //Later: How does the concept of a final variable relate to Immutable classes?
    //In immutable classes, once an object is created, the content in it cannot be changed.
    //To also create one requires in labeling the class and the data members as "final".

    private int month;
    private int day;
    private int year;

    //Provide getter/setter methods for each of the variables above
    //Provide logic in your setter methods to observe the following Class Invariants
    public int getDay() {
        return day;
    }
    public void setDay(int d) {
        if(d<=31 && d>=0) {
            day = d;
        } else {
            System.out.println("please enter a valid day");
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int m) {
        if(m<=12 && m>=0) {
            month = m;
        } else {
            System.out.println("please enter a valid month");
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(int y){
        if (y>=0) {
            year = y;
        } else {
            System.out.println("please enter a valid year");
        }
    }

    //This is the default no-arg constructor.
    public Date() {
    }

    //Should we use month = m; or setMonth(m)? What are the differences?
    //we should use month = m because setMonth(m) will be calling another method
    //into this method. The purpose of this constructor is to first assign an
    //value for a Date object.
    public Date(int m, int d, int y) {
        if(m<=12 && m>=0) {
            month = m;
        } else {
            System.out.println("please enter a valid month");
        }
        if(d<=31 && d>=0) {
            day = d;
        } else {
            System.out.println("please enter a valid day");
        }
        if (y>=0) {
            year = y;
        } else {
            System.out.println("please enter a valid year");
        }
    }

    public void setDate(int m, int d, int y) {
        if(m<=12 && m>=0) {
            month = m;
        } else {
            System.out.println("please enter a valid month");
        }
        if(d<=31 && d>=0) {
            day = d;
        } else {
            System.out.println("please enter a valid day");
        }
        if (y>=0) {
            year = y;
        } else {
            System.out.println("please enter a valid year");
        }
    }

    //This method is a copy constructor; initialize your object’s data members
    //(this.month, etc) using “other”.
    public Date(Date other) {
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    //report on your date
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    //In this method, you’ll compare “this” to “that”, once the other object
    //has been checked and cast.
    //See Fraction equals() for proper null-check and casting.
    public boolean equals(Date other) {
        if (this.day == other.day) {
            if (this.month == other.month) {
                if (this.year == other.year) {
                    return true;
                }
            }
        }
        return false;
    }
}
