package com.kwgdev.Algorithms;

public class SelectionSort {

    // SelectionSort is O(n^2)

    public static void main(String[] args) {
        int [] myArray = selectionSort(new int[] {9,8,3,13,87,12,99});
        for(int i=0; i <myArray.length; i++){
            System.out.println(myArray[i]);
        }

    }

    public static int[] selectionSort( int array[] ) {

        for ( int i=0; i < array.length; i++ ) {
            int minimum = i;
            for (int j = i + 1; j < array.length; j++) {
                if ( array[j] < array[minimum]) { // if we find a new value smaller than minimum
                    minimum = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimum];
            array[minimum] = temp;
        }
// return sorted array
        return array;
    }

}
