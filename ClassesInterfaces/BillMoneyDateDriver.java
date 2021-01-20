/**
 Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        System.out.println("Money class testing:");
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        //TODO: do more functional exercises with the money class


        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
        System.out.println(money1.getDollars());
        System.out.println(money2.getCents());
        System.out.println(money1.getCents());


        //construct some bills
        System.out.println();
        System.out.println("Bill objects output:");

        System.out.println("BILL 1:");
        //Money object named amount with value of 20 dollars
        Money amount = new Money(20);
        //initializing a dueDate from a Date object
        Date dueDate = new Date(4, 30, 2007);
        //initializing a Bill object with the variables created above plus an originator
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
        //printing out the first bill
        System.out.println(bill1);
        System.out.println();

        System.out.println("BILL 2:");
        //second Bill object that uses a copy constructor to copy over values from bill1
        Bill bill2 = new Bill(bill1);
        //setting a new dueDate in bill2
        bill2.setDueDate(new Date(5, 30, 2007));
        //printing out the second bill
        System.out.println(bill2);
        System.out.println();

        System.out.println("BILL 3:");
        //changing the value of the Money object, amount
        amount.setMoney(31, 99);
        //changing the day of the Date object, dueDate
        dueDate.setDay(29);
        //third Bill object that uses the changed amount and dueDate in its parameters
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        //printing third bill
        System.out.println(bill3);
        System.out.println();

        System.out.println("BILL 4:");
        //changing the dollar value of the Money object, amount
        amount.setDollars(90);
        //changing the cent value of the Money object, amount
        amount.setCents(45);
        //fourth Bill object that uses the new value of amount, different originator, but same dueDate as bill2
        Bill bill4 = new Bill(amount, bill2.getDueDate(), "Eunhee Kim");
        //creating new objects of Date
        Date a = new Date(10, 23, 2019);
        Date b = new Date(1, 1, 2020);
        //setting a different dueDate for bill4 with the Date object, b
        bill4.setDueDate(b);
        //setting a paidDate for bill4 with the Date object, a
        //since the paidDate is before the dueDate, it should print out correct information of date paid and
        //true for isPaid()
        bill4.setPaid(a);
        //printing fourth bill
        System.out.println(bill4);
        System.out.println();

        System.out.println("BILL 5:");
        //fifth Bill object
        Bill bill5 = new Bill(amount, b, "Mom");
        //creating new object of Date
        Date c = new Date(2, 2, 2020);
        //testing the output of adding a paidDate later than the dueDate, which should give a false outcome for
        //isPaid() and the date paid is not scheduled due to invalid paid date
        bill5.setPaid(c);
        //printing bill5
        System.out.println(bill5);
        System.out.println();

        System.out.println("Bill 6:");
        //sixth bill object that copies over the variables from bill4
        Bill bill6 = new Bill(bill4);
        //bill6 setting a new originator
        bill6.setOriginator("UW");
        //Money object of amount sets different values in dollars and cents
        amount.setMoney(3000, 2);
        //bill6 sets the new amount as its own
        bill6.setAmount(amount);
        //bill6 is now unpaid which should have no date paid scheduled and isPaid() be false
        bill6.setUnpaid();
        //printing bill6
        System.out.println(bill6);
        System.out.println();

        System.out.println("BILL 7:");
        //creating new Date object with a year less than 2001 and should print that the year is invalid
        Date d = new Date(9, 20, 1999);
        //seventh bill with the last amount value and the invalid year Date object
        Bill bill7 = new Bill(amount, d, "Dad");
        //printing bill7
        System.out.println(bill7);
        System.out.println();

        System.out.println("BILL 8:");
        //changing amount to new value
        amount.setMoney(89, 99);
        //creating 2 new Bill objects with identical variables of Bill class
        Bill bill8 = new Bill(amount, b, "Friend");
        Bill bill9 = new Bill(amount, b, "Friend");
        //printing bill8
        System.out.println(bill8);
        System.out.println();

        System.out.println("BILL 9:");
        //printing bill9(should be same as bill8)
        System.out.println(bill9);
        System.out.println();

        //testing statement of whether bill8 and bill9 are equal before a change (should print true)
        System.out.println("(before change) bill8 and bill9 are equal: " + bill8.equals(bill9));
        System.out.println();

        //new Date object
        Date e = new Date(5, 5, 2005);
        //paidDate for bill9 is changed to the new object created
        bill9.setPaid(e);
        //changing the originator of bill9
        bill9.setOriginator("enemy");
        System.out.println("BILL 9(after change):");
        //printing bill9 after changing few values
        System.out.println(bill9);
        System.out.println();

        //testing statement of whether bill8 and bill9 are equal after changing bill9 (should print false)
        System.out.println("(after change) bill8 and bill9 are equal: " + bill8.equals(bill9));
        System.out.println();

        System.out.println("BILL 10:");
        //changing month of Date object, e
        e.setMonth(8);
        //changing day
        e.setDay(8);
        //changing year
        e.setYear(2008);
        //adding 10 more dollars into amount
        amount.add(10);
        //tenth bill with the changed values
        Bill bill10 = new Bill(amount, e, "brother");
        //setting a paidDate with the values from dueDate into bill10
        bill10.setPaid(dueDate);
        //printing bill10
        System.out.println(bill10);
        System.out.println();

        System.out.println("BILL11:");
        //creating new Money object
        Money m = new Money(10, 21);
        //adding a Money object(m) into another Money object(amount)
        amount.add(m);
        //eleventh bill that has the changed amount
        Bill bill11 = new Bill(amount, e, "sister");
        //printing bill11
        System.out.println(bill11);
        System.out.println();


        ArrayList<Bill> myBills = new ArrayList<>();
        myBills.insert(bill1,0);
        myBills.insert(bill2,1);
        myBills.insert(bill3,2);
        myBills.insert(bill4,3);
        myBills.insert(bill5,4);
        myBills.insert(bill6,5);
        myBills.insert(bill7,8);
        myBills.insert(bill8,9);
        myBills.insert(bill9,10);
        myBills.insert(bill10,11);

        ExpenseAccount expenses = new ExpenseAccount(myBills);

        for(Bill bill : expenses) {
            System.out.println(bill);
        }

        expenses.findTotalExpenses();
        expenses.getPaidList();
        expenses.getUnpaidList();
        expenses.addBill(bill11);
        expenses.removeBill(bill1);
    }
}
