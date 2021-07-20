package com.shubham.prep.misc;

public class Leetcode1657 {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m != n) return false;
        int[] counts = new int[26];
        for(int i = 0; i < m; i++) {
            counts[word1.charAt(i) - 'a']++;
            counts[word2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(counts[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode1657 leetcode1657 = new Leetcode1657();
        System.out.println(leetcode1657.closeStrings("cabbba", "abbccc"));
    }
}
