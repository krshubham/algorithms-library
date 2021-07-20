package com.shubham.prep.dp;

public class ShortestCommonSupersequence {

    private int scs(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length()+1];
        for(int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int  i = 0; i < text2.length(); i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text1.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                }
            }
        }
        /*for(int i = 0; i <= text1.length(); i++) {
            for(int j = 0; j <= text2.length(); j++) {
                if(dp[])
            }
            System.out.println();
        }*/
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args) {
        ShortestCommonSupersequence shortestCommonSupersequence = new ShortestCommonSupersequence();
        System.out.println(shortestCommonSupersequence.scs("shubham", "sam"));
    }
}
