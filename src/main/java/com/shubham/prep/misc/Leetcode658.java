package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.List;

public class Leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        int index = -1;
        while(start < end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == x) {
                index = mid;
                break;
            }
            if(arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(index == -1) {
            index = start;
        }
        int left = Math.max(0, index - 1);
        int right = left + 1;
        while(right - left - 1 < k) {
            if(left == -1) {
                right++;
                continue;
            }
            if(right == n || Math.abs(arr[left]-x) <= Math.abs(arr[right] - x)){
                left--;
            } else {
                right++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = left+1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode658 leetcode658 = new Leetcode658();
        leetcode658.findClosestElements(new int[]{1,2,3,4,5}, 4, 3)
                .stream()
                .forEach(System.out::println);
    }
}
