package com.shubham.prep.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        long end = points[0][1];
        if(points == null || points.length == 0) {
            return 0;
        }
        int cnt = 1;
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= end) {
                end = Math.min(points[i][1], end);
            } else {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Leetcode452 leetcode452 = new Leetcode452();
        System.out.println(leetcode452.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
}
