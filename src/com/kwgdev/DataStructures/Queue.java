package com.kwgdev.DataStructures;

public class Queue {

    // Queue is an Interface in Java, see notes at end of file

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(100);
        myQueue.insert(1000);
        myQueue.insert(14);
        myQueue.insert(12);
        myQueue.insert(44);
        myQueue.insert(99);
        myQueue.insert(99);
        myQueue.insert(99);
        myQueue.insert(99);
        myQueue.insert(99999);
        myQueue.view();
    }

    private int maxSize; // initializes the set number of slots
    private long[] queArray; // slots to main the data
    private int front; // this will be the index position for the element in the front
    private int rear; // going to be the index position for the element at the back of the line
    private int nItems; // counter to maintain the number of items in our queue

    public Queue(int size){
        this.maxSize = size;
        this.queArray = new long[size];
        front = 0; // index position of the first slot of the array
        rear = -1; // there is no item in the array yet to be considered as the last item.
        nItems =0; // we don't have elements in the array yet
    }

    public void insert(long j){

        if(rear == maxSize -1){
            rear = -1;
        }

        rear++;
        queArray[rear] = j;
        nItems ++;
    }

    public long remove(){ // remove item from the front of the queue
        long temp = queArray[front];
        front++;
        if(front == maxSize){
            front = 0; // we can set front back to the 0th index so that we can utilize the entire array again
        }
        nItems --;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems ==0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public void view(){
        System.out.print("[ ");
        for(int i = 0; i < queArray.length; i++){
            System.out.print(queArray[i]+ " ");
        }
        System.out.print("]");
    }

    /*
    * Interface Queue<E>
•	Type Parameters:
E - the type of elements held in this collection
All Superinterfaces:
Collection<E>, Iterable<E>
All Known Subinterfaces:
BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>
public interface Queue<E>
extends Collection<E>
A collection designed for holding elements prior to processing.
* Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations.
* Each of these methods exists in two forms: one throws an exception if the operation fails,
* the other returns a special value (either null or false, depending on the operation).
*
* The latter form of the insert operation is designed specifically for use with capacity-restricted
* Queue implementations; in most implementations, insert operations cannot fail.
*
Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner.
* Among the exceptions are priority queues, which order elements according to a supplied comparator,
* or the elements' natural ordering, and LIFO queues (or stacks) which order the elements LIFO (last-in-first-out).
* Whatever the ordering used, the head of the queue is that element which would be removed by a
* call to remove() or poll().
*
* In a FIFO queue, all new elements are inserted at the tail of the queue.
* Other kinds of queues may use different placement rules.
* Every Queue implementation must specify its ordering properties.
*
The Queue interface does not define the blocking queue methods,
* which are common in concurrent programming.
* These methods, which wait for elements to appear or for space to become available,
* are defined in the BlockingQueue interface, which extends this interface.
*
Queue implementations generally do not allow insertion of null elements,
* although some implementations, such as LinkedList, do not prohibit insertion of null.
* Even in the implementations that permit it, null should not be inserted into a Queue,
* as null is also used as a special return value by the poll method to indicate that the queue
* contains no elements.
*
Queue implementations generally do not define element-based versions of methods equals and
* hashCode but instead inherit the identity based versions from class Object,
* because element-based equality is not always well-defined for queues with the same elements
* but different ordering properties.

    * */

}
