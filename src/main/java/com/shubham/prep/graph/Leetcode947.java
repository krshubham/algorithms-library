package com.shubham.prep.graph;

import java.util.HashMap;
import java.util.Map;

public class Leetcode947 {
    Map<String, String> parent = new HashMap<>();
    int count = 0;
    public int removeStones(int[][] stones) {
        count = stones.length;
        for(int[] stone: stones) {
            String curr = stone[0] + "," +stone[1];
            parent.put(curr, curr);
        }

        for (int[] s1 : stones) {
            String ss1 = s1[0] + " " + s1[1];
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) { // in the same column or row
                    String ss2 = s2[0] + " " + s2[1];
                    union(ss1, ss2);
                }
            }
        }
        return stones.length - count;
    }

    private void union(String u, String v) {
        u = find(u);
        v = find(v);
        if(!u.equals(v)) {
            parent.put(v, u);
        }
    }

    public String find(String v) {
        if(!parent.get(v).equals(v)) {
            parent.put(v, find(parent.get(v)));
        }
        return v;
    }
}
