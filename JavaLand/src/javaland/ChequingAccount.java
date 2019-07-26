
package javaland;


public class ChequingAccount extends BankAccount{
    private float overDraftPenalty;
    private float overDraftLimit;
    
    public ChequingAccount(){}
    
    public ChequingAccount(int accountNo, float balance, Customer customer,
            float overDraftPenalty, float overDraftLimit){
        
        super(accountNo, balance, customer);
        setOverDraftPenalty(overDraftPenalty);
        setOverDraftLimit(overDraftLimit);
        
    }
    
    @Override
    public void withdraw(float amount){
        //if withdraw amount is greater than account balance + over draft limit
        //notify user that they have insufficient funds
        if (amount > super.getBalance() + this.overDraftLimit){
            System.out.println("Insufficient Funds");
        //if amount is greater than account balance, withdraw amount plus over
        //draft penalty and set new balance
        }else if (amount > super.getBalance()){
            float newBalance = super.getBalance() - (amount + this.overDraftPenalty);
            setBalance(newBalance);
        //if sufficient funds, withdraw amount from account and set new balance    
        }else{
            float newBalance = super.getBalance() - amount;
            setBalance(newBalance);
        }
    }
    
    public float getOverDraftPenalty() {
        return overDraftPenalty;
    }

    public void setOverDraftPenalty(float overDraftPenalty) {
        this.overDraftPenalty = overDraftPenalty;
    }

    public float getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(float overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    
}
