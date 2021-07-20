package com.shubham.prep.misc;

public class Calclines {

    private int solve(String s, int maxWidth) {
        String[] arr = s.split(" ");
        int count = 0;
        int currLength = 0;
        int includedWords = 0;
        int start = 0;
        while(true) {
            if(arr[start].length() > maxWidth) return -1; // maxWidth >= string length
            currLength += arr[start].length();
            includedWords++;
            if(includedWords > 1) {
                currLength++;
            }
            start++;
            if(currLength > maxWidth) {
                count++;
                currLength = 0;
                start--;
                includedWords = 0;
            }
            if(start >= arr.length) break;
        }
        if(currLength != 0) {
            return count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Calclines calclines = new Calclines();
        System.out.println(calclines.solve("Hello world this!", 5));
    }
}
