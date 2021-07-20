package com.shubham.prep.dp;

import java.util.List;

public class ZeroOneKnapsack {
    private int maxProfit(List<Integer> weights, List<Integer> profits, int capacity) {
        return solve(weights, profits, capacity, 0);
    }

    private int solve(List<Integer> weights, List<Integer> profits, int capacity, int currIndex) {
        if(currIndex >= weights.size() || capacity <= 0) {
            return 0;
        }
        int ans1 = 0;
        if(weights.get(currIndex) <= capacity) {
            ans1 = profits.get(currIndex) + solve(weights, profits,
                    capacity - weights.get(currIndex), currIndex+1);
        }
        int ans2 = solve(weights, profits, capacity, currIndex+1);
        return Math.max(ans1, ans2);
    }


    public static void main(String[] args) {
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        System.out.println(zeroOneKnapsack.maxProfit(List.of(1, 2, 3, 5),List.of(1, 6, 10, 16), 7));
    }
}
