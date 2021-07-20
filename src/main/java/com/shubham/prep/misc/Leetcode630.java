package com.shubham.prep.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode630 {
    public int scheduleCourse(int[][] courses) {
        //Sort the courses by ending day, choose the one with less end day
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;
        int n = courses.length;
        for(int i = 0; i < n; i++) {
            if(time + courses[i][0] <= courses[i][1]) {
                heap.add(courses[i][0]);
                time += courses[i][0];
            } else if(!heap.isEmpty() && heap.peek() > courses[i][0]) {
                time += courses[i][0] - heap.poll();
                heap.add(courses[i][0]);
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        Leetcode630 leetcode630 = new Leetcode630();
        System.out.println(leetcode630.scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}}));
    }
}
