package com.shubham.prep.leetcode.heaps;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Leetcode502 {
    private final PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    private final PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        for(int i = 0; i < profits.length; i++) {
            minHeap.add(new Integer[]{capital[i], profits[i]});
        }
        System.out.println(Objects.requireNonNull(minHeap.peek())[0] + "," + minHeap.peek()[1]);
        while(k-- > 0) {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.add(new Integer[]{minHeap.peek()[0], minHeap.poll()[1]});
            }
            if(!maxHeap.isEmpty()) {
                w += maxHeap.poll()[1];
            } else break;
        }
        return w;
    }

    public static void main(String[] args) {
        Leetcode502 leetcode502 = new Leetcode502();
        System.out.println(leetcode502.findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}));
    }
}
