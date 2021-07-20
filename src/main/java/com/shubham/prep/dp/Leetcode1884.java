package com.shubham.prep.dp;

import java.util.HashMap;

public class Leetcode1884 {
    HashMap<String,Integer> dp = new HashMap<>();
    public int twoEggDrop(int n) {
        return solve(2, n);
    }

    private int solve(int k, int n) {
        if(k == 1) return n;
        if(n <= 0) return 0;

        String key = k + "|" + n;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int broken = solve(k-1, i-1);
            int not_broken = solve(k, n-i);
            res = Math.min(res,Math.max(broken, not_broken) + 1);
        }
        dp.put(key, res);
        return res;

    }

    public static void main(String[] args) {
        Leetcode1884 leetcode1884 = new Leetcode1884();
        System.out.println(leetcode1884.twoEggDrop(10));
    }
}
