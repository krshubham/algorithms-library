package com.shubham.prep.dp;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        int max = startFuel;
        for(var station : stations) {
            while(max < station[0]) {
                if(heap.isEmpty()) return -1;
                max += heap.poll();
                res++;
            }
            heap.add(station[1]);
        }

        while(max < target) {
            if(heap.isEmpty()) return -1;
            max += heap.poll();
            res++;
        }
        return res;
    }
}
