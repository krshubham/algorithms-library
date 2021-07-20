package com.shubham.prep.misc;

import java.util.Arrays;
import java.util.Objects;

public class Leetcode208 {
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
