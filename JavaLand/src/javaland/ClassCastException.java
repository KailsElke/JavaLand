
package javaland;


public class ClassCastException extends Exception{
    
    public ClassCastException(){
        System.out.println("Class Cast Exception created");
    }
    
    public String getMessage(){
        return "Improperly converting a class from one type to another";
    }
}
