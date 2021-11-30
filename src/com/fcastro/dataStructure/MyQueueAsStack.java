package com.fcastro.dataStructure;

import java.util.Deque;
import java.util.Stack;

public class MyQueueAsStack <T> {

    Node bottom;
    Node top;
    int size;

    MyQueueAsStack(){
        this.bottom = null;
        this.top = null;
        this.size = 0;
    }

    boolean isEmpty(){
        return (this.size==0);
    }

    T peek(){
        if (isEmpty())
            return null;

        return (T) this.bottom.value;
    }

    void push(T value){
        Node newNode = new Node(value);
        if (isEmpty()){
            this.bottom = newNode;
            this.top = this.bottom;
        }else{
            this.top.next = newNode;
            this.top = newNode;
        }
        this.size++;
    }

    T pop(){
        if (isEmpty())
            return null;

        if (this.bottom == this.top)
            this.top = null;

        Node popped = this.bottom;

        this.bottom = this.bottom.next;
        this.size--;

        return (T)popped.value;
    }

    @Override
    public String toString() {
        return "MyQueueAsStack{" +
                "bottom=" + bottom +
                ", top=" + top +
                ", size=" + size +
                '}';
    }

    class Node<T>{
        T value;
        Node next;

        Node(T value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "<" +
                    value +
                    ", next=" + next +
                    '>';
        }
    }

    public static void main(String[] args) {
        MyQueueAsStack myQueueAsStack = new MyQueueAsStack();
        myQueueAsStack.push(1);
        myQueueAsStack.push(2);

        System.out.println(myQueueAsStack.toString());

        System.out.println("Peek: " + myQueueAsStack.peek());
        System.out.println("Pop: " + myQueueAsStack.pop());
        System.out.println("isEmpty: " + myQueueAsStack.isEmpty());

        System.out.println(myQueueAsStack.toString());
    }
}
