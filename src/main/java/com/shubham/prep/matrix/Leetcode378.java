package com.shubham.prep.matrix;

import java.util.PriorityQueue;

public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Value> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < n; i++) {
            heap.add(new Value(matrix[i][0], 0, i));
        }
        int count = 0;
        int row = 0, index = 0;
        while(count < k && !heap.isEmpty()) {
            Value curr = heap.poll();
            row = curr.row;
            index = curr.index;
            if(index < n-1) {
                heap.add(new Value(matrix[row][index+1], index+1, row));
            }
            count++;
        }
        return matrix[row][index];
    }

    private static class Value {
        int val;
        int index;
        int row;

        public Value(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }
}
