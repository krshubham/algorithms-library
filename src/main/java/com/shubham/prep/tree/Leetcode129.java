package com.shubham.prep.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode129 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<String> nums = new ArrayList<>();
        solve(root, nums, new StringBuilder());
        int res = 0;
        for(int i = 0; i < nums.size(); i++) {
            res += Integer.parseInt(nums.get(i));
        }
        return res;
    }

    private void solve(TreeNode root, List<String> nums, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val);
        solve(root.left, nums, sb);
        solve(root.right, nums, sb);
        if(root.left == null && root.right == null) {
            nums.add(sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Leetcode129 leetcode129 = new Leetcode129();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(leetcode129.sumNumbers(root));
    }
}
