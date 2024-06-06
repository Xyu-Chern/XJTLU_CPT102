/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ting.Cao
 */
public class GenericTypes {
    
    public static void main(String args[]){ 
       int[] intArray0 = {1,2,3,4,5,6};
       printIntArray(intArray0);
       
       //printArray(intArray0);
       
      // Create arrays of Integer, Double and Character
//      Integer[] intArray = { 1, 2, 3, 4, 5 };
//      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
//
//      System.out.println("Array integerArray contains:");
//      printArray(intArray);   // pass an Integer array
//      
//      System.out.println("\nArray doubleArray contains:");
//      printArray(doubleArray);   // pass a Double array
//
//      System.out.println("\nArray characterArray contains:");
//      printArray(charArray);   // pass a Character array

        System.out.println("The max is : " + maximumofThree(1,2,3));
        System.out.println("The max is : " + maximumofThree("Apple","Orange","Banana"));
    }
    
    public static void printIntArray(int[] inputArray){
        for(int element : inputArray) {
            System.out.print(element + " " );
        }
        System.out.println();
    }
    
    //generic method printArray
    public static <E> void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.print(element + " " );
        }
        System.out.println();
    }
   
    // determines the largest of three Comparable objects
    public static <T extends Comparable<T>> T maximumofThree(T x, T y, T z) {
        T max = x;   // assume x is initially the largest   
        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }
        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now                 
        }
        return max;   // returns the largest object   
    }

}
