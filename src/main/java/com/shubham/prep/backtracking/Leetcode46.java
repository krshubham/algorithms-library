package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(res, nums, 0, nums.length-1);
        return res;
    }

    private void solve(List<List<Integer>> res, int[] nums, int left, int right) {
        if(left == right) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
        }
        for(int i = left; i<= right; i++) {
            swap(nums, left, right);
            solve(res,nums, left + 1, right);
            swap(nums, left, right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
