package com.shubham.prep.heap;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Leetcode1338 {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            counts.compute(arr[i], (key,val) -> {
                if(val != null) {
                    return val + 1;
                }
                return 1;
            });
        }
        var list = counts.entrySet().stream().sorted(
                (a,b) -> b.getValue() - a.getValue())
                .collect(Collectors.toList());

        int size = n;
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            size -= list.get(i).getValue();
            count++;
            if(size <= n/2) break;
        }
        return count;
    }
}
