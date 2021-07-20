package com.shubham.prep.graph;

import java.util.ArrayList;
import java.util.List;

public class Leetcode207 {
    private int[] visited = new int[100005];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses+2; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(isCycle(graph, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(List<List<Integer>> graph, int course) {
        if(visited[course] == 1) {
            return true;
        }
        if(visited[course] == 0) {
            visited[course] = 1;
            for(var child: graph.get(course)) {
                if(isCycle(graph, child)) {
                    return true;
                }
            }
        }
        visited[course] = 2;
        return false;
    }

    public static void main(String[] args) {
        Leetcode207 leetcode207 = new Leetcode207();
        System.out.println(leetcode207.canFinish(2, new int[][]{}));
    }
}
