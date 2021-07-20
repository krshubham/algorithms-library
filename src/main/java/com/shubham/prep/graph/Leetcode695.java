package com.shubham.prep.graph;

public class Leetcode695 {
    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
    int ans = 0;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(grid, i , j, visited, 0);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int size) {
        for(var dir: directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != 1) continue;
            visited[x][y] = true;
            ans = Math.max(ans, size);
            dfs(grid, x, y, visited, size + 1);
        }
    }

}
