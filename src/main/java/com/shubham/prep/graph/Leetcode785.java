package com.shubham.prep.graph;

import java.util.TreeMap;

public class Leetcode785 {
    private boolean[] visited = new boolean[150];
    private int[] colors = new int[150];
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        for(int i = 0; i < n; i++) {
            System.out.println(visited[i] + " : " + i);
            if(!visited[i]) {
                visited[i] = true;
                if(!dfs(graph, i,0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int curr, int color) {
        for(int child: graph[curr]) {
            if(!visited[child]) {
                visited[child] = true;
                if(!dfs(graph, child, color-1)) {
                    return false;
                }
            } else {
                TreeMap treeMap = new TreeMap();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode785 leetcode785 = new Leetcode785();
        leetcode785.isBipartite(new int[][]{{1,3}, {0,2}, {1,3}, {0,2}});
    }
}
