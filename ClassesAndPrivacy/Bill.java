/**
 * The Bill class will record the amount, dates paid/due, whom to pay, and whether the bill has been paid or not.
 * It will contain methods for getters/setter for the amount, dueDate, originators, and paidDate.
 * It will also find if the paidDate has been paid or not, and when to schedule a paid date, as well as an unpaid
 * method.
 *
 * @author Eunhee Kim
 * @version October 24, 2019
 */
public class Bill {
    //instance variables of Money object for amount, Date objects for paidDate and dueDate, and String for who to pay
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**constructor(null for paidDate)
     *
     * @param amount Money object amount with initial values of how much to pay in a Bill object
     * @param dueDate Date object of when the bill should be paid by
     * @param originator String object of whom to pay
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this.amount = new Money(amount);
        this.dueDate = new Date(dueDate);
        this.paidDate = null;
        this.originator = originator;

    }

    /**copy constructor
     *
     * @param toCopy Bill object to copy over values into
     */
    public Bill(Bill toCopy) {
            this.amount = new Money(toCopy.amount);
            this.dueDate = new Date(toCopy.dueDate);
            //checking if the paidDate is null or not and transferring over to the copy
            if(toCopy.paidDate != null) {
                this.paidDate = new Date(toCopy.paidDate);
            } else{
                this.paidDate = null;
            }
            this.originator = toCopy.originator;
    }

    /**return the dueDate
     *
     * @return the Date object of dueDate
     */
    public Date getDueDate() {
        return new Date(this.dueDate);
    }

    /**return the originator
     *
     * @return the String of whom to pay
     */
    public String getOriginator() {
        return this.originator;
    }

    /**checking if the paidDate is not null and paid
     *
     * @return boolean statement if the bill has been paid
     */
    public boolean isPaid() {
        //if the paidDate is not null, then the Bill is paid, which will return true;
        if(paidDate != null) {
            return true;
        } else if(dueDate == null) {
            //if the dueDate is null, meaning that the Bill has a null dueDate since the Bill has paid,
            //it will return true
            return true;
        }
        //if the paidDate is null, then the bill has not been paid date, which will return false
        return false;
    }

    /**getter for paidDate
     *
     * @return Date object of when the paidDate is
     */
    public Date getPaidDate() {
        return new Date(paidDate);
    }

    /**make the bill paid, save the date
     *
     * @param onDay Date object that sets a day for Bill object to be paid
     */
    public void setPaid(Date onDay) {
            //checks if the date that is scheduled for a pay date is before the due date
            if (isConsistent(onDay)) {
                //marks the wanted date as the paidDate
                this.paidDate = onDay;
            }
    }

    /**make the bill unpaid
     * marks the paidDate as null, which directs that the bill has not been paid
     */
    public void setUnpaid() {
        this.paidDate = null;
    }

    /**set the due date of the bill
     *
     * @param nextDate Date object that sets a new dueDate for the bill
     */
    public void setDueDate(Date nextDate) {
        this.dueDate = new Date(nextDate);
    }

    /**change the amount
     *
     * @param amount Money object that sets a new amount for the Bill object
     */
    public void setAmount(Money amount) {
        this.amount = new Money(amount);
    }

    /**provide the Money object for the bill that is the amount
     *
     * @return Money object of how much the bill is
     */
    public Money getAmount() {
        return new Money(amount);
    }

    /**change the originator
     *
     * @param originator String of whom to pay
     */
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**build a string that reports the amount, when its due to whom, whether paid, and if paid, the date paid
     *
     * @return String statement of full record of bill
     */
    public String toString() {
        if(this.paidDate == null) {
            //if the paidDate is not scheduled, a String that says so will be created and plugged into
            //the area of when the paidDate will be
            String p = "have not scheduled a valid paid date";
            return "amount due: " + this.getAmount() + "\ndue to: " + this.getOriginator()
                    + "\ndue date: " + this.getDueDate() + "\npaid: " + this.isPaid() +
                    "\ndate paid: " + p;
        } else if (isConsistent(this.paidDate)) {
            //if the paidDate is before the dueDate, it will print out the following with the formal records
            return "amount due: " + this.getAmount() + "\ndue to: " + this.getOriginator()
                    + "\ndue date: " + this.getDueDate() + "\npaid: " + this.isPaid() +
                    "\ndate paid: " + this.getPaidDate();
        } else {
            return "amount due: " + this.amount + "\ndue to: " + this.originator
                    + "\ndue date: " + this.dueDate + "\npaid: " + isPaid() +
                    "\ndate paid: " + this.getPaidDate() + " is not a valid pay date";
        }
    }

    /**determine if the two bills are identical
     *
     * @param toCompare Bill object that is being compared to
     * @return boolean statement of whether the two comparing Bill objects are identical
     */
    public boolean equals(Bill toCompare) {
        //creating new object of Bill to compare with
        Bill other = new Bill(toCompare);
        //if all the variables of this Bill and the other Bill is the same, it will return true
        if(other.getOriginator().equals(this.getOriginator()) && other.getAmount().equals(this.getAmount())
                && other.getDueDate().equals(this.getDueDate()) && other.isPaid()==this.isPaid()) {
                return true;
        }
        //if the two Bill classes are not identical, it will return false
        return false;
    }

    /**method that checks the validation of a paidDate being before the dueDate
     *
     * @param aDay Date object of when to schedule a pay date
     */
    public boolean isConsistent(Date aDay) {
        //comparing the dates of the paidDate and dueDate, to make sure that the values of the aDay
        //is less than the dueDate
        if(aDay.getYear()>=dueDate.getYear() && aDay.getMonth()>=dueDate.getMonth() && aDay.getDay()>=dueDate.getDay()) {
            return false;
        } else
        return true;
    }
}
