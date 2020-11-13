package com.kwgdev.DataStructures;

public class HashTable {

//    O(1) Insert
//    O(1) Delete
//    O(1) Search / Retrieval

    // spell checker, spam checkers use hash tables

    public static void main(String[] args) {

        HashTable table = new HashTable(19);
        // 12 elements
        table.insert("Apple");
        table.insert("Hello");
        table.insert("Feeling");
        table.insert("Water");
        table.insert("Africa");
        table.insert("Speed");
        table.insert("Phone");
        table.insert("September");
        table.insert("Michael");
        table.insert("Milk");
        table.insert("Huge");
        table.insert("Dogs");

        System.out.println("---- Find Elements ----");
        System.out.println(table.find("Apple"));
        System.out.println(table.find("apple"));
        System.out.println(table.find("Zebra"));
        System.out.println(table.find("Feeling"));
        System.out.println(table.find("Water"));
        System.out.println(table.find("Africa"));
        System.out.println(table.find("Feeling"));



        table.displayTable();
    }

    // HashTable of Strings

    String[] hashArray;
    int arraySize; // extremely beneficial to have arraySize = a PRIME number to avoid collissions
    int size = 0; // counter for number of elements in hash table

    public HashTable(int numSlots) { // num slots can't be changed once initialized


        if (isPrime(numSlots)) {
            hashArray = new String[numSlots];
            arraySize = numSlots;
        } else {
            int primeCount = getNextPrime(numSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Hash table size given " + numSlots + " is not a prime number.");
            System.out.println("Hash table size changed to: " + primeCount + " for best performance.");

        }
    }

    private boolean isPrime(int num) {
        for(int i =2; i*i <= num; i++) {
            if (num % i == 0) { // not a prime
                return false;
            }
        }
        return true;

    }

    private int getNextPrime(int minNumber) {
        for(int i =minNumber; true; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    // double hashing
    // first hash function gives ideal position to insert
    // second hash function gives step size in case ideal position is taken (collision)

    // returns preferred index position
    private int hashFunc1(String word) {
        int hashVal = word.hashCode(); // *note Java can/will return negative hash values
        hashVal = hashVal % arraySize;

        if (hashVal < 0) {
            hashVal += arraySize;
        }

        return hashVal; // ideal index position to insert word or retrieve from
    }

    // returns step size, must return a value greater than 0
    private int hashFunc2(String word) {
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;

        if(hashVal < 0) {
            hashVal += arraySize;
        }

        // determine step size - use a prime number less than array size
        return 3 - hashVal % 3;
    }

    public void insert(String word) {
        int hashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        // while ideal insert spot is occupied, get new index to insert word
        while(hashArray[hashVal] != null) {
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        hashArray[hashVal] = word;
        System.out.println("Inserted word: " + word + " at index " + hashVal);
        size++;
    }

    public String find(String word) {

        int hashVal = hashFunc1(word);
        int stepSize = hashFunc2(word);

        // while ideal insert spot is occupied, get new index to insert word
        while(hashArray[hashVal] != null) {
            // is spot the word we're searching for?
            if(hashArray[hashVal].equals(word)) {
                return hashArray[hashVal];
            }
            // else word is not where expected, so have to increment step size until we find it

            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        // if word never found return whatever was found
        return hashArray[hashVal]; // most likely null

    }

    public void displayTable() {
        System.out.println("Table:  ");
        for(int i = 0; i < arraySize; i++) {
            if(hashArray[i] != null) {
                System.out.print(hashArray[i] + "  ");
            } else {
                System.out.print(" ** ");
            }

            System.out.println("");
        }
    }
}
