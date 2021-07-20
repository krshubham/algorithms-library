package com.shubham.prep.stack;

import java.util.List;
import java.util.Stack;

public class Leetcode227 {
    public int calculate(String s) {
        //The basic idea is to first take the string and convert it into postfix notation
        //Then we need to evaluate the postfix notation
        String postFix = convert(s);
        int result = eval(postFix);
        System.out.println(postFix);
        System.out.println(result);
        return result;
    }

    private int eval(String postFix) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < postFix.length(); i++) {
            if(postFix.charAt(i) == '.') {
                stack.push(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            } else if(isNumber(postFix.charAt(i))) {
                sb.append(postFix.charAt(i));
            }
            else if(isOperator(postFix.charAt(i))) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(command(first, second, postFix.charAt(i)));
            }
        }
        return stack.pop();
    }

    private int command(int first, int second, char operator) {
        if (operator == '*') {
            return first*second;
        } else if(operator == '/') {
            return second/first;
        } else if(operator == '-') {
            return second - first;
        } else if(operator == '+') {
            return second + first;
        }
        throw new IllegalArgumentException("Invalid operator");
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        StringBuilder res = new StringBuilder();
        char[] expression = s.toCharArray();
        for(int i = 0; i < expression.length; i++) {
            sb.setLength(0);
            if(isNumber(expression[i])) {
                int start = i;
                while(start < expression.length && isNumber(expression[start])) {
                    sb.append(expression[start]);
                    start++;
                }
                sb.append('.');//to mark the end of the number, so its easier while processing it.
                res.append(sb);
                i = start-1;
            } else if(expression[i] == ' ') {
                //do nothing
            }
            else if(isOperator(expression[i])) {
                if(stack.isEmpty()) {
                    stack.push(expression[i]);
                } else {
                    while(!stack.isEmpty() && priority(expression[i]) < priority(stack.peek())) {
                        res.append(stack.pop());
                    }
                    stack.push(expression[i]);
                }
            }
        }
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private int priority(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 2;
            case '/':
                return 4;
            case '*':
                return 3;
        }
        throw new IllegalArgumentException("The operator is illegal");
    }

    private boolean isOperator(char operator) {
        boolean result = List.of('+', '-', '*', '/').stream()
                .anyMatch(character -> character == operator);
        if(!result) {
            throw new IllegalArgumentException("The operator is illegal");
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode227 leetcode227 = new Leetcode227();
            leetcode227.calculate("0-2147483647");
    }
}
