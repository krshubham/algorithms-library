package com.shubham.prep.misc;

import java.util.Arrays;

public class Leetcode983 {
    private int[] dp = new int[2000];
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, -1);
        int n = days.length;
        int res = solve(days, costs, 0);
        return res;
    }

    private int solve(int[] days, int[] costs, int idx) {
        if(idx == days.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        int ans = solve(days, costs, idx + 1) + costs[0];
        int j = idx;
        while (j < days.length && days[j] < days[idx] + 7) ++j;
        ans = Math.min(ans, solve(days, costs, j) + costs[1]);
        while (j < days.length && days[j] < days[idx] + 30) ++j;
        ans = Math.min(ans, solve(days, costs, j) + costs[2]);
        return dp[idx] = ans;

    }

    public static void main(String[] args) {
        Leetcode983 leetcode983 = new Leetcode983();
        System.out.println(leetcode983.mincostTickets(new int[]{1,4,6, 7, 8, 20}, new int[]{2,7,15}));
    }
}
