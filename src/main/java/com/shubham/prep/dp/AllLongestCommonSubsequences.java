package com.shubham.prep.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllLongestCommonSubsequences {

    private List<String> getAllStrings(String text1, String text2, int[][] dp, int m, int n) {
        if(m == 0 || n == 0) {
            return new ArrayList<>(Collections.nCopies(1, ""));
        }
        if(text1.charAt(m-1) == text2.charAt(n-1)) {
            List<String> lcs = getAllStrings(text1, text2, dp, m-1, n-1);
            for(int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + text1.charAt(m-1));
            }
            return lcs;
        }
        if(dp[m-1][n] > dp[m][n-1]) {
            return getAllStrings(text1, text2, dp, m-1,n);
        }
        if(dp[m-1][n] < dp[m][n-1]) {
            return getAllStrings(text1, text2, dp, m,n-1);
        }

        List<String> top = getAllStrings(text1, text2, dp, m - 1, n);
        List<String> left = getAllStrings(text1, text2, dp, m , n - 1);

        top.addAll(left);

        return top;
    }

    private List<String> findAllLCS(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = 0; i < text1.length()+1; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < text2.length()+1; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return getAllStrings(text1, text2, dp, text1.length(), text2.length());
    }

    public static void main(String[] args) {
        AllLongestCommonSubsequences allLongestCommonSubsequences = new AllLongestCommonSubsequences();
        allLongestCommonSubsequences.findAllLCS("shubham", "sam")
                .forEach(System.out::println);
    }
}
