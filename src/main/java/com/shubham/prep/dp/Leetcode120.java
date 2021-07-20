package com.shubham.prep.dp;

import java.util.Arrays;
import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        Arrays.fill(dp, triangle.get(0).get(0));
        int m = triangle.size();
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < m; i++) {
            for(int j = i; j >= 0; j--) {
                if(j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else if(j == i) {
                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                }
                else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        System.out.println(leetcode120.minimumTotal(List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3))));
    }
}
