package com.fcastro.dataStructure;

//Singly vs Doubly LinkedList
//Pro: Backwards traverse
//Contra: Requires more memory
public class MyDoublyLinkedList <T>{

    Node head;
    Node tail;
    int length;

    MyDoublyLinkedList(T value){
        head = new Node(value, null, null);
        tail = head;
        length = 1;
    }

    //O(1)
    void prepend(T value){
        Node newNode = new Node(value, null, head);
        head.prev = newNode;
        head = newNode;
        length++;
    }

    //O(1)
    void append(T value){
        Node newNode = new Node(value, tail, null);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    //O(n)
    void insert(int index, T value){
        if (index < 0)
            return;

        if (index >= length) {
            append(value);
            return;
        }

        //null <-- 1 <--> 2 <--> 3 --> null
        //null <-- 1 <--> 2 <--> 4 <--> 3 -->
        Node indexNode = traverse(index);
        Node newNode = new Node(value, indexNode.prev, indexNode);
        Node previousNode = indexNode.prev;

        previousNode.next = newNode;
        indexNode.prev = newNode;
        length++;
    }

    //null <-- 1 <--> 2 <--> 4 <--> 3 --> null
    //null <-- 1 <--> 2 <--> 3 --> null
    void remove(int index){
        if (index < 0 || index >= length)
            return;

        Node removedNode = traverse(index);
        Node previousNode = removedNode.prev;
        Node nextNode = removedNode.next;

        previousNode.next = removedNode.next;
        nextNode.prev = removedNode.prev;

        removedNode.prev = null;
        removedNode.next = null;
        length--;
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
        StringBuilder string = new StringBuilder("Length: " + length + " {");
        Node node  = head;
        while(node != null){
            string.append(node.value).append(", ");
            node = node.next;
        }
        string.append("} ");

        string.append("Backwards: {");
        node  = tail;
        while(node != null){
            string.append(node.value).append(", ");
            node = node.prev;
        }
        string.append("}");
        return string.toString();
    }


    class Node <T>{
        T value;
        Node prev;
        Node next;

        Node(T value, Node prev, Node next){
            this.value = value;
            this. prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //{2}
        //{1, 2}
        //{1, 2, 3}
        //{1, 2, 4, 3}
        //{1, 2, 3}
        MyDoublyLinkedList<Integer> myDoublyLinkedList = new MyDoublyLinkedList<>(2);
        System.out.println(myDoublyLinkedList.printList());
        myDoublyLinkedList.prepend(1);
        System.out.println(myDoublyLinkedList.printList());
        myDoublyLinkedList.append(3);
        System.out.println(myDoublyLinkedList.printList());
        myDoublyLinkedList.insert(2, 4);
        System.out.println(myDoublyLinkedList.printList());
        myDoublyLinkedList.remove(2);
        System.out.println(myDoublyLinkedList.printList());
    }

}
