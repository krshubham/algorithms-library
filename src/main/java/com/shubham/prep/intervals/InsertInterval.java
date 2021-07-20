package com.shubham.prep.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);

        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length+1][2];
        int i = 0;
        int k = 0;
        for(var interval: intervals) {
            if(interval[1] < newInterval[0]) {
                res[k++] = interval;
            } else if(interval[0] > newInterval[1]) {
                res[k++] = newInterval;
                newInterval = interval;
            } else if(interval[0] <= newInterval[1] || interval[1] >= newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res[k++] = newInterval;
        return Arrays.copyOfRange(res, 0, k);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        /*insertInterval.insert(List.of(new Interval(1,2), new Interval(3,5), new Interval(6,7),
                new Interval(8,10), new Interval(12, 16)), new Interval(4, 9));*/

        insertInterval.insert(new int[][]{{3,5}, {8,10}}, new int[]{1,12});

    }
}
