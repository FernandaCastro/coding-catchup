package com.fcastro.dataStructure;

public class MyLinkedList<T>{
    Node head;
    Node tail;
    int length;

    MyLinkedList(T value){
        this.head = new Node(value, null);
        this.tail = this.head;
        this.length = 1;
    }

    void append(T value){
        Node newNode = new Node(value, null);

        tail.next = newNode;
        tail = newNode;
        length++;
    }

    void prepend(T value){
        Node newNode = new Node(value, head);
        head = newNode;
        length++;
    }

    void insert(int index, T value){
        //1 -> 10 -> 5 -> 16
        //insert (2, 20) = {1, 10, 20, 5, 16}
        //Node = head
        //loop i<index and keeping node=node.next
        //NewNode.next points to node.next
        //node.next points to new node
        Node node = head;
        int i = 1;
        while(i<index){
            node = node.next;
            i++;
        }
        Node newNode = new Node(value, node.next);
        node.next = newNode;
    }

    String printList(){
        String string = "{";
        Node node  = head;
        while(node != null){
            string +=  node.value + ", ";
            node = node.next;
        }
        string += "}";
        return string;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    class Node<T>{
        T value;
        Node next;

        Node(T value, Node next){
            this.value = value;
            this.next = next;
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
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        myLinkedList.append(5);
        myLinkedList.append(16);
        myLinkedList.prepend(1);
        myLinkedList.insert(2, 20);
        System.out.println(myLinkedList.printList());
    }
}
