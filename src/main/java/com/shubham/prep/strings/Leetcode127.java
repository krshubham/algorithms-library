package com.shubham.prep.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashSet<String> hashSet = new HashSet<>(wordList);

        if(!wordList.contains(endWord)) return 0;

        int res = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int count = 0; count < n; count++) {
                StringBuilder curr = new StringBuilder(queue.poll());
                if(curr.toString().equals(endWord)) return res;
                for(int i = 0; i < curr.length(); i++) {
                    for(char j = 'a'; j <= 'z'; j++) {
                        char original = curr.charAt(j);
                        curr.setCharAt(i, j);
                        String next = curr.toString();
                        if(hashSet.contains(next)) {
                            queue.add(next);
                            hashSet.remove(next);
                        }
                        curr.setCharAt(i, original);
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
