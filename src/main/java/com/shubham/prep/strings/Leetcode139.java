package com.shubham.prep.strings;

import java.util.HashSet;
import java.util.List;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, new HashSet<>(wordDict));
    }

    private boolean solve(String s, HashSet<String> dict) {
        if(s.length() == 0) return true;
        for(int i = 0; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if(dict.contains(prefix) && solve(s.substring(i), dict)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Leetcode139 leetcode139 = new Leetcode139();
        System.out.println(leetcode139.wordBreak("leetcode", List.of("l", "e", "e", "t", "c", "o","d","e")));
    }
}
