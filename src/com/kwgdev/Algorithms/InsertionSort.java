package com.kwgdev.Algorithms;

public class InsertionSort {

    // InsertionSort is O(n^2)

    public static void main(String[] args) {
        int myArray[] = insertionSort(new int[] {9,8,99, 110, 8,87,637, 8,3,13,87,12,99});

        for(int i =0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }

    public static int[] insertionSort( int[] array ) {

        for ( int i = 1; i < array.length; i++) {

            int element = array[i]; // element variable contains the data we intend on bringing over to the sorted section
            int j = i - 1; // var j points to the index position of the last value in the sorted area

            while ( j >= 0 && array[j] > element ) {
                array[ j + 1 ] = array[j];
                j--;
            }
            array[ j + 1 ] = element;
        }
        return array;
    }


}
