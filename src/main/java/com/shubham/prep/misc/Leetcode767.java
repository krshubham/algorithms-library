package com.shubham.prep.misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode767 {
    public String reorganizeString(String s) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        HashMap<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!counts.containsKey(s.charAt(i))) {
                counts.put(s.charAt(i), 1);
            } else {
                counts.put(s.charAt(i), counts.get(s.charAt(i)) + 1);
            }
        }
        counts.forEach((k,v) -> {
            heap.add(new Integer[]{k - 'a',v});
        });

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()) {
            Integer[] curr = heap.poll();
            if(sb.length() > 0) {
                if(Character.toChars(curr[0] + 'a')[0] == sb.charAt(sb.length() - 1)) continue;
            }
            sb.append(Character.toChars(curr[0] + 'a')[0]);
            curr[1]--;
            if(curr[1] > 0) {
                heap.add(new Integer[]{curr[0], curr[1]});
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode767 leetcode767 = new Leetcode767();
        System.out.println(leetcode767.reorganizeString("ccccaba"));
    }
}
