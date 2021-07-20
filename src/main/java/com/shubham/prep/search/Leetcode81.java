package com.shubham.prep.search;

public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if(nums.length == 1) {
            return nums[0] == target;
        }
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            }
            if(nums[start] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }

            if(nums[end] >= nums[mid]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode81 leetcode81 = new Leetcode81();
    }
}
