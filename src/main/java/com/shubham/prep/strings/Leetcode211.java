package com.shubham.prep.strings;

public class Leetcode211 {

    static class Trie {
        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean end;
        }

        private final TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode temp = root;
            for(char c: word.toCharArray()) {
                if(temp.children[c-'a'] == null) {
                    temp.children[c-'a'] = new TrieNode();
                }
                temp = temp.children[c-'a'];
            }
            temp.end = true;
        }

        boolean search(String string) {
            char[] word = string.toCharArray();
            return dfs(word, 0, root);
        }

        private boolean dfs(char[] word, int index, TrieNode root) {
            if(root == null && index < word.length) return false;
            if(word[index] == '.') {
                if(index == word.length - 1) {
                    for(int j = 0; j < 26; j++) {
                        if(root.children[j] != null && root.children[j].end) {
                            return true;
                        }
                    }
                } else {
                    for(int j = 0; j < 26; j++) {
                        if(root.children[j] != null) {
                            if(dfs(word, index+1, root.children[j])) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                if(index == word.length - 1) {
                    return root.children[word[index] - 'a'] != null && root.children[word[index] - 'a'].end;
                }
                else return dfs(word, index + 1, root.children[word[index] - 'a']);
            }
            return false;
        }
    }
    static class WordDictionary {
        private final Trie trie;
        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.addWord(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
