package com.shubham.prep.search;

public class Leetcode162 {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start  + (end-start)/2;
            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Leetcode162 leetcode162 = new Leetcode162();
        System.out.println(leetcode162.findPeakElement(new int[]{1,2,3,4,5}));
        System.out.println(leetcode162.findPeakElement(new int[]{5,1,2,3,4}));
        System.out.println(leetcode162.findPeakElement(new int[]{4,5,1,2,3}));
        System.out.println(leetcode162.findPeakElement(new int[]{3,4,5,1,2}));
        System.out.println(leetcode162.findPeakElement(new int[]{2,3,4,5,1}));
        System.out.println(leetcode162.findPeakElement(new int[]{1,2,3,4}));
        System.out.println(leetcode162.findPeakElement(new int[]{4,1,2,3}));
        System.out.println(leetcode162.findPeakElement(new int[]{3,4,1,2}));
        System.out.println(leetcode162.findPeakElement(new int[]{2,3,4,1}));
    }
}
