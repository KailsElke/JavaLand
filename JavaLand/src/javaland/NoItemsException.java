
package javaland;


public class NoItemsException extends Exception{
    
    public NoItemsException(){
        System.out.println("No Items Exception created");
    }
    
    public String getMessage(){
        return "Your array is empty.";
    }
}


