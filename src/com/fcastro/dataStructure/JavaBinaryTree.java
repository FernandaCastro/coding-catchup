package com.fcastro.dataStructure;

import java.util.*;

public class JavaBinaryTree {

    //TreeSetDemo
    void printTreeSet(boolean desc){

        Integer[] nums = {2,4,1,6,3,7,9,5};
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(nums));

        System.out.println("TreeSet Demo (desc: "+desc+") for given data {2,4,1,6,3,7,9,5}");

        if(desc)
            tree = (TreeSet<Integer>) tree.descendingSet();

        // Print first and last element
        System.out.println("First Element:" + tree.first());
        System.out.println("Last Element: "+ tree.last());

        System.out.println(printAll(tree));

        // False. Set does not allow duplicates, so this will not be added.
        System.out.println("Adding 1: " + tree.add(1));

        // But, this will be added because 11 is not a duplicate
        System.out.println("Adding 11: "+ tree.add(11));
        System.out.println(printAll(tree));

        System.out.println("HeadSet 7: " + printAll(tree.headSet(7)));
        System.out.println();
    }

    String printAll(SortedSet<Integer> tree){
        StringBuilder sBuilder = new StringBuilder("{");
        for(int e: tree){
            sBuilder.append(e).append(",");
        }
        return sBuilder.substring(0, sBuilder.length()-1) + "}";
    }

    void printTreeMap(boolean desc) {
        TreeMap<String, Double> treeMap = new TreeMap<>();

        treeMap.put("Paradise Lost", 23.56);
        treeMap.put("Golden Treasury", 12.47);
        treeMap.put("Moon and the Sixpence", 65.28);
        treeMap.put("Holinshed", 7.68);
        treeMap.put("Ancient Mariner", 45.36);

        printAll(treeMap);

        // Keys cannot be duplicates. This will not be stored.
        treeMap.put("Paradise Lost", 23.56);
        printAll(treeMap);

        // Values may be duplicates. This will be stored.
        treeMap.put("Paradise Regained", 23.56);
        printAll(treeMap);
    }

    void printAll(TreeMap<String, Double> treeMap){
        for(Map.Entry<String, Double> et:treeMap.entrySet()){
            System.out.println(et.getKey()+": "+et.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var demo = new JavaBinaryTree();
        demo.printTreeSet(false);
        demo.printTreeSet(true);
    }

}
