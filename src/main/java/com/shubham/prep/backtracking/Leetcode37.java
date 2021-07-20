package com.shubham.prep.backtracking;

public class Leetcode37 {
    private boolean check(char[][] board, int row, int col, char num) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int boxSize = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % boxSize;
        int boxColStart = col - col % boxSize;

        for (int i = boxRowStart; i < boxRowStart + boxSize; i++) {
            for (int j = boxColStart; j < boxColStart + boxSize; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        _helper(board);
    }

    private boolean _helper(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(check(board, i, j, k)) {
                            board[i][j] = k;
                            if(_helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode37 leetcode37 = new Leetcode37();
        char[][] board = new char[][]{{'.', '6', '.', '.', '9', '.', '.', '1', '.'}
                , {'.', '.', '4', '8', '.', '7', '6', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '2'},
                {'4', '1', '.', '.', '8', '.', '.', '6', '5'}, {'.', '.', '.', '9', '.', '6', '.', '.', '.'},
                {'5', '9', '.', '.', '2', '.', '.', '8', '7'}, {'1', '.', '.', '.', '.', '.', '.', '.', '8'},
                {'.', '.', '5', '1', '.', '8', '7', '.', '.'}, {'.', '2', '.', '.', '7', '.', '.', '3', '.'}};
        leetcode37.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
