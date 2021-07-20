package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode17 {
    private String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < Math.min(1, digits.length()) ; i++) {
            int index = digits.charAt(i) - '0';
            for (int j = 0; j < letters[index].length(); j++) {
                queue.add(Character.toString(letters[index].charAt(j)));
            }
        }
        int start = 1;
        while (!queue.isEmpty()) {
            String token = queue.poll();
            if (token.length() == digits.length()) {
                System.out.println(token);
                res.add(token);
            } else {
                if (token.length() >= start) {
//                    System.out.println("Yes");
                    start++;
                }
                if (start < digits.length()) {
                    int index = digits.charAt(start) - '0';
                    for (int i = 0; i < letters[index].length(); i++) {
                        queue.add(token + letters[index].charAt(i));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        leetcode17.letterCombinations("234");
    }
}
