package cse104_tutorial2;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayvsArrayList {

    public static void main(String[] args) {
	/* ........... Normal Array............. */
        int[] arr = new int[3]; 
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        //arr[3] = 4; //what's gonna happen? ArrayIndexOutOfBoundsException
        System.out.println(arr[0]);
        
 
        /*............ArrayList..............*/
        // Create an arrayList with initial capacity 2
        ArrayList<Integer> arrL = new ArrayList<>(2); 
 
        // Add elements to ArrayList
        arrL.add(1);
        arrL.add(2);
        //arrL.add(3); //can we add more? 
 
        // Access elements of ArrayList
        System.out.println(arrL.get(0));
        
        System.out.println(arrL); //implemented toString() method. 
        System.out.println(arr); //print out the memory address.
        
//        System.out.println(arrL.toString());
//        System.out.println(Arrays.toString(arr));
//        
//        System.out.println(arr.getClass().getName());
//        System.out.println(arrL.getClass().getName());
        
        // not allowed 
        // ArrayList<char> arrL0 = new ArrayList<char>();
 
        // Allowed
        ArrayList<Character> arrL0 = new ArrayList<>();
        ArrayList<Integer> arrL1 = new ArrayList<>();
        ArrayList<String> arrL2 = new ArrayList<>();
        ArrayList<Object> arrL3 = new ArrayList<>();
    }
	
	

}
