package com.shubham.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {

    /*public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, board, n, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] board, int n, int row) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Q') {
                    cnt++;
                }
            }
        }
        if(cnt == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for(int i = row; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    if(isValid(board, i, j, n)) {
                        board[i][j] = 'Q';
                        solve(res, board,n, i+1);
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for(int i = 0; i < n; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i >=0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i < n && j >= 0; i++,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i < n && j < n; i++, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j=col; i >= 0 && j < n; i--,j++ ) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
*/

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(res,board,n,0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] board, int n, int row) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Q') {
                    cnt++;
                }
            }
        }
        if(cnt == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for(int i = row; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    if(isValid(board,i,j, n)) {
                        board[i][j] = 'Q';
                        solve(res, board, n,row+1);
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i >=0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i < n && j >= 0; i++,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j = col; i < n && j < n; i++, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i = row, j=col; i >= 0 && j < n; i--,j++ ) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        System.out.println(leetcode51.solveNQueens(9).size());
    }
}
