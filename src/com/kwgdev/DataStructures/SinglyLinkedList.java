package com.kwgdev.DataStructures;

public class SinglyLinkedList {

    /*List in Java is an Interface and not directly implementable.
      Generally arrayLists are used.*/

    public static void main(String[] args) {
        SinglyLinkedList mylist = new SinglyLinkedList();
        mylist.insertFirst(100);
        mylist.insertFirst(50);
        mylist.insertFirst(99);
        mylist.insertFirst(88);
        mylist.insertLast(9999999);

        mylist.displayList();
    }

    public class Node {
        public int data;
        public Node next;

        public void displayNode(){
            System.out.println("{ "+ data + " } ");
        }
    }

    private Node first;
    private Node last;
    public SinglyLinkedList(){

    }

    public boolean isEmpty(){
        return (first == null);
    }

    // used to insert at the beginning of the list
    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }

    public Node deleteFirst(){
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first --> last) ");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void insertLast(int data){
        Node current = first;
        while(current.next != null){
            current = current.next; // we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

}
