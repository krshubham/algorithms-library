package com.shubham.youtube;

import java.util.Arrays;

public class DSU {

    private static class UnionFind {
        private final int capacity;
        private final int[] parent;
        private final int[] size; // union by rank

        public UnionFind(int n) {
            this.capacity = n;
            parent = new int[capacity];
            size = new int[capacity];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while(x != parent[x]) {
                parent[x] = parent[parent[x]]; // path compression
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int setX = find(x);
            int setY = find(y);
            if(setX != setY) {
                if(size[setX] > size[setY]) {
                    int temp = setX;
                    setX = setY;
                    setY = temp;
                }
                size[setX] += size[setY];
                parent[setY] = setX;
            }
        }

        public boolean areFriends(int x, int y) {
            return find(x) == find(y);
        }

        public int getSize() {
            return this.capacity;
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(100);
        unionFind.union(1,2);
        unionFind.union(2,4);
        unionFind.union(1,3);
        unionFind.union(7,5);
        unionFind.union(5,6);
        System.out.println(unionFind.areFriends(1,2));
        System.out.println(unionFind.areFriends(1,4));
        System.out.println(unionFind.areFriends(1,6));
        System.out.println(unionFind.areFriends(1,7));
        unionFind.union(1,7);
        System.out.println(unionFind.areFriends(1,7));
    }
}
