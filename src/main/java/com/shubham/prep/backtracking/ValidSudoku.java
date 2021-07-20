package com.shubham.prep.backtracking;

import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
    public int isValidSudoku(final List<String> A) {
        //Check row wise if any number is duplicate
        for(int i = 0; i < A.size(); i++) {
            HashSet<Character> seen = new HashSet<>();
            for(char c: A.get(i).toCharArray()) {
                if(c != '.') {
                    if(seen.contains(c)) {
                        return 0;
                    } else {
                        seen.add(c);
                    }
                }
            }
        }

        for(int i = 0; i < A.size(); i++) {
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < A.size(); j++) {
                char c = A.get(j).charAt(i);
                if(c != '.') {
                    if(seen.contains(c)) {
                        return 0;
                    } else {
                        seen.add(c);
                    }
                }
            }
        }
        int row_start = 0;
        int col_start = 0;
        while(true) {
            HashSet<Character> seen = new HashSet<>();
            for(int i = row_start; i < row_start + 3; i++) {
                for(int j = col_start; j < col_start + 3; j++) {
                    char c = A.get(i).charAt(j);
                    if(c != '.') {
                        if(seen.contains(c)) {
                            return 0;
                        } else {
                            seen.add(c);
                        }
                    }
                }
            }
            col_start += 3;
            if(col_start >= 9) {
                col_start = 0;
                row_start  += 3;
                if(row_start >= 9) {
                    break;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
