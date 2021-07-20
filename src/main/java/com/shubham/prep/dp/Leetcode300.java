package com.shubham.prep.dp;

import java.util.*;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for(var num: nums) {
            int i = Arrays.binarySearch(res, 0, len, num);
            if(i < 0) {
                i = -(i+1);
            }
            res[i] = num;
            if(i == len) {
                len++;
            }
        }
        return len;
    }
}
