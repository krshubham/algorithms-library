package com.shubham.prep.search;

public class Leetcode33 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < mid) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if(nums[mid] <= nums[end]) {
                if(target <= nums[end] && target > mid) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Leetcode33 leetcode33 = new Leetcode33();
        System.out.println(leetcode33.search(new int[]{7,1,2,3,4,5,6}, 7));
    }
}
