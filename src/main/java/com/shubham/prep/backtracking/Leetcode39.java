package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
    }

    private void solve(int[] nums, int target, int currSum,List<Integer> curr, List<List<Integer>> res, int idx) {
        if(currSum > target) {
            return;
        }
        else if(currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        } else {
            for(int i = idx; i < nums.length; i++) {
                if(currSum + nums[i] <= target) {
                    curr.add(nums[i]);
                    solve(nums, target, currSum + nums[i], curr, res, i);
                    curr.remove(curr.size() - 1);
                }
            }

        }
    }

    public static void main(String[] args) {
        Leetcode39 leetcode39 = new Leetcode39();
        List<List<Integer>> list = leetcode39.combinationSum(new int[]{2,3,6,7}, 7);
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
