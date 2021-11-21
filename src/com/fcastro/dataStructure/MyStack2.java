package com.fcastro.dataStructure;

import java.util.Arrays;

//Using Array
public class MyStack2<T> {

    private T[] stack;
    private int size;

    MyStack2() {
        this.stack = (T[]) new Object[10];
        this.size = 0;
    }

    T peek() {
        if(size==0)
            return null;

        return stack[size-1];
    }

    void push(T value) {
        if (size >= (stack.length/0.75))
            stack = Arrays.copyOf(stack, stack.length * 2);

        stack[size] = value;
        size++;
    }

    T pop() {
        if (size==0)
            return null;

        T value = stack[size-1];
        stack[size-1] = null;
        size--;

        return value;
    }

    @Override
    public String toString() {
        return "MyStack2{" +
                "stack=" + Arrays.toString(stack) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyStack2<String> myStack = new MyStack2<>();
        System.out.println("Push Google");
        myStack.push("Google");
        System.out.println("Push Udemy");
        myStack.push("Udemy");
        System.out.println("Push Discord");
        myStack.push("Discord");
        System.out.println("Peek: " + myStack.peek());
        System.out.println(myStack.toString());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println(myStack.toString());
    }
}
