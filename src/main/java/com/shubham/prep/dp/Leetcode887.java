package com.shubham.prep.dp;

import java.util.HashMap;

public class Leetcode887 {

    private final HashMap<String, Integer> dp = new HashMap<>();

    public int superEggDrop(int k, int n) {
        if(k == 1) return n;
        if(n == 0) return 0;
        String key = k + "|" + n;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int lo = 1, hi = n;
        int res = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int broken = superEggDrop(k-1, mid-1);
            int not_broken = superEggDrop(k, n-mid);
            if(broken > not_broken) {
                hi = mid-1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid+1;
                res = Math.min(res, not_broken+1);
            }
        }
        dp.put(key, res);
        return res;
    }
    public static void main(String[] args) {
        Leetcode887 leetcode887 = new Leetcode887();
        System.out.println(leetcode887.superEggDrop(2, 2));
    }
}
