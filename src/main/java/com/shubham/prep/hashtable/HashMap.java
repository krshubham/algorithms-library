package com.shubham.prep.hashtable;


import java.util.ArrayList;
import java.util.Optional;

class HashNode<K,V> {
    private K key;
    private V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class HashMap<K,V> {

    private Integer slots = 20;
    private ArrayList<ArrayList<HashNode<K,V>>> list;

    public HashMap() {
        this.list = new ArrayList<>(slots);
        for(int i = 0; i < slots; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void put(K key, V value) {
        Integer index = hash(key);
        if(list.get(index) == null || list.get(index).size() == 0) {
            list.set(index, new ArrayList<>());
        }
        list.get(index).add(new HashNode<>(key, value));
    }

    public Optional<V> get(K key) {
        Integer index = hash(key);
        if(list.get(index) == null || list.get(index).size() == 0) {
            return Optional.empty();
        } else {
            for(HashNode<K,V> val: list.get(index)) {
                if(val.getKey() == key) {
                    return Optional.of(val.getValue());
                }
            }
        }
        return Optional.empty();
    }

    private Integer hash(K key) {
        return Math.abs(key.hashCode() % slots);
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Shubham",20);
        hashMap.put("Siddharth", 21);
        hashMap.get("Shubham").ifPresent(System.out::println);
        hashMap.get("abc").ifPresent(System.out::println);
    }
}



