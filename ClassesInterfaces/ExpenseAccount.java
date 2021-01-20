/**
 * The ExpenseAccount class will inherit from the ArrayList class with also using
 * methods that make sense to use in an Expense Account, such as finding the total
 * expenses, the list of paid and unpaid bills, and removing/adding bills
 *
 * @author Eunhee Kim
 * @version October 21, 2019
 */
public class ExpenseAccount extends ArrayList<Bill> {

    ArrayList<Bill> billList = new ArrayList<>();

    /**this is a constructor that copies over an ArrayList of bills into a
     * a deep copy
     *
     * @param billList ArrayList of Bill objects
     */
    public ExpenseAccount(ArrayList<Bill> billList) {
        this.billList = billList;
    }

    /**this method will add up all the total bill fees from the list of Bills
     *
     * @return a Money object that contains the total after adding up all the bills
     */
    public Money findTotalExpenses() {
        //creating an initial Money object that we will be adding in our totals into
        Money total = new Money(0);
        //a for loop to add the amount of money from each bill in the list
        for(int i=0; i<billList.size(); i++) {
            //creating a Money object that only takes the Money instance of the bill object
            Money bill = (Money)billList.get(i);
            //adding the Money amount from the bill into the Money total object
            total.add(bill);
        }
        //returning the Money object of total amount of expenses
        return total;
    }

    /**this method will create an ArrayList that contains all the bills that were paid
     *
     * @return an ArrayList of paid Bill objects
     */
    public ArrayList<Bill> getPaidList() {
        //creating an ArrayList to add onto for the paid bills
        ArrayList<Bill> paidList = new ArrayList();
        //this count is to keep track of the amount of paid bills
        int count=0;
        //for loop to check each bill to see if it is paid
        for (int i=0; i<billList.size(); i++) {
            //creating a Bill object to compare from the instance of the index
            //based on the individual bill from billList object
            Bill bill = (Bill) billList.get(i);
            //checking to see if the bill is paid, which will add and increase the
            //count of the billList
            if(bill.isPaid()) {
                paidList.insert(billList.get(i), count);
                count++;
            }
        }
        //returning the list of the paid bills
        return paidList;
    }

    /**this method will create an ArrayList that contains the unpaid bills
     *
     * @return an ArrayList of unpaid Bills
     */
    public ArrayList<Bill> getUnpaidList() {
        //creating an ArrayList to add onto for the unpaid bills
        ArrayList<Bill> unpaidList = new ArrayList();
        //this count is to keep track of the amount of unpaid bills
        int count=0;
        //for loop to check each bill to see if it is paid
        for (int i=0; i<billList.size(); i++) {
            //creating a Bill object to compare from the instance of the index
            //based on the individual bill from billList object
            Bill bill = (Bill) billList.get(i);
            //checking to see if the bill is unpaid, which will add and increase the
            //count of the billList
            if(!(bill.isPaid())) {
                unpaidList.insert(billList.get(i), count);
                count++;
            }
        }
        //returning the list of unpaid bills
        return unpaidList;
    }

    /**this method will remove a Bill object from the list of bills
     *
     * @param bill a Bill object that will be removed from the list
     */
    public void removeBill(Bill bill) {
        //checks to see if the bill is null
        if(bill==null) {
            System.out.println("bill is null");
        }
        else {
            //for loop to compare the bill object if it matches to a bill in the
            //list, and will remove the bill when it finds its match
            for (int i = 0; i < billList.size(); i++) {
                if (billList.get(i).equals(bill)) {
                    billList.remove(indexOf(bill));
                }
            }
        }
    }

    /**this method will add a bill to the end of the ArrayList of bills
     *
     * @param bill the bill that will be added to the list
     */
    public void addBill(Bill bill) {
        //checks to see if the bill is null
        if(bill == null) {
            System.out.println("bill is null");
        }
        else{
            //appends the bill to the end of the list through the insert method
            billList.insert(bill, billList.size());
        }
    }

}
