
package javaland;


public abstract class Person{
    private String firstName;
    private String lastName;
    private char middleInit;
    
    public Person(){}
    
    public Person(String firstName, String lastName, char middleInit){
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleInit(middleInit);
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }
    
    @Override
    public String toString() {
        String name = this.firstName + " " + this.lastName;
        return name;
    }

}
