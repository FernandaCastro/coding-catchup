package com.fcastro.dataStructure;

import java.util.Stack;

public class MyQueueAsStack2 {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    MyQueueAsStack2(){
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    boolean isEmpty(){
        return (stackA.isEmpty() && stackB.isEmpty());
    }

    int peek(){
        if (isEmpty())
            return -1;
        if (stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    void push(int value){
        stackA.push(value);
    }

    int pop(){
        if (peek() == -1)
            return -1;

        return stackB.pop();
    }

    @Override
    public String toString() {
        return "MyQueueAsStack2{" +
                "stackA=" + stackA +
                ", stackB=" + stackB +
                '}';
    }

    public static void main(String[] args) {
        MyQueueAsStack2 myQueueAsStack = new MyQueueAsStack2();
        myQueueAsStack.push(1);
        myQueueAsStack.push(2);
        myQueueAsStack.push(3);

        System.out.println(myQueueAsStack.toString());

        System.out.println("Peek: " + myQueueAsStack.peek());

        System.out.println(myQueueAsStack.toString());

        System.out.println("Pop: " + myQueueAsStack.pop());
        System.out.println("Pop: " + myQueueAsStack.pop());
        System.out.println("isEmpty: " + myQueueAsStack.isEmpty());

        System.out.println(myQueueAsStack.toString());

        System.out.println("Pop: " + myQueueAsStack.pop());
        System.out.println("isEmpty: " + myQueueAsStack.isEmpty());

        System.out.println(myQueueAsStack.toString());
    }

}
