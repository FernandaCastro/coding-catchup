package com.fcastro.dataStructure;

//Using LinkedList
public class MyStack<T> {

    private Node top;
    private Node bottom;
    private int length;

    MyStack() {
        this.top = null;
        this.bottom = null;
        length = 0;
    }

    Node peek() {
        return top;
    }

    void push(T value) {
        var newNode = new Node(value);
        if (this.length == 0) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            var holdingPointer = this.top;
            this.top = newNode;
            this.top.next = holdingPointer;
        }
        this.length++;
    }

    Node pop() {
        if (this.top == null) {
            return null;
        }
        if (this.top == this.bottom) {
            this.bottom = null;
        }
        var holdingPointer = this.top;
        this.top = this.top.next;
        this.length--;
        return holdingPointer;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length +
                '}';
    }

    private class Node<T> {
        private T value;
        private Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("Google");
        myStack.push("Udemy");
        myStack.push("Discord");
        System.out.println("Peek: " + myStack.peek());
        System.out.println(myStack.toString());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("Pop: " + myStack.pop());
        System.out.println(myStack.toString());
    }
}
