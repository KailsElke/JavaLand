package javaland;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author elke8448
 */
public class JavaLand {
    public static Scanner input;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayManager customerAM;
    static ArrayManager accountsAM;
    
    public static void main(String[] args) {
        int action = 0;
        input = new Scanner(System.in);
            
        //create customer and account array managers
        customerAM = new ArrayManager(3);
        accountsAM = new ArrayManager(4);
 
        //create customer objects
        Customer customer1 = new Customer("Kailey","Elke",'M',1);
        Customer customer2 = new Customer("John","Smith",'T',2);
        Customer customer3 = new Customer("Jane","Doe",'F',3);
        
        //add customers to the customer array manager
        customerAM.add(customer1);
        customerAM.add(customer2);
        customerAM.add(customer3);
        
        //create and add accounts to the account array manager
        accountsAM.add(new ChequingAccount(1,500,customer1,5,25));
        accountsAM.add(new SavingsAccount(2,700,customer1,100));
        accountsAM.add(new ChequingAccount(3,600,customer2,5,25));
        accountsAM.add(new SavingsAccount(4,800,customer3,100));
        
        //print the customer and account arrays
        customerAM.print();
        accountsAM.print();
        System.out.println();
        
        //continue this loop until user chooses option 7 (exit)
        do{
						//call method to display the main menu        	
            action = showMenu();
            
            if (action == 1){
                deposit();
            }else if (action == 2){
                withdraw();
            }else if (action == 3){
                transfer();
            }else if (action == 4){
                addCustomer();
            }else if (action == 5){
                addAccount();
            }else if (action == 6){
                deleteAccount();
            }else{
                System.exit(0);
            } 
        }while(action != 7);
    }
    
    public static int showMenu(){
        int menuSelection = 0;
        String invalidEntry;
        
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Add a customer"); 
        System.out.println("5. Add a BankAccount");
        System.out.println("6. Delete an account");
        System.out.println("7. Exit");
        
        //continue to ask for a menu selection if the user doesn't enter a number between 1 and 7
        do {
            System.out.print("Enter your selection: ");
            invalidEntry = input.next();
            
            //check if the user entered a letter instead of a number
            if (invalidEntry.matches("\\d+")){
                //if it is a number, change string to an int
                menuSelection = Integer.parseInt(invalidEntry);
                
                //check if the user entered a number between 1 and 7
                if (menuSelection < 1 || menuSelection > 7 || "/n".equals(menuSelection))
                    System.out.println("Must enter a number betwen 1 and 7!");
            }else{
                System.out.println("Must enter a number betwen 1 and 7!");
            }
        }while(menuSelection < 1 || menuSelection > 7);
        
        //return the selected menu option
        return menuSelection;
    }
    
    //when menu option 1 is selected, this method is run
    public static void deposit(){
        System.out.print("Enter an account #: ");
        int accountNo = input.nextInt();
        
        BankAccount currentAccount = getBankAccount(accountNo);
            
        System.out.print("Enter amount to deposit: ");
        float amount = input.nextFloat();
        currentAccount.deposit(amount);

        accountsAM.print();
        System.out.println();
    }
    
    //when menu option 2 is selected, this method is run
    public static void withdraw(){
        System.out.print("Enter an account #: ");
        int accountNo = input.nextInt();
            
        BankAccount currentAccount = getBankAccount(accountNo);
        
        System.out.print("Enter amount to be withdrawn: ");
        float amount = input.nextFloat();
        currentAccount.withdraw(amount);

        accountsAM.print();
        System.out.println();
    }
    
    //when menu option 3 is selected, this method is run
    public static void transfer(){
        System.out.print("Enter an account #: ");
        int accountNo = input.nextInt();
            
        BankAccount account1 = getBankAccount(accountNo);
            
        System.out.print("Enter amount to be transferred: ");
        float amount = input.nextFloat();
        
        System.out.print("Enter account to transfer to: ");
        int accountNum = input.nextInt();
                
        BankAccount account2 = getBankAccount(accountNum);
        
        account1.transfer(amount, account2);
        
        accountsAM.print();
        System.out.println();
    }
    
    //when menu option 4 is selected, this method is run
    public static void addCustomer(){
        //first, last, middle, ID
        System.out.print("Enter customer first name: ");
        String first = input.next();
        
        System.out.print("Enter customer last name: ");
        String last = input.next();
        
        System.out.print("Enter customer middle initial: ");
        char middle = input.next().charAt(0);
        
        int account = customerAM.size() + 1;
        
        Customer newCustomer = new Customer(first, last, middle, account);
        
        customerAM.add(newCustomer);
        customerAM.print();
        System.out.println();
    }
    
    //when menu option 5 is selected, this method is run
    public static void addAccount(){
        System.out.println("1. Chequing Account");
        System.out.println("2. Savings Account");
        System.out.print("Enter choice: ");
        int accountType = input.nextInt();
        
        int account = accountsAM.size() + 1;
        
        System.out.print("Enter account balance: ");
        float balance = input.nextFloat();
        
        System.out.print("Enter customer ID: ");
        int customerNo = input.nextInt();
        
        Customer cust = getCustomer(customerNo);

        if(accountType == 1){
            System.out.print("Enter overdraft limit: ");
            float odLimit = input.nextFloat();
            
            System.out.print("Enter overdraft penalty: ");
            float odPenalty = input.nextFloat();
            
            ChequingAccount newAccount = new ChequingAccount(account, balance,
            cust, odPenalty, odLimit);
            
            accountsAM.add(newAccount);
            
            try{
                accountsAM.sort();
            }catch(ClassCastException cce){
                System.out.println(cce.getMessage());
            }
                    
        }else if(accountType == 2){
            System.out.print("Enter minimum balance: ");
            float minBalance = input.nextFloat();
            
            SavingsAccount newAccount = new SavingsAccount(account, balance,
            cust, minBalance);
            
            accountsAM.add(newAccount);
            
            try{
                accountsAM.sort();
            }catch(ClassCastException cce){
                System.out.println(cce.getMessage());
            }
        }
        accountsAM.print();
        System.out.println();
    }
    
    //when menu option 6 is selected, this method is run
    public static void deleteAccount(){
        System.out.print("Enter account number to be deleted: ");
        int account = input.nextInt();
        
        for(int i=0; i<accountsAM.size(); i++){
            if(((BankAccount)accountsAM.getElementAt(i)).getAccountNo()==account){
                try{
                    accountsAM.remove(i);
                }catch(NoItemsException nie){
                    System.out.println(nie.getMessage());
                }
            }   
        }

        try{
            accountsAM.sort();
        }catch(ClassCastException cce){
            System.out.println(cce.getMessage());
        }
        
        accountsAM.print();
        System.out.println();
    }
    
    public static BankAccount getBankAccount(int accountNumber){
        BankAccount ba = null;
        
        try{
            for(int i=0; i<accountsAM.size();i++ ){
                if(((BankAccount)accountsAM.getElementAt(i)).getAccountNo()==accountNumber){
                    ba = (BankAccount)accountsAM.getElementAt(i);
                }   
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        return ba;    
    }
    
    public static Customer getCustomer(int id){
        Customer c = null;
        
        try{
            for(int i=0; i<customerAM.size();i++ ){
                if(((Customer)customerAM.getElementAt(i)).getCustomerID()==id){
                    c = (Customer)customerAM.getElementAt(i);
                }   
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
        return c;    
    }
}
