package com.shubham.prep.leetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find median of a running stream
 */
public class Leetcode295 {

    static class MedianFinder {

        private PriorityQueue<Double> right = new PriorityQueue<>();
        private PriorityQueue<Double> left = new PriorityQueue<>(Collections.reverseOrder());
        private double median;

        /** initialize your data structure here. */
        public MedianFinder() {
        }

        public void addNum(int num) {
            if(left.isEmpty()) {
                left.add((double) num);
                median = num;
            } else {
                if(left.size() > right.size()) {
                    if(num > median) {
                        right.add((double) num);
                    } else {
                        right.add(left.poll());
                        left.add((double) num);
                    }
                    median = (right.peek() + left.peek())/2.0;
                } else if(left.size() < right.size()) {
                    if(num < median) {
                        left.add((double) num);
                    } else {
                        left.add(right.poll());
                        right.add((double) num);
                    }
                    median = (right.peek() + left.peek())/2.0;
                } else {
                    if(num > median) {
                        right.add((double) num);
                        median = right.peek();
                    } else {
                        left.add((double) num);
                        median = left.peek();
                    }
                }
            }

        }

        public double findMedian() {
            return median;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
    }
}
