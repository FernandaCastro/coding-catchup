package com.fcastro.dataStructure;

import java.util.Arrays;

//Using LinkedList
public class MyHashTable2<K,V> {
    private final Entry<K, V>[] table;

    MyHashTable2(int size) {
        this.table = new Entry[size];
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
        var entry = table[hash];

        //Separate Chains/Open Hashing - LinkedList
        if ( entry == null) {
            entry = new Entry(key, value, null);
            table[hash] = entry;

        }else if (entry.next == null) {
            var newEntry = new Entry(key, value, null);
            entry.next = newEntry;

        }else{
            var tail = entry.next;
            while(tail != null){
                tail = tail.next;
            }
            var newEntry = new Entry(key, value, null);
            tail.next = newEntry;
        }

    }

    public V get(K key){
        int hash = hash(key);
        var entry = table[hash];

        if (entry != null) {
            if (entry.next == null)
                return entry.value;

            var bucket = entry;
            while (bucket != null) {
                if (bucket.key == key)
                    return bucket.value;
                bucket = bucket.next;
            }
        }
        return null;
    }

    public K[] keys(){
        K[] keys = (K[]) new Object[]{};

        for (int i=0; i<table.length; i++){
            var entry = table[i];

            if(entry!=null){
                keys = Arrays.copyOf(keys, keys.length + 1);
                keys[keys.length - 1] = entry.key;

                if (entry.next != null) {
                    var bucket = entry.next;
                    while (bucket != null){
                        keys = Arrays.copyOf(keys, keys.length + 1);
                        keys[keys.length - 1] = bucket.key;
                        bucket = bucket.next;
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
            var entry = table[i];
            s.append("[");
            if (entry != null ) {
                if (entry.next == null){
                    s.append(entry.key).append(":").append(entry.value);
                }else{
                    s.append(entry.key).append(":").append(entry.value);
                    var bucket = entry.next;
                    while (bucket != null){
                        s.append(", ").append(bucket.key).append(":").append(bucket.value);
                        bucket = bucket.next;
                    }
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
        Entry<K,V> next;

        Entry(K key, V value, Entry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashTable2<String, Integer> o = new MyHashTable2<>(15);
        o.set("apples", 6);
        o.set("oranges", 12);
        o.set("bananas", 8);
        o.set("grapes", 9);
        o.set("apples", 10);
        System.out.println("oranges= " + o.get("oranges"));
        System.out.println("apples= " + o.get("apples"));
        System.out.println(o);
        System.out.println(Arrays.toString(o.keys()));
    }
}
