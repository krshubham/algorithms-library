package com.shubham.prep.misc;

import java.util.Arrays;

public class RedundantConnections {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
         parent = new int[edges.length + 1];
         size = new int[edges.length + 1];
        for(int i = 0; i < edges.length + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(var edge: edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);
            if(a == b) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return null;
    }

    private int find(int v) {
        if(parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            if(size[a] < size[b]) {
                int temp = size[a];
                size[a] = size[b];
                size[b] = temp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }

    public static void main(String[] args) {
        RedundantConnections redundantConnections = new RedundantConnections();
        System.out.println(Arrays.toString(redundantConnections.findRedundantConnection(new int[][]{{1,2},{1,3}, {2,3}})));
    }
}
