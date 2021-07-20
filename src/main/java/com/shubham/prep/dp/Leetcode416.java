package com.shubham.prep.dp;

public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return solve(nums, sum/2, 0);
    }

    private boolean solve(int[] nums, int sum, int idx) {
        if(sum == 0) return true;
        if(idx >= nums.length) return false;

        if(nums[idx] >= sum) {
            if(solve(nums, sum - nums[idx], idx+1)) {
                return true;
            }
        }
        return solve(nums, sum, idx + 1);
    }

    public static void main(String[] args) {

        Leetcode416 leetcode416 = new Leetcode416();
        System.out.println(leetcode416.canPartition(new int[]{1,5,11,5}));
    }
}
