package com.shubham.prep.strings;

import java.util.Stack;

public class Leetcode921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    res++;
                }
            }
        }
        while(!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;

    }

    public static void main(String[] args) {
        Leetcode921 leetcode921  = new Leetcode921();
        System.out.println(leetcode921.minAddToMakeValid("()))(("));
    }
}
