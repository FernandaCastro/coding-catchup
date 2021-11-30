package com.fcastro.dataStructure;

import com.sun.source.tree.BinaryTree;

import java.util.Comparator;
import java.util.TreeSet;

public class MyBinarySearchTree {

    Node root;

    MyBinarySearchTree(int value){
        this.root = new Node(value);
    }

    void insert(int value){
        Node currNode = this.root;
        Node newNode = new Node(value);

        while(currNode!=null) {
            if (value == currNode.value)
                return;

            if (value > currNode.value) {
                if (currNode.right == null) {
                    currNode.right = newNode;
                    return;
                }
                currNode = currNode.right;

            } else {
                if (currNode.left == null) {
                    currNode.left = newNode;
                    return;
                }
                currNode = currNode.left;
            }
        }
    }

    Node lookup(int value){
        Node currNode = this.root;
        while(currNode!=null ) {

            if (value == currNode.value)
                return currNode;

            if (value > currNode.value) {
                currNode = currNode.right;

            } else {
                currNode = currNode.left;
            }
        }
        return null;
    }

    void remove(int value){
        Node currNode = this.root;
        Node prevNode = null;

        while(currNode!=null) {
            prevNode = currNode;

            if (value == currNode.value)
                break;

            if (value > currNode.value) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }

        if(currNode==null)
            return;

        //It is a leaf
        if (currNode.left==null && currNode.right==null){
            if (value > prevNode.value)
                prevNode.right = null;
            else
                prevNode.left = null;
            return;
        }
        //It has 1 child
        if (currNode.left != null && (currNode.left.left == null && currNode.left.right == null)){

        }

    }

    @Override
    public String toString() {
        return "MyBinarySearchTree{" +
                "root=" + root +
                '}';
    }

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "<" +
                    value +
                    ", left=" + left +
                    ", right=" + right +
                    '>';
        }
    }

    /*
                9
           04      20
         01  06  15  170
     */
    public static void main(String[] args) {
        MyBinarySearchTree myBST = new MyBinarySearchTree(9);
        myBST.insert(4);
        myBST.insert(6);
        myBST.insert(20);
        myBST.insert(170);
        myBST.insert(15);
        myBST.insert(1);
        System.out.println(myBST.toString());

        System.out.println("Lookup 15: " + myBST.lookup(15));
        System.out.println("Lookup 20: " + myBST.lookup(20));
    }
}
