package com.shubham.prep.leetcode;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length-1;

        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[k--] = nums[left] * nums[left];
                left++;
            } else {
                result[k--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode977 leetcode977 = new Leetcode977();
        System.out.println(Arrays.toString(leetcode977.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
