package com.fcastro.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/************************
 Implement the Undirected, unweighted, cyclic graph below:

 3 --- 4 --- 5
 |     |     |
 1 --- 2     6
 \   /
   0

 Using Adjacent List represented by HashTable
 //Containing:
 // 0-->1 2
 // 1-->3 2 0
 // 2-->4 1 0
 // 3-->1 4
 // 4-->3 2 5
 // 5-->4 6
 // 6-->5
 *************************/
public class MyGraph {

    private int numberOfNodes;
    private HashMap<Character, List<Character>> adjacentList;


    public MyGraph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    private void addNode(Character node) {
        this.adjacentList.put(node, new ArrayList<>());
        this.numberOfNodes++;
    }

    private void addEdge(Character node1, Character node2) {
        //undirected Graph
        var vertex = this.adjacentList.get(node1);
        vertex.add(node2);
        vertex = this.adjacentList.get(node2);
        vertex.add(node1);
    }

    private String showConnections() {
        StringBuilder concatConnections = new StringBuilder();
        var allNodes = this.adjacentList.keySet();
        for (Character node : allNodes) {
            var nodeConnections = this.adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            if(nodeConnections!=null) {
                for (Character edge : nodeConnections) {
                    connections.append(edge).append(" ");
                }
            }
            concatConnections.append("\n").append(node).append("--> ").append(connections);
        }
        return concatConnections.toString();
    }


    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        myGraph.addNode('0');
        myGraph.addNode('1');
        myGraph.addNode('2');
        myGraph.addNode('3');
        myGraph.addNode('4');
        myGraph.addNode('5');
        myGraph.addNode('6');
        myGraph.addEdge('3', '1');
        myGraph.addEdge('3', '4');
        myGraph.addEdge('4', '2');
        myGraph.addEdge('4', '5');
        myGraph.addEdge('1', '2');
        myGraph.addEdge('1', '0');
        myGraph.addEdge('0', '2');
        myGraph.addEdge('6', '5');

        System.out.println(myGraph.showConnections());
    }
}
