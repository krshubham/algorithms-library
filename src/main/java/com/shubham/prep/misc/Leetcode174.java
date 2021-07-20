package com.shubham.prep.misc;

public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);

        for(int i = m-2; i >=0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int i = n-2; i >=0; i--) {
            dp[m-1][i] = Math.max(1, dp[m-1][i+1] - dungeon[m-1][i]);
        }

        for(int i = m-2; i >= 0; i--) {
            for(int j = m-2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Leetcode174 leetcode174 = new Leetcode174();
      /*  System.out.println(leetcode174.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));*/
        System.out.println(leetcode174.calculateMinimumHP(new int[][]{
                {100, -100},
                {-100, -100}
        }));
    }
}
