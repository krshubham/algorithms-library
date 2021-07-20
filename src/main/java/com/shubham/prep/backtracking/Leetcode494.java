package com.shubham.prep.backtracking;

public class Leetcode494 {
    private int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        solve(nums, target, sum, 0);
        return ans;
    }

    private void solve(int[] nums, int target, int sum, int start) {
        if(sum == target) {
            ans++;
            return;
        }
        for(int i = start; i < nums.length; i++) {
            nums[i] = -nums[i];
            solve(nums, target, sum + 2*nums[i], i+1);
            nums[i] = -nums[i];
        }
    }

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        System.out.println(leetcode494.findTargetSumWays(new int[]{1},1));
    }
}
