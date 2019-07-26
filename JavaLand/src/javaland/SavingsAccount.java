
package javaland;


public class SavingsAccount extends BankAccount{

    private float minBalance;
    private int withdrawCount = 0;
    private final static float activity_penalty = 25;
    private final static int activity_limit = 10;
    
    public SavingsAccount(){}
    
    public SavingsAccount(int accountNo, float balance, Customer customer, float minBalance){
        super(accountNo, balance, customer);
        setMinBalance(minBalance);
    }
    
    @Override
    public void withdraw(float amount){
        //if the balance is large enough to withdraw the requested amount,
        //increase the withdraw count
        if(super.getBalance() <= minBalance){
            this.withdrawCount++;
        }    
        
        //if the withdraw count is greater than or equal to the limit, subtract
        //activity penalty from bank balance
        if(withdrawCount >= activity_limit){
            //check for sufficient funds
            if(amount > super.getBalance() - activity_penalty){
                System.out.println("Insufficient Funds");
            //if sufficient funds, withdraw amount and penalty; set new balance
            }else if(amount > super.getBalance()){
                float newBalance = super.getBalance() - (amount + activity_penalty);
                setBalance(newBalance);
            }
        //if withdraw count is not over the limit
        }else{
            //check for sufficient funds
            if(amount > super.getBalance()){
                System.out.println("Insufficient Funds");
            //if sufficient funds, withdraw amount and set new balance
            }else {
                float newBalance = super.getBalance() - amount;
                setBalance(newBalance);
            }
        }
    }
    
    public float getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }

    public int getWithdrawCount() {
        return withdrawCount;
    }

    public void setWithdrawCount(int withdrawCount) {
        this.withdrawCount = withdrawCount;
    }

    public static float getActivity_penalty() {
        return activity_penalty;
    }

    public static int getActivity_limit() {
        return activity_limit;
    }

}
