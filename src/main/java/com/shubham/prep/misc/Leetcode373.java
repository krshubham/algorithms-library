package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373 {
    private PriorityQueue<Integer[]> heap = new PriorityQueue<>((a,b) -> a[0] + a[1] - b[0] - b[1]);
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        for(int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.add(new Integer[]{nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !heap.isEmpty()) {
            Integer[] curr = heap.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(curr[0]);
            temp.add(curr[1]);
            res.add(temp);
            if(curr[2] < nums2.length - 1) {
                int idx = curr[2] + 1;
                heap.add(new Integer[]{curr[0], nums2[idx], idx});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode373 leetcode373 = new Leetcode373();
        leetcode373.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
    }
}
