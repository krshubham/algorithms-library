package com.shubham.prep.dp;

import java.util.Arrays;

public class Leetcode516 {
    private int[][] dp = new int[1005][1005];
    public int longestPalindromeSubseq(String s) {
        for(int i = 0; i< 1005; i++) {
            Arrays.fill(dp[i],-1);
        }
        return solveRecursively(s, 0 , s.length()-1);

    }


    private int solveRecursively(String s, int start, int end) {
        if(start > end) {
            return 0;
        }
        if(start == end) {
            return 1;
        }
        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        if(s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = 2 + solveRecursively(s, start+1, end-1);
        }

        return dp[start][end] = Math.max(solveRecursively(s, start+1,end), solveRecursively(s, start, end-1));
    }

    public static void main(String[] args) {
        Leetcode516 leetcode516 = new Leetcode516();
        System.out.println(leetcode516.longestPalindromeSubseq("shubham"));
    }
}
