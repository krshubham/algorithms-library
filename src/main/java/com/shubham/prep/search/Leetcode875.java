package com.shubham.prep.search;

import java.util.Arrays;

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(possible(mid, h, piles)) {
                ans = Math.min(mid, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean possible(int k, int h, int[] piles) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            count += Math.ceil((double)piles[i]/(double)k);
        }
        return count <= h;
    }

    public static void main(String[] args) {
        Leetcode875 leetcode875 = new Leetcode875();
        System.out.println(leetcode875.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
