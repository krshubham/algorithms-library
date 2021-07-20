package com.shubham.prep.stack;

import java.util.Stack;

public class Leetcode1717 {
    public int maximumGain(String s, int x, int y) {
        String toRemove,later;
        if(x > y) {
            toRemove = "ab";
            later = "ba";
        } else {
            toRemove = "ba";
            later = "ab";
        }
        int score = 0;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= 2) {
                char second = stack.pop();
                if (second == toRemove.charAt(1)) {
                    char first = stack.pop();
                    if(first != toRemove.charAt(0)) {
                        stack.push(first);
                        stack.push(second);
                    } else {
                        score += Math.max(x,y);
                    }
                } else {
                    stack.push(second);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        for(char c: sb.toString().toCharArray()) {
            stack.push(c);
            if (stack.size() >= 2) {
                char second = stack.pop();
                if (second == later.charAt(1)) {
                    char first = stack.pop();
                    if(first != later.charAt(0)) {
                        stack.push(first);
                        stack.push(second);
                    } else {
                        score += Math.min(x,y);
                    }
                } else {
                    stack.push(second);
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Leetcode1717 leetcode1717 = new Leetcode1717();
        System.out.println(leetcode1717.maximumGain("cdbcbbaaabab", 4, 5));
    }
}
