
package javaland;
import java.util.Arrays;

public class ArrayManager {

    private Object[] items;  
    private int count;

    //A constructor that accepts an array of integers to be assigned to items
    public ArrayManager(Object[] array){
        this.items = array;
        count = items.length;
    }
    
    //A parameterless constructor that sets count to 0 and sizes the array to 10.
    public ArrayManager(){
        count = 0;
        items = new Object[10];
    }
    
    //A constructor that accepts an integer and sizes the array.
    public ArrayManager(int size){
        items = new Object[size];
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public void print(){ 
        System.out.println(Arrays.toString(items));
    }
    
    //adds object n to the end of the array
    public void add(Object n){       
        if (count >= items.length) {
            //create new array that is one position larger in size than the old
            Object[] temp = new Object[items.length + 1];
            //copy the old values to the new array
            System.arraycopy(items, 0, temp, 0, items.length);
            //set the items array equal to the new array
            items = temp;
        }
        //add object n to the end of the array
        items[count] = n;
        //increase count (length of the array) by one
        count++;
    }
    
    //removes the element at index pos
    public void remove(int pos) throws NoItemsException{
        //if the array is empty
        if(count == 0){
            throw new NoItemsException();
        }
        
        //create new array that is one position smaller in size than the old
        Object[] newArray = new Object[count - 1];
        
        //copy old values to new array, up to the position of the item being removed
        System.arraycopy(items, 0, newArray, 0, pos);
        //copy old values to new array, starting after the position of the removed item
        System.arraycopy(items, pos+1, newArray, pos, newArray.length - pos);
        //set items array equal to the newArray
        this.items = Arrays.copyOf(newArray, newArray.length);
        
        //decrease count (length of the array) by one
        count--;
    }
    
    //remove all items between start and end (including start and end)
    public void removeRange(int start, int end) throws OutOfBoundsException{
        if (end > count || start < 0) {
            throw new OutOfBoundsException();
        }
        // 2 to 4 = 3 items removed or 1 to 6 = 6 items removed
        int numberOfItemsRemoved = (end - start) + 1;
        
        //create new array that is resized to correct size
        Object[] newArray = new Object[items.length - numberOfItemsRemoved];
        
        //copy old values to new array, up to the start of the items to be removed
        System.arraycopy(items, 0, newArray, 0, start); 
        //copy old values to new array, starting after the end of items to be removed
        System.arraycopy(items, end+1, newArray, start, newArray.length - start);
        //set items array equal to the newArray
        this.items = Arrays.copyOf(newArray, newArray.length);
      
        count = newArray.length;
        
    }
    
    //adds object n at position pos in the array manager
    public void addAt(Object n, int pos) throws OutOfBoundsException{
        if (pos > count || pos < 0) {
            throw new OutOfBoundsException();
        }
        //create a new array that is one position larger in size
        Object[] newArray = new Object[count + 1];
        
        //copy values from the old array to the new array starting in the first 
        //position and ending just before where the new item was added
        System.arraycopy(items, 0, newArray, 0, pos);
        
        //add the new item at the specified position
        newArray[pos] = n;
        
        //copy the rest of the items from the old array to the new array starting
        //from just after where the new item was added
        System.arraycopy(items, pos, newArray, pos+1, count - pos);
        
        //set the items array to equal the new array, with the new length
        this.items = Arrays.copyOf(newArray, newArray.length);
        
        //increase count (length of the array) by one
        count++;
    }
    
    //returns true if the array is empty
    public boolean isEmpty(){
        if (this.count == 0)
            return true;
        else
            return false;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(Object[] items) {
        this.items = items;
    }
    
    //returns the item at the specified position in the array
    public Object getElementAt(int pos) throws OutOfBoundsException {
        if (pos > count || pos < 0) {
            throw new OutOfBoundsException();
        }
        return items[pos];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    //sorts the array manager
    public void sort() {
        Arrays.sort(items);   
    }
    
    //counts the number of times an object appears in the ArrayManager
    public int countOccurances(Object o){
        int numberOfOccurances = 0;
        
        for(int i = 0; i < count; i++){
            if(items[i] == o){
                numberOfOccurances++;
            }
        }
        return numberOfOccurances;
    }
    
}
