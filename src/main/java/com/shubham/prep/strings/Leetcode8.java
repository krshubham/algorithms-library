package com.shubham.prep.strings;

public class Leetcode8 {
    public int myAtoi(String s) {
        s.trim();
        StringBuilder sb = new StringBuilder();
        int multiplier = 1;
        if(s.charAt(0) == '-') {
            multiplier = -1;
        }

        int num = 0;
        int power = 1;
        if(s.charAt(0) != '-') {
            for(int i = s.length()-1; i >= 0; i--) {
                num = num + (s.charAt(i) - '0')*power;
                power = power*10;
            }
        } else {
            for(int i = s.length()-1; i >= 1; i--) {
                num = num + (s.charAt(i) - '0')*power;
                power *= 10;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Leetcode8 leetcode8 = new Leetcode8();
        leetcode8.myAtoi("42");
    }
}
