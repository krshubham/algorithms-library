package com.shubham.prep.leetcode.arrays;

public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row_0 = false;
        boolean col_0 = false;
        for(int i = 0; i < m; i++) {
            for(int j =  0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        row_0 = true;
                    }
                    if(j == 0) {
                        col_0 = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row_0) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(col_0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode73 leetcode73 = new Leetcode73();
        int[][] matrix = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        leetcode73.setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
