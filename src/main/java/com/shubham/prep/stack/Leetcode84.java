package com.shubham.prep.stack;

import java.util.Stack;

public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int res = 0;
        int i = 0;
        for(i = 0;i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                int curr = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[curr] * i;
                } else {
                    area = heights[curr] * ( i - stack.peek() + 1);
                }
                res = Math.max(res, area);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - heights[stack.peek()] + 1);
            }
            res = Math.max(res, area);
        }

        return res;
    }
}
