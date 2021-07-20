package com.shubham.prep.dp;

import java.util.Arrays;

public class Leetcode1143 {

    private int[][] dp = new int[1005][1005];


    public int longestCommonSubsequence(String text1, String text2) {
        for(int i = 0; i < 1005; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < 1005; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < 1005; i++) {
            dp[0][i] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(sb);
        return dp[text1.length()][text2.length()];
    }

    private int solve(String text1, String text2, int len1, int len2) {
        if(len1 <= 0 || len2 <= 0) {
            return 0;
        }

        if(dp[len1][len2] != -1) {
            return dp[len1][len2];
        }

        if(text1.charAt(len1-1) == text2.charAt(len2-1)) {
            return dp[len1][len2] = 1 + solve(text1, text2, len1-1, len2-1);
        }
        return dp[len1][len2] = Math.max(solve(text1, text2, len1-1, len2), solve(text1, text2, len1, len2-1));
    }

    public static void main(String[] args) {
        Leetcode1143 leetcode1143 = new Leetcode1143();
        System.out.println(leetcode1143.longestCommonSubsequence("shubham", "smahbm"));
    }

}
