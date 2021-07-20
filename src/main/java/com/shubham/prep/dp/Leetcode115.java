package com.shubham.prep.dp;

import java.util.Arrays;

public class Leetcode115 {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length() + 2;
        int n = t.length() + 2;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        if(m < n) return 0;
        return solve(s, t, 0, 0);
    }

    private int solve(String s, String t, int si, int ti) {
        if(si >= s.length()) return 0;
        if(dp[si][ti] != -1) return dp[si][ti];
        if(ti == t.length()) {
            return 1;
        }
        int ways = 0;
        if(s.charAt(si) == t.charAt(ti)) {
            ways += solve(s, t, si + 1, ti + 1) + solve(s,t, si, ti + 1);
        } else {
            ways += solve(s, t, si + 1, ti);
        }
        return dp[si][ti] = ways;
    }

    public static void main(String[] args) {
        Leetcode115 leetcode115 = new Leetcode115();
        System.out.println(leetcode115.numDistinct("rabbbit", "rabbit"));
    }
}
