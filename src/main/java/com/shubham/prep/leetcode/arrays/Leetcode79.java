package com.shubham.prep.leetcode.arrays;


public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m;i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && search(board, word,m, n,i,j,new boolean[m+1][n+1], 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int m, int n, int i, int j, boolean[][] visited, int index) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return false;
        visited[i][j] = true;
        boolean done = search(board, word, m, n, i+1, j, visited, index+1)
                || search(board, word, m, n, i-1, j, visited, index+1)
                || search(board, word, m, n, i, j+1, visited, index+1)
                || search(board, word, m, n, i, j-1, visited, index+1);
        if(done) return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Leetcode79 leetcode79 = new Leetcode79();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(leetcode79.exist(board, "ABCCED"));
    }
}
