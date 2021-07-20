package com.shubham.prep.dp;

public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            ans = Math.max(ans,sum);
        }
        return Math.max(ans, sum);
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        System.out.println(leetcode53.maxSubArray(new int[]{-1,-2,-3}));
    }
}
