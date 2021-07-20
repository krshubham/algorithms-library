package com.shubham.prep.leetcode;

import java.util.Arrays;

public class Leetcode75 {
    public void sortColors(int[] nums) {

        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        while(mid <= end) {
            if(nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode75 leetcode75 = new Leetcode75();
        leetcode75.sortColors(new int[]{2,0,2,1,1,0});

    }
}
