
package javaland;


public class Customer extends Person{
    private int CustomerID;
    
    public Customer(){
        super();
    }
    
    public Customer(String firstName, String lastName, char middleInit, int customerID){
        super(firstName, lastName, middleInit);
        setCustomerID(customerID);
    }
    
    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    
    @Override
    public String toString() {
        String name = "Customer " + this.CustomerID + ": " + this.getFirstName() + " " + this.getLastName();
        return name;
    }
    
}
