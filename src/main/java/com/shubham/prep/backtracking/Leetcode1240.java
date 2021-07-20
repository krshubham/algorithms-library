package com.shubham.prep.backtracking;

public class Leetcode1240 {
    private boolean[][] visited;
    private int ans = Integer.MAX_VALUE;
    private int n,m;
    public int tilingRectangle(int n, int m) {
        visited = new boolean[n][m];
        this.n = n;
        this.m = m;
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int r, int c, int cnt) {
        if (cnt >= ans) return;

        // Successfully cover the whole rectangle
        if (r >= n) {
            ans = cnt;
            return;
        }

        // Successfully cover the area [0, ..., n][0, ..., c] => Move to next row
        if (c >= m) {
            dfs(r+1, 0, cnt);
            return;
        }

        // If (r, c) is already covered => move to next point (r, c+1)
        if (visited[r][c]) {
            dfs(r, c+1, cnt);
            return;
        }

        // Try all the possible size of squares starting from (r, c)
        for (int k = Math.min(n-r, m-c); k >= 1 && isAvailable(r, c, k); k--) {
            cover(r, c, k);
            dfs(r, c+1, cnt+1);
            uncover(r, c, k);
        }
    }

    private boolean isAvailable(int row, int col, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                if(visited[row+i][col + j]) return false;
            }
        }
        return true;
    }

    private void cover(int row, int col, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                visited[i+row][j + col] = true;
            }
        }
    }
    private void uncover(int row, int col, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                visited[i+row][j + col] = false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode1240 leetcode1240 = new Leetcode1240();
        System.out.println(leetcode1240.tilingRectangle(2,3));
    }
}
