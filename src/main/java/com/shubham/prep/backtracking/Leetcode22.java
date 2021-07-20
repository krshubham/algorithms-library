package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode22 {

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
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

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<Pair<String, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair<>("(", new Pair<>(1, 0)));
        while(!queue.isEmpty()) {
            var token = queue.poll();
            if(token.getKey().length() == 2*n) {
                if(token.getValue().getKey() == token.getValue().getValue()) {
                    System.out.println(token.getKey());
                    res.add(token.getKey());
                }
            } else {
                int left = token.getValue().getKey();
                int right = token.getValue().getValue();
                String s = token.getKey();
                if(left > right) {
                    if(left < n) {
                        queue.add(new Pair<>(s + '(', new Pair<>(left+1, right)));
                    }
                    queue.add(new Pair<>(s + ')', new Pair<>(left,right+1)));
                }
                else if(left == right) {
                    queue.add(new Pair<>(s + '(', new Pair<>(left+1, right)));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(3);
    }
}
