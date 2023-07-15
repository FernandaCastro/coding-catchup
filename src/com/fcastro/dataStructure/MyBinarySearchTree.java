package com.fcastro.dataStructure;

import com.sun.source.tree.BinaryTree;

import java.util.*;

public class MyBinarySearchTree {

    Node root;

    MyBinarySearchTree(int value) {
        this.root = new Node(value);
    }

    void insert(int value) {
        Node currNode = this.root;
        Node newNode = new Node(value);

        while (currNode != null) {
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

    Node lookup(int value) {
        Node currNode = this.root;
        while (currNode != null) {

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

    void remove(int value) {
        if (this.root == null)
            return;

        Node currentNode = this.root;
        Node parentNode = null;
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;

            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;

            } else if (currentNode.value == value) {
                //A match!

                //Option 1: No right child:
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        this.root = currentNode.left;
                    } else {

                        //if parent > current value, make current left child a child of parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left;

                            //if parent < current value, make left child a right child of parent
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left;
                        }
                    }

                    //Option 2: Right child which doesn't have a left child
                } else if (currentNode.right.left == null) {
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        this.root = currentNode.right;
                    } else {

                        //if parent > current, make right child of the left the parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right;

                            //if parent < current, make right child a right child of the parent
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right;
                        }
                    }

                    //Option 3: Right child that has a left child
                } else {

                    //find the Right child's left most child
                    Node leftmost = currentNode.right.left;
                    Node leftmostParent = currentNode.right;
                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    //Parent's left subtree is now leftmost right subtree
                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;

                    if (parentNode == null) {
                        this.root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = leftmost;
                        }
                    }
                }
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "MyBinarySearchTree{" +
                "root=" + root +
                '}';
    }

    Node traverse(Node node) {
        Node tree = new Node(node.value);
        tree.left = node.left == null ? null : traverse(node.left);
        tree.right = node.right == null ? null : traverse(node.right);
        return tree;
    }

   /*
             9
        04        20
      01  06    15  170

     BFS: 9, 4, 20, 1, 6, 15, 170
    */
    void breadthFirstSearch(){
        Node currNode = this.root;
        List<Node> list = new ArrayList<>();
        List<Node> queue = new ArrayList<>();

        queue.add(currNode);
    }


    class Node {
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
        System.out.println(myBST);

        System.out.println("Lookup 15: " + myBST.lookup(15));
        System.out.println("Lookup 20: " + myBST.lookup(20));
        myBST.remove(20);

        var tree = myBST.traverse(myBST.root);
        System.out.println(tree);
    }
}
