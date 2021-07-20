package com.shubham.prep.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c: expression.toCharArray()) {
            if(c == '(' || c == '!' || c == '&' || c == '|' || c == 't' || c == 'f') {
                stack.push(c);
            }
            else if(c == ')') {
                List<Character> list = new ArrayList<>();
                while(stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                char operator = stack.pop();
                boolean res = list.get(0) == 't';
                if(operator == '!') {
                    stack.push(!res ? 't' : 'f');
                    continue;
                }
                for(int i = 1; i < list.size(); i++) {
                    if(operator == '&') {
                        res = res & (list.get(i) == 't');
                    } else if(operator == '|') {
                        res = res | (list.get(i) == 't');
                    }
                }
                stack.push(res ? 't' : 'f');
            }
        }
        return stack.pop() == 't';
    }

    public static void main(String[] args) {
        Leetcode1106 leetcode1106 = new Leetcode1106();
        System.out.println(leetcode1106.parseBoolExpr("&(t&(t))"));
    }
}
