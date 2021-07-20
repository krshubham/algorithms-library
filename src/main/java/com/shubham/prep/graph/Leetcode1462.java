package com.shubham.prep.graph;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1462 {
    private int[] parent;
    private int[] size;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        parent = new int[numCourses+2];
        size = new int[numCourses+2];
        for(int i = 0; i <= numCourses; i++) {
            parent[i] = -1;
            size[i] = 1;
        }

        int n = prerequisites.length;
        for(int i = 0; i < n; i++) {
            int course = prerequisites[i][0];
            int dep = prerequisites[i][1];
            union(course, dep);
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            int a = query[0];
            int b = query[1];
            if(find(a) == find(b)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    private int find(int a) {
        if(parent[a] == -1) {
            return -1;
        }
        if(a == parent[a]) {
            return a;
        }
        return find(parent[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {

        Leetcode1462 leetcode1462 = new Leetcode1462();
        leetcode1462.checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{1,0}, {0,1}})
                .forEach(System.out::println);
    }
}
