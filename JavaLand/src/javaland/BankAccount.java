package javaland;


public abstract class BankAccount implements Comparable{

   
    private int accountNo;
    private float balance;
    private Customer customer;
    
    public BankAccount(){}
    
    public BankAccount(int accountNo, float balance, Customer customer){
        setAccountNo(accountNo);
        setBalance(balance);
        setCustomer(customer);
    }
    
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void deposit(float amount){
        this.balance = this.balance + amount;
    }
    
    public abstract void withdraw(float amount);
    
    public void transfer(float amount, BankAccount account){
        withdraw(amount);
        account.deposit(amount);
    }
    
    @Override
    public String toString() {
        //format the balance to two decimal places
        String StrBalance = String.format("%.2f", this.balance);
        
        //form string to be returned
        String account = "Account " + Integer.toString(this.accountNo) +
                ": Balance = $" + StrBalance;
        return account;
    }
    
    @Override
    public int compareTo(Object d){
        BankAccount account = (BankAccount)d; 
            
        if(this.accountNo < account.getAccountNo())
            return 1;
        else if(this.accountNo > account.getAccountNo())
            return -1;
        else 
            return 0;
    }
}
