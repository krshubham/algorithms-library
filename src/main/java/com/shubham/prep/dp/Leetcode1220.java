package com.shubham.prep.dp;

import java.util.List;

public class Leetcode1220 {
    private List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    private static final int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        int[][] dp = new int[20005][5];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % MOD;
                    dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
                    dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD;
                    dp[i][3] = dp[i-1][2] % MOD;
                    dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % MOD;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < 5; i++) {
            res += dp[n][i]%MOD;
        }
        return res%MOD;
    }

//    private int solve(int n, StringBuilder sb, char lastVowel) {
//        if(n == 0) {
//            return 1;
//        }
//        int ways = 0;
//        for(char vowel: vowels) {
//            if(lastVowel == 'a') {
//                if(vowel == 'e') {
//                    sb.append(vowel);
//                    ways += solve(n-1, new StringBuilder(sb), vowel)%MOD;
//                }
//            } else if(lastVowel == 'e') {
//                if(vowel == 'a' || vowel == 'i') {
//                    sb.append(vowel);
//                    ways += solve(n-1, new StringBuilder(sb), vowel)%MOD;
//                    sb.deleteCharAt(sb.length() - 1);
//                }
//            } else if(lastVowel == 'i') {
//                if(vowel != 'i') {
//                    sb.append(vowel);
//                    ways += solve(n-1, new StringBuilder(sb), vowel)%MOD;
//                    sb.deleteCharAt(sb.length() - 1);
//                }
//            } else if(lastVowel == 'o') {
//                if(vowel == 'i' || vowel == 'u') {
//                    sb.append(vowel);
//                    ways += solve(n-1, new StringBuilder(sb), vowel)%MOD;
//                    sb.deleteCharAt(sb.length()-1);
//                }
//            } else if(lastVowel == 'u') {
//                if(vowel == 'a') {
//                    sb.append(vowel);
//                    ways += solve(n-1, new StringBuilder(sb), vowel)%MOD;
//                }
//            }
//        }
//        return ways%MOD;
//    }

    public static void main(String[] args) {
        Leetcode1220 leetcode1220 = new Leetcode1220();
        System.out.println(leetcode1220.countVowelPermutation(50));
    }
}
