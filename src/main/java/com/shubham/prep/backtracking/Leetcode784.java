package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        solve(res, s.toCharArray(), 0);
        return res;
    }

    private void solve(List<String> res, char[] s, int start) {
        if(start == s.length) {
            res.add(new String(s));
            return;
        }
        if(Character.isLetter(s[start])) {
            s[start] = toggleCase(s[start]);
            solve(res, s, start+1);
            s[start] = toggleCase(s[start]);
        }
        solve(res, s, start+1);
    }

    private char toggleCase(char c) {
        if(Character.isUpperCase(c)) {
            return Character.toLowerCase(c);
        } else {
            return Character.toUpperCase(c);
        }
    }

    public static void main(String[] args) {
        Leetcode784 leetcode784 = new Leetcode784();
        List<String> res = leetcode784.letterCasePermutation("abc");
        System.out.println(res);
    }
}
