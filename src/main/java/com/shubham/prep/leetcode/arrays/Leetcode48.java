package com.shubham.prep.leetcode.arrays;

public class Leetcode48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n/2; j++) {
                swap(matrix[i], n-j-1, j);
            }
        }
    }
    private void swap(int[] A,int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode48 leetcode48 = new Leetcode48();
        int[][] matrix = new int[][]{{1, 2, 3,4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        leetcode48.rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
