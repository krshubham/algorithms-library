package com.shubham.prep.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode773 {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        seen.add(sb.toString());
        String destination = "123450";
        if(sb.toString().equals(destination)) {
            return 0;
        }
        List<List<Integer>> dirs = List.of(List.of(1,3), List.of(0,2,4),
                List.of(1,5), List.of(0,4), List.of(1,3,5), List.of(2,4));

        Queue<Pair<StringBuilder, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(sb, 0));

        while(!queue.isEmpty()) {
            var curr = queue.poll();
            sb = curr.first;
            int index = 0;
            for(int i = 0; i < 6; i++) {
                if(sb.charAt(i) == '0') {
                    index = i;
                    break;
                }
            }
            if(curr.first.toString().equals(destination)) {
                return curr.second;
            }
            for(var num: dirs.get(index)) {
                StringBuilder temp = new StringBuilder(sb);
                temp.setCharAt(index, sb.charAt(num));
                temp.setCharAt(num, '0');
                if(!seen.contains(temp.toString())) {
                    seen.add(temp.toString());
                    queue.add(new Pair<>(temp, curr.second + 1));
                }
            }
        }
        return -1;
    }

    private static class Pair<K,V> {
        K first;
        V second;
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Leetcode773 leetcode773 = new Leetcode773();
        System.out.println(leetcode773.slidingPuzzle(new int[][]{{1,2,3}, {5,4,0}}));
    }
}
