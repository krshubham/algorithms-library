package com.shubham.prep.misc;

import java.util.HashMap;

public class Leetcode146 {

    private static class LRUCache {

        private static class Entry {
            int val;
            int key;
            Entry left;
            Entry right;
        }

        private Entry head,tail;
        private HashMap<Integer, Entry> cache = new HashMap<>();
        private int size;

        public LRUCache(int capacity) {
            size = capacity;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)) {
                Entry entry = cache.get(key);
                entry.val = value;
                removeNode(entry);
                addToFront(entry);
            } else {
                Entry entry = new Entry();
                entry.val = value;
                entry.key = key;
                if(cache.size() == size) {
                    cache.remove(tail.key);
                    removeNode(tail);
                    addToFront(entry);
                } else {
                    addToFront(entry);
                    cache.put(key, entry);
                }
                cache.put(key, entry);
            }
        }

        public int get(int key) {
            if(cache.containsKey(key)) {
                Entry entry = cache.get(key);
                removeNode(entry);
                addToFront(entry);
                return entry.val;
            } else {
                return -1;
            }
        }

        private void removeNode(Entry entry) {
            if(entry.left != null) {
                entry.left.right = entry.right;
            } else {
                head = entry.right;
            }
            if(entry.right != null) {
                entry.right.left = entry.left;
            } else {
                tail = entry.left;
            }
        }

        private void addToFront(Entry entry) {
            entry.right = head;
            entry.left = null;
            if(head != null) {
                head.left = entry;
            }
            head = entry;
            if(tail == null) {
                tail = entry;
            }
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
