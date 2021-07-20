package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CountOfSmallerNumbersAfterSelf {
    private static class TreeNode {
        int val;
        int count;
        int frequency;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, int count) {
            this.val = val;
            this.count = count;
            this.frequency = 1;
        }
    }

    private TreeNode insert(TreeNode root, int val, int cnt, List<Integer> count) {
        if(root == null) {
            root = new TreeNode(val, 0);
            count.add(cnt);

        } else if(root.val == val) {
            root.frequency++;
            count.add(root.count + cnt);
        }
        else if (val < root.val) {
            root.count++;
            root.left = insert(root.left, val, cnt, count);
        } else {
            root.right = insert(root.right, val, cnt + root.frequency + root.count, count);
        }
        return root;
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> count = new ArrayList<>();
        TreeNode root = null;
        for(int i = n-1; i >= 0; i--) {
            root = insert(root, nums[i], 0, count);
        }
        Collections.reverse(count);
        return count;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf count = new CountOfSmallerNumbersAfterSelf();
        count.countSmaller(new int[]{5,4,3,2,1}).forEach(System.out::println);
    }
}
