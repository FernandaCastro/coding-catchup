package com.fcastro.dataStructure;

import java.util.Arrays;

//Using Array
public class MyHashTable<K,V> {
    private Entry[][] table;
    private int[] size;

    MyHashTable(int size) {
        this.table = new Entry[size][];
        this.size = new int[size];
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
        var bucketSize = this.size[hash];

        //Separate Chains/Open Hashing - Array
        if ( bucket == null) {
            bucket = new Entry[4];
            bucketSize = 0 ;

        }else if (bucketSize >= (bucket.length*0.75)){
            bucket = Arrays.copyOf(bucket, bucket.length * 2);
        }

        bucket[bucketSize] = new Entry(key, value);
        table[hash] = bucket;
        this.size[hash] = ++bucketSize;
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
        K[] keys = (K[]) new Object[10];
        int size = 0;

        for (int i=0; i<table.length; i++){
            var bucket = table[i];
            if(bucket!=null){
                for(int j=0; j< bucket.length; j++){
                    var entry = bucket[j];

                    if (entry != null && entry.key != null) {
                        if (size >= (keys.length * 0.75))
                            keys = Arrays.copyOf(keys, keys.length * 2);

                        keys[size] = (K) entry.key;
                        size++;
                    }
                }
            }
        }
        return keys;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("MyHashTable{" +
                "data= [");
        for(int i = 0; i < this.table.length; i++){
            s.append("[");
            if (table[i]!=null ) {
                for (int j = 0; j < size[i]; j++) {
                    s.append(table[i][j]).append(", ");
                }
            }
            s.append("], ");
        }

        s.append('}');
        return s.toString();
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
        MyHashTable<String, Integer> o = new MyHashTable<>(10);
        o.set("apples", 6);
        o.set("oranges", 12);
        o.set("bananas", 8);
        o.set("grapes", 9);
        o.set("apples", 10);
        o.set("pears", 5);
        o.set("watermelon", 2);
        o.set("coconut", 3);
        o.set("pears", 8);
        o.set("watermelon", 4);
        o.set("bananas", 12);
        System.out.println("oranges= " + o.get("oranges"));
        System.out.println("apples= " + o.get("apples"));
        System.out.println(o);
        System.out.println("Keys: "+ Arrays.toString(o.keys()));
    }
}
