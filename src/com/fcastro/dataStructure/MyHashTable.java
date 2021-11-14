package com.fcastro.dataStructure;

import java.util.Arrays;

public class MyHashTable<K,V> {
    private Entry[][] table;

    MyHashTable(int size) {
        this.table = new Entry[size][];
    }

    private int hash(K key){
        int hash = 0;
        int length = ((String) key).length();
        for(int i = 0; i < length; i++){
            hash = (hash + ((String) key).charAt(i) * i) % table.length;
        }
        return hash;
    }

    public void set(K key, V value){
        int hash = hash(key);
        var bucket = table[hash];

        //Separate Chains/Open Hashing
        if ( bucket == null)
            bucket = new Entry[]{};

        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = new Entry(key, value);
        table[hash] = bucket;
    }

    public V get(K key){
        int hash = hash(key);
        var bucket = table[hash];
        if (bucket != null) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i].key == key) {
                    return (V) bucket[i].value;
                }
            }
        }
        return null;
    }

    public K[] keys(){
        K[] keys = (K[]) new Object[]{};

        for (int i=0; i<table.length; i++){
            var bucket = table[i];
            if(bucket!=null){
                for(int j=0; j< bucket.length; j++){
                    var entry = bucket[j];

                    keys = Arrays.copyOf(keys, keys.length + 1);
                    keys[keys.length - 1] = (K) entry.key;
                }
            }
        }
        return keys;
    }

    @Override
    public String toString() {
        String s =  "MyHashTable{" +
                "data= [" ;
        for(int i = 0; i < this.table.length; i++){
            s += "[";
            if (table[i]!=null ) {
                for (int j = 0; j < table[i].length; j++) {
                    s += table[i][j].toString() + ", ";
                }
            }
            s += "], ";
        }

        s += '}';
        return s;
    }

    private class Entry<K, V>{
        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "<" + key + ", " + value + ">";
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> o = new MyHashTable<>(15);
        o.set("apples", 6);
        o.set("oranges", 12);
        o.set("bananas", 8);
        o.set("grapes", 9);
        o.set("apples", 10);
        System.out.println("oranges= " + o.get("oranges"));
        System.out.println("apples= " + o.get("apples"));
        System.out.println(o.toString());
        System.out.println(Arrays.toString(o.keys()));
    }
}
