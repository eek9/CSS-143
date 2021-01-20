public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;
    private int balance;
    
    //the following five methods are copied over from the related links(BankingAccount.java)
    //the method/constructor for the MinMaxAccount is what I have included and added onto
    //for this assignment
    public BankingAccount(Startup s) {
        this.balance = s.startup_getBalance();
        historyTransaction = new LinkedList<String>();
        historyBalance = new LinkedList<String>();
        
        historyTransaction.add(valueToHistory(s.startup_getBalance()));
        historyBalance.add(toString());
    }
    
    public void debit(Debit d) {
        balance += d.debit_getBalance();
        
        historyTransaction.add(valueToHistory(d.debit_getBalance()));
        historyBalance.add(toString());
    }
    
    public void credit(Credit c) {
        balance += c.credit_getBalance();
        
        historyTransaction.add(valueToHistory(c.credit_getBalance()));
        historyBalance.add(toString());
    }
    
    public int getBalance() {
        return balance;
    }
    
    public MinMaxAccount(Startup s) {
        super(s);
        
    }
    
    public int getMin() {
        while(super.getBalance()<min) {
            min = super.getBalance();
        }
        return min;
    }
    
    public int getMax() {
        while(super.getBalance()>max) {
            max = super.getBalance();
        }
        return max;
    }
}
