package com.shubham.prep.graph;

import java.util.*;

public class Leetcode743 {
    private static class Pair<K,V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //Straightforward shortest path algorithm implementation
        //Dijkstra's algorithm
        List<List<Pair<Integer,Integer>>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++) {
            int x = times[i][0];
            int y = times[i][1];
            int w = times[i][2];
            graph.get(x).add(new Pair<>(y,w));
        }
        PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        heap.add(new Pair<>(k, 0));
        Map<Integer, Integer> distance = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(k, 0);
        while(!heap.isEmpty()) {
            Pair<Integer, Integer> curr = heap.poll();
            for(var child: graph.get(curr.first)) {
                if(distance.get(child.first) > curr.second + child.second) {
                    distance.put(child.first, curr.second + child.second);
                    heap.add(new Pair<>(child.first, curr.second + child.second));
                }
            }
        }
        boolean unreachable = distance.entrySet().stream().anyMatch(a -> a.getValue() == Integer.MAX_VALUE);
        if(unreachable) return -1;
        return distance.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();
    }

    public static void main(String[] args) {
        Leetcode743 leetcode743 = new Leetcode743();
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,8}, {1,4,5}};
        leetcode743.networkDelayTime(times, 4, 2);
    }
}
