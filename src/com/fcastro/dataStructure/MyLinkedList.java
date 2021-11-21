package com.fcastro.dataStructure;

import java.util.ArrayList;
import java.util.List;

//Singly vs Doubly LinkedList
//Pro: Less memory and faster deletion
//Contra: Cannot be iterate backwards
public class MyLinkedList<T>{
    Node head;
    Node tail;
    int length;

    MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    MyLinkedList(T value){
        this.head = new Node(value, null);
        this.tail = this.head;
        this.length = 1;
    }

    //O(1)
    void append(T value){
        Node newNode = new Node(value, null);

        tail.next = newNode;
        tail = newNode;
        length++;
    }

    //O(1)
    void prepend(T value){
        Node newNode = new Node(value, head);
        head = newNode;
        length++;
    }

    //O(n)
    void insert(int index, T value){
        if (index < 0)
            return;

        if( index >= length){
            append(value);
            return;
        }

        //Traverse until index - 1, returning repointNode
        //NewNode.next points to repointNode.next
        //repointNode.next points to new node
        Node repointNode = traverse(index - 1);
        Node newNode = new Node(value, repointNode.next);
        repointNode.next = newNode;
        length++;
    }

    //O(n)
    void remove(int index){
        if (index < 0 || index >= length)
            return;

        Node repointNode = traverse(index - 1);
        Node removedNode = repointNode.next;
        repointNode.next = removedNode.next;
        removedNode.next = null;
        length--;
    }

    //O(n)
    T get(int index){
        if (index < 0 || index >= length)
            return null;

        return (T) traverse(index).value;
    }

    void reverse(Node head){
        Node previous = null;
        Node nextElement = null;
        Node current = head;
        while (current != null) {
            nextElement = current.next;
            current.next = previous;
            previous = current;
            current = nextElement;
        }
        this.head = tail;
        tail = previous;
    }


    private Node traverse(int index){
        Node currentNode = head;
        int i = 0;
        while(i != index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
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
        //{10}
        //{10, 5}
        //{10, 5, 16}
        //{1, 10, 5, 16}
        //{1, 10, 20, 5, 16}
        //{1, 10, 5, 16}
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        System.out.println(myLinkedList.printList());
        myLinkedList.append(5);
        System.out.println(myLinkedList.printList());
        myLinkedList.append(16);
        System.out.println(myLinkedList.printList());
        myLinkedList.prepend(1);
        System.out.println(myLinkedList.printList());
        myLinkedList.insert(2, 20);
        System.out.println(myLinkedList.printList());
        myLinkedList.remove(2);
        System.out.println(myLinkedList.printList());
        System.out.println("Value on index 1: "+ myLinkedList.get(1));

        MyLinkedList<Integer> reversedList = new MyLinkedList<>(1);
        reversedList.append(2);
        reversedList.append(3);
        System.out.println(reversedList.printList());
        reversedList.reverse(reversedList.head);
        System.out.println(reversedList.printList());
    }
}
