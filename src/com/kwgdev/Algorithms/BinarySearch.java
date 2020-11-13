package com.kwgdev.Algorithms;

public class BinarySearch {


    // Binary Search is O(log n)
    // **Requires the array to SORTED**

    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[] {1,2,3,4,7,9,12,18,99}, 0, 7,  12));
    }

    public static int binarySearch( int[] sortedArray, int x ) {

        int first = 0;			// first half mid-pointer, starts at first element index
        int second = sortedArray.length - 1;	// last half mid-pointer, starts at last element index

        while( first <= second ) {
            // mid is our halfway point, cutting each iteration in half
            int mid = ( first + second ) / 2;

            if ( x < sortedArray[mid] ) {
                second = mid - 1;
            } else if ( x > sortedArray[mid] ) {
                first = mid + 1;
            } else {
                return sortedArray[mid];
            }

            // returns index position of request element x
        }
// if not found
        return -1;
    }

    public static int recursiveBinarySearch(int [] array, int first, int second, int x){
        // first is our first half mid-pointer, starts at first element index [0] working inward
        // second is our last half mid-pointer, starts at last element index [array.length-1] working inward
        // mid is our halfway point, cutting each iteration in half
        System.out.println("[ "+ first + "..." + second + " ]");
        if( first > second){
            return -1;
        } else{
            int mid = (first+second)/2;
            if(array[mid] == x){
                return mid;
            } else if (array[mid] > x){
                return recursiveBinarySearch(array, first, mid-1, x);
            } else{
                return recursiveBinarySearch(array, mid+1, second, x);
            }
            // returns index position of request element x
        }
    }

    public int getElementFrom(int [] a, int index){
        return a[index];
    }
}
//    Java Collections binarySearch() Method
//    The binarySearch() is an inbuilt method of Java Collections class which returns the position of the object in a sorted list. There are two different types of Java collections binarySearch() method which can be differentiated depending on its parameter. These are:
//        1.	Java Collections binarySearch(List<? extends Comparable<? super T>> list, T key)
//        2.	Java Collections binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
//        Java Collections binarySearch(List<? extends Comparable<? super T>> list, T key) This method is used to search the provided list for the specified object using the binary search algorithm. The list must be sorted into ascending order according to the specified natural number, prior to making the method call. If the list is not sorted, the results are undefined.
//        Java Collections binarySearch(List<? extends T> list, T key, Comparator<? super T> c) This method is used to search the provided list for the specified object using the binary search algorithm. The list must be sorted into ascending order according to the specified comparator prior to making the method call.
//        Syntax Following is the declaration of binarySearch() method:
//        1.	public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
//        2.	public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
//        Parameter	Description	Required/Optional
//        list	It is specified by user to be searched.	Required
//        key	It is the key to be searched for in the provided list.	Required
//        c	It is a comparator used for sorting the list.	Required
//        Example 1
//        1.	import java.util.*;
//        2.	public class CollectionsBinarySearchExample1 {
//3.	    public static void main(String[] args) {
//        4.	        //Create list
//        5.	          ArrayList<String> arrlist = new ArrayList<String>();
//        6.	          arrlist.add("A");
//        7.	          arrlist.add("B");
//        8.	          arrlist.add("C");
//        9.	          arrlist.add("D");
//        10.	          //Search the list for key 'D'
//        11.	          int index = Collections.binarySearch(arrlist, "D");
//        12.	          System.out.println("index 'D' is available at position: "+index);
//        13.	        }
//14.	}
//Output:
//        index 'D' is available at position: 3
