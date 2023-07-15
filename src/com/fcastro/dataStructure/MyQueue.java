package com.fcastro.dataStructure;

public class MyQueue <T>{
    Node first;
    Node last;
    int length;

    MyQueue(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    T peek(){
        return (T) this.first.value;
    }

    void enqueue(T value){
        Node newNode = new Node(value);
        if(length==0){
            this.first = newNode;
            this.last = this.first;
        }else {
            this.last.next = newNode;
            this.last = newNode;
        }

        this.length++;
    }

    T dequeue(){
        if(this.length==0){
            return null;
        }
        if (this.first == this.last) {
            this.last = null;
        }
        Node dequeued = this.first;
        this.first = dequeued.next;
        this.length--;

        return (T) dequeued.value;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }

    class Node <T>{
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
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("Joy");
        myQueue.enqueue("Matt");
        myQueue.enqueue("Pavel");
        myQueue.enqueue("Samir");
        System.out.println(myQueue);
        System.out.println("Peek: " + myQueue.peek());
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue);
    }
}
