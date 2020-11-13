package com.kwgdev.DataStructures;

public class Stack {

    /* Stacks are LIFO “Last In – First Out”
    – the most recently added item is the first to be removed.


    It implements the commonly known methods "pop" "push" and "peek" */

    public static void main(String[] args) {
        Stack theStack = new Stack(3);
//		theStack.push(20);
//		theStack.push(40);
//		theStack.push(60);
//		theStack.push(80);
////
//		while(!theStack.isEmpty()){
//			long value = theStack.pop();
//			System.out.println(value);
//		}

        System.out.println(reverseString("Imtiaz"));
    }

    public static String reverseString(String str){
        int stackSize = str.length(); // get the max stack size
        Stack theStack = new Stack(stackSize); // we make the stack
        for(int j = 0; j < str.length(); j++){
            char ch = str.charAt(j); // getting a char from the input string
            theStack.push(ch);
        }

        String result = "";
        while(!theStack.isEmpty()){
            char ch = theStack.pop();
            result = result+ ch; // appending to the output
        }

        return result;
    }

    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j){
        if(isFull()){
            System.out.println(" this stack is already full");
        }else{
            top++;
            stackArray[top] = j;
        }

    }

    public char pop(){
        if(isEmpty()){
            System.out.println("the stack is already empty");
            return 'O';
        } else{
            int old_top = top;
            top--;
            return stackArray[old_top];
        }
    }

    public char peak(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (maxSize-1 == top);
    }
}
