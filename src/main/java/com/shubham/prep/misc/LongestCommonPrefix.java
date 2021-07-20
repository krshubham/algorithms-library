package com.shubham.prep.misc;

import java.util.List;

public class LongestCommonPrefix {
    private static class TrieNode {
        TrieNode[] children;
        boolean end;

        public TrieNode() {
            this.children = new TrieNode[150];
            this.end = false;
        }
    }
    public String longestCommonPrefix(List<String> A) {
        TrieNode root = new TrieNode();
        for(String str: A) {
            insert(root, str);
        }
        StringBuilder sb = new StringBuilder();
        return walk(root, sb);
    }

    private String walk(TrieNode root, StringBuilder sb) {
        int count = 0;
        int next = 0;
        boolean end = false;
        for(int i = 0; i < 150; i++) {
            if(root.children[i] != null) {
                count++;
                next = i;
                if(root.children[i].end) {
                    end = true;
                }
            }
        }
        if(end) {
            return sb.append((char)('A' + next)).toString();
        }
        if(count == 0 || count > 1) {
            return sb.toString();
        }
        sb.append((char)('A' + next));
        return walk(root.children[next], sb);
    }

    private void insert(TrieNode root, String s) {
        TrieNode temp = root;
        for(char c:s.toCharArray()) {
            if(temp.children[c-'A'] == null) {
                temp.children[c-'A'] = new TrieNode();
            }
            temp = temp.children[c - 'A'];
        }
        temp.end = true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(List.of("ABCD")));
    }
}
