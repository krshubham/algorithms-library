package com.shubham.prep.dp;

public class CoinChange {
    public int numWays(int amount, int[] denominations) {
        return solve(amount, denominations, 0);
    }

    private int solve(int amount, int[] denominations, int currIndex) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0 || currIndex >= denominations.length) {
            return 0;
        }
        int ans = 0;
            ans += solve(amount-denominations[currIndex], denominations, currIndex)
                    + solve(amount, denominations, currIndex+1);
        return ans;
    }
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.numWays(2, new int[]{1,4,3,2}));
    }
}
