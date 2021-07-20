package com.shubham.prep.leetcode.arrays;

/**
 * 41. First missing positive
 * The idea is to first move all the negative numbers towards the left sidea and then mark the present elements as
 * negative
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            /*while(nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }*/
            while (nums[i] >= 1 && nums[i] <= nums.length
                    && nums[i] != nums[nums[i] - 1]) {

                int temp=nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return (i+1);
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Leetcode41 leetcode41 = new Leetcode41();
        System.out.println(leetcode41.firstMissingPositive(new int[]{2,3,7,6,8,-1,-10,15}));
    }
}
