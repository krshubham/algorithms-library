package com.shubham.prep.strings;

import java.util.Stack;

public class Leetcode1249 {
    public String minRemoveToMakeValid(String s) {
        s = s.replaceAll("\\)\\)", "}");
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(') {
                stack.push(i);
            }
            if(sb.charAt(i) == ')'){
                if(stack.isEmpty()) {
                    sb.setCharAt(i, '*');
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        Leetcode1249 leetcode1249 = new Leetcode1249();
        System.out.println(leetcode1249.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
