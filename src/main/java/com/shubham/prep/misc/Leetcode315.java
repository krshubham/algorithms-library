package com.shubham.prep.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode315 {
    static class Pair {
        Integer first;
        Integer second;
        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        Pair[] arr = new Pair[nums.length];
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        int[] result = new int[n];
        merge(arr, res, 0, n-1, result);
        return Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
    }

    private void merge(Pair[] nums, List<Integer> res, int start, int end, int[] result) {
        if(start >= end) return;
        int mid = start + (end - start)/2;
        merge(nums, res, start, mid, result);
        merge(nums, res, mid+1, end, result);

        //Now is the place to merge the two sorted arrays
        int left = start;
        int right = mid + 1;
        List<Pair> merged = new LinkedList<>();
        int count = 0;

        while(left < mid + 1 && right <= end) {
            if(nums[left].first > nums[right].first) {
                //this is exactly what we want to find out
                ++count;
                merged.add(nums[right]);
                ++right;
            } else {
                result[nums[left].second] += count;
                merged.add(nums[left]);
                ++left;
            }
        }

        while(left < mid + 1) {
            result[nums[left].second] += count;
            merged.add(nums[left]);
            ++left;
        }
        while(right <= end) {
            merged.add(nums[right]);
            ++right;
        }

        int pos = start;
        for(var m: merged) {
            nums[pos++] = m;
        }
    }

    public static void main(String[] args) {
        Leetcode315 leetcode315 = new Leetcode315();
        leetcode315.countSmaller(new int[]{5,2,6,1});
    }
}
