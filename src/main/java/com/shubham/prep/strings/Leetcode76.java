package com.shubham.prep.strings;

public class Leetcode76 {

    public String minWindow(String s, String t) {
        int count = 0;
        int[] counts = new int[150];
        int n = s.length();

        for(char ch: t.toCharArray()) {
            if(counts[ch - 'A'] == 0) {
                count++;
            }
            counts[ch - 'A']++;
        }

        int right = 0;
        int left = 0;

        int res = Integer.MAX_VALUE;
        int startIndex = -1;

        while(right < n) {
            counts[s.charAt(right) - 'A']--;
            if(counts[s.charAt(right) - 'A'] == 0) {
                count--;
            }
            if(count == 0) {//found all the characters
                while(count == 0) {
                    int size = right - left + 1;
                    if(res > size) {
                        res = size;
                        startIndex = left;
                    }
                    counts[s.charAt(left) - 'A']++;
                    if(counts[s.charAt(left) - 'A'] > 0) {
                        count++;
                    }
                    left++;
                }
            }
            right++;
        }
        System.out.println(res);
        System.out.println(startIndex);
        return "";
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        System.out.println(leetcode76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
