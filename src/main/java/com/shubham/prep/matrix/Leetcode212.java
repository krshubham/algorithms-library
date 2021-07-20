package com.shubham.prep.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Leetcode212 {
    private static class Trie {

        private TrieNode root;

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
            private boolean end;
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp = root;
            for(char c: word.toCharArray()) {
                if(temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.end = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode temp = root;
            for(char c: word.toCharArray()) {
                if(temp.children[c - 'a'] == null) return false;
                temp = temp.children[c - 'a'];
            }
            return temp.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for(char c: prefix.toCharArray()) {
                if(temp.children[c - 'a'] == null) return false;
                temp = temp.children[c - 'a'];
            }
            if(temp.end) return true;
            return Arrays.stream(temp.children).anyMatch(Objects::nonNull);
        }
    }

    private boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(var word: words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        List<String> res = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                dfs(board, i , j, trie, "", res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i , int j, Trie trie, String str, List<String> res) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if(visited[i][j]) return;

        if(!trie.startsWith(str)) return;

        str += board[i][j];
        if(trie.search(str)) {
            res.add(str);
        }

        visited[i][j] = true;
        dfs(board, i+1, j, trie, str, res);
        dfs(board, i-1, j, trie, str, res);
        dfs(board, i, j+1, trie, str, res);
        dfs(board, i, j-1, trie, str, res);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Leetcode212 leetcode212 = new Leetcode212();
        leetcode212.findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"})
                .forEach(System.out::println);
    }
}
