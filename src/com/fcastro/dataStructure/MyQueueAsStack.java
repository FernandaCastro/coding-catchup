package com.fcastro.dataStructure;

public class MyQueueAsStack <T> {

    private Node bottom;
    private Node top;
    private int size;

    public MyQueueAsStack(){
        this.bottom = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return (this.size==0);
    }

    public T peek(){
        if (isEmpty())
            return null;

        return (T) this.bottom.value;
    }

    public void push(T value){
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

    public T pop(){
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

    private class Node<T>{
        private T value;
        private Node next;

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

        System.out.println(myQueueAsStack);

        System.out.println("Peek: " + myQueueAsStack.peek());
        System.out.println("Pop: " + myQueueAsStack.pop());
        System.out.println("isEmpty: " + myQueueAsStack.isEmpty());

        System.out.println(myQueueAsStack);
    }
}
