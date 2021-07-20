package com.shubham.prep.misc;

public class Recursion {
    static int fun(int n) {
        if(n > 100) {
            return n - 10;
        } else {
            return fun(fun(n + 11));
        }
    }
    public static void main(String[] args) {
        System.out.println(fun(95));
    }
}
