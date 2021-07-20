package com.shubham.prep.leetcode.heaps;

import java.util.*;

/**
 * Sliding Window Median
 */
public class Leetcode480 {

    private PriorityQueue<Double> right = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Double> left = new PriorityQueue<>();


    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int j = 0;
        for(int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        res[j++] = getMedian();
        for(int i = k; i < nums.length; i++) {
            remove(nums[i-k]);
            addNum(nums[i]);
            res[j++] = getMedian();
        }
        return res;
    }

    private void addNum(double num) {
        left.add(num);
        right.add(left.poll());
        while(left.size() < right.size()) {
            left.add(right.poll());
        }
    }

    private boolean remove(double num) {
        return left.remove(num) || right.remove(num);
    }

    private double getMedian() {
        return left.size() > right.size() ? left.peek() : (left.peek() + right.peek())/2.0;

    }

    public static void main(String[] args) {
        Leetcode480 leetcode480 = new Leetcode480();
        double[] res = leetcode480.medianSlidingWindow(new int[]{5,2,2,7,3,7,9,0,2,3}, 9);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
