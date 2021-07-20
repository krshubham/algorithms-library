package com.shubham.prep.dp;

import java.util.Arrays;

public class Leetcode72 {
    private int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(word1, word2, m, n);
    }

    private int solve(String word1, String word2, int m, int n) {
        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }

        if(word1.charAt(m-1) == word2.charAt(n-1)) {
            return dp[m][n] = solve(word1, word2, m-1, n-1);
        }
        return dp[m][n] = 1 + Math.min(Math.min(solve(word1, word2, m-1, n), solve(word1, word2, m, n-1)), solve(word1, word2, m-1, n-1));
    }
}
