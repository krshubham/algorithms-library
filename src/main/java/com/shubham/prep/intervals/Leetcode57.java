package com.shubham.prep.intervals;

import java.util.Arrays;

public class Leetcode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length+1][2];
        int i = 0;
        int k = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[k][0] = intervals[i][0];
            res[k++][1] = intervals[i][1];
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[k][0] = newInterval[0];
        res[k++][1] = newInterval[1];
        while(i < intervals.length) {
            res[k][0] = intervals[i][0];
            res[k++][1] = intervals[i][1];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode57 leetcode57 = new Leetcode57();
        System.out.println(Arrays.toString(leetcode57.insert(new int[][]{{1,3}, {6,9}}, new int[]{2,5})));
    }
}