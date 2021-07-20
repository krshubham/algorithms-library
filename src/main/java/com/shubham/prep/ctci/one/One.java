package com.shubham.prep.ctci.one;

import java.util.Scanner;

/**
 * Implement the algorithm to determine if a string has all unique characters. What if you cannot use additional data
 * structures?
 */
public class One {
    public static void main(String[] args) {
        /*
        * Since, using a data structure is not allowed, we can have a 26 bit number and use its bits to check if the string
        * has all unique characters.
        * */

        int[] check = new int[128];


        String s = new Scanner(System.in).next();
        for(int i = 0; i < s.length(); i++) {
            if(check[s.charAt(i) - 'a'] == 0) {
                check[s.charAt(i) - 'a'] = 1;
            } else {
                System.out.println("Not unique, " + s.charAt(i) + " is repeated");
                break;
            }
        }
    }
}
