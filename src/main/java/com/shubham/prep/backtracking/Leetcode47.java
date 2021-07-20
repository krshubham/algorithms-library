package com.shubham.prep.backtracking;

import java.util.*;

public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        solve(count, n, res, new LinkedList<>());
        return res;
    }

    private void solve(HashMap<Integer, Integer> count, int n, List<List<Integer>> res, LinkedList<Integer> temp) {
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(entry.getValue() == 0) continue;
            temp.addLast(entry.getKey());
            int cnt = entry.getValue();
            count.put(entry.getKey(), cnt - 1);
            solve(count, n, res, temp);
            temp.removeLast();
            count.put(entry.getKey(), cnt);
        }
    }

    public static void main(String[] args) {
        Leetcode47 leetcode47 = new Leetcode47();
        var res = leetcode47.permuteUnique(new int[]{1,1,2});
        System.out.println(res);
    }
}
