package com.shubham.prep.dp;

public class Leetcode5 {
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            String oddPalindrome = expand(s, i, i);
            if(maxLen < oddPalindrome.length()) {
                maxLen = oddPalindrome.length();
                ans = oddPalindrome;
            }
            String evenPalindrome = expand(s, i, i+1);
            if(maxLen < evenPalindrome.length()) {
                maxLen = evenPalindrome.length();
                ans = evenPalindrome;
            }
        }
        return ans;
    }

    private String expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;j++;
        }
        return s.substring(i+1, j);
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome("babad"));
    }
}
