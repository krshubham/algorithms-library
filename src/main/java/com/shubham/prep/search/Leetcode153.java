package com.shubham.prep.search;

public class Leetcode153 {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start < end) {
            int mid = start + (end-start)/2;

            if(nums[end] < nums[mid]) {
                start = mid+1;
            } else {
                end = mid;
            }

        }
        return nums[start];
    }

    public static void main(String[] args) {
        Leetcode153 leetcode153 = new Leetcode153();
        System.out.println(leetcode153.findMin(new int[]{1,2,3,4,5}));
        System.out.println(leetcode153.findMin(new int[]{5,1,2,3,4}));
        System.out.println(leetcode153.findMin(new int[]{4,5,1,2,3}));
        System.out.println(leetcode153.findMin(new int[]{3,4,5,1,2}));
        System.out.println(leetcode153.findMin(new int[]{2,3,4,5,1}));
        System.out.println(leetcode153.findMin(new int[]{1,2,3,4}));
        System.out.println(leetcode153.findMin(new int[]{4,1,2,3}));
        System.out.println(leetcode153.findMin(new int[]{3,4,1,2}));
        System.out.println(leetcode153.findMin(new int[]{2,3,4,1}));
    }
}
