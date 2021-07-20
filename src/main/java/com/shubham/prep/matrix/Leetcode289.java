package com.shubham.prep.matrix;

public class Leetcode289 {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0,-1}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};


    //O(mn) time uses O(mn) space
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        //Duplicating the matrix and then using this to compute the future generation
        int[][] dup = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dup[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int alive = 0;
                for(int k = 0; k < 8; k++) {
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if(x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (dup[x][y] == 1) {
                        alive++;
                    }
                }
                if(dup[i][j] == 1) {
                    if(alive < 2) {
                        board[i][j] = 0;
                    } else if(alive > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if(alive == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public void solveMemoryEfficient(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] > 0) {
                    for(int k = 0; k < 8; k++) {
                        int x = i + directions[k][0];
                        int y = j + directions[k][1];
                        if(x < 0 || y < 0 || x >= m|| y >= n) continue;
                        if(board[x][y] > 0) {
                            board[i][j]++;
                        }
                    }
                } else {
                    for(int k = 0; k < 8; k++) {
                        int x = i + directions[k][0];
                        int y = j + directions[k][1];
                        if(x < 0 || y < 0 || x >= m|| y >= n) continue;
                        if(board[x][y] > 0) {
                            board[i][j]--;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0;j < n; j++) {
                if(board[i][j] > 0) {
                    if(board[i][j] < 3) {
                        board[i][j] = 0;
                    } else if(board[i][j] <= 4) {
                        board[i][j] = 1;
                    } else if(board[i][j] > 4) {
                        board[i][j] = 0;
                    }
                } else {
                    if(board[i][j] == -3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Leetcode289 leetcode289 = new Leetcode289();
        int[][] board = new int[][]{
                {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        leetcode289.gameOfLife(board);
    }
}
