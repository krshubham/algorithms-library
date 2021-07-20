package com.shubham.prep.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

    public static void main(String[] args) {
        Leetcode435 leetcode435 = new Leetcode435();
        leetcode435.eraseOverlapIntervals(new Interval[]{new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,3)});
    }
}
