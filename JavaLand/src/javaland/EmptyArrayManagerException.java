
package javaland;

public class EmptyArrayManagerException extends OutOfBoundsException{
    
    public String operation; 
    
    public EmptyArrayManagerException(){
        System.out.println("Empty Array Exception created");
    }
    
    public EmptyArrayManagerException(String operation){
        
        System.out.println("Empty Array Exception created");
        this.operation = operation;
    }
    
    public String getMessage(){
        
        return super.getMessage()+" Your array manager is empty.  Can't " + operation;
    }
    
}
