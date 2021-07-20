package com.shubham.interviews.google;

public class MaximumCoinsGrid {
    public int maxCoins(int[][] grid) {
        return solve(grid, 0, 0);
    }

    private int solve(int[][] grid, int row, int col) {
        return 0;
    }

    public static void main(String[] args) {
        MaximumCoinsGrid maximumCoinsGrid = new MaximumCoinsGrid();
        System.out.println(maximumCoinsGrid.maxCoins(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        }));
    }
}
