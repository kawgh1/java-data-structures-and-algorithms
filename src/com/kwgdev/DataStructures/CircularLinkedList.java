package com.kwgdev.DataStructures;

public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList mylist = new CircularLinkedList();
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

    public CircularLinkedList(){
        first = null;
        last = null;
    }

    private boolean isEmpty() {
        return first==null;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            last = newNode;
        }
        newNode.next = first; // newNode --> old first
        first = newNode; // first place
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            first = newNode;
        } else{
            last.next = newNode; // the next value of the last node will point to the new node
            last = newNode; // we make the new node we created be the last one in the list
        }
    }

    public int deleteFirst(){
        int temp = first.data;

        if(first.next == null){
            last = null;
        }

        first = first.next; // first will point to old's next value
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

}
