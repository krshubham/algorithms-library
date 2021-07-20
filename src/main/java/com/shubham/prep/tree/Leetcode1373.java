package com.shubham.prep.tree;

public class Leetcode1373 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class State {
        int val;
        int min;
        int max;
        boolean isBST;

        public State(int val, int min, int max, boolean isBST) {
            this.val = val;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    private int sum = 0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return sum;
    }

    private State solve(TreeNode root) {
        if(root == null) return new State(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);

        State left = solve(root.left);
        State right = solve(root.right);

        boolean isBST = left.isBST && right.isBST && root.val > left.min && root.val < right.max;
        int res = root.val + left.val + right.val;
        if(isBST) {
            sum = Math.max(res, sum);
        }
        //tighten the boundaries
        return new State(res, Math.max(root.val, left.min), Math.min(root.val, right.max), isBST);
    }
}
