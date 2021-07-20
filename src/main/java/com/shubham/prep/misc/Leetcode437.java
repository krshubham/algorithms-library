package com.shubham.prep.misc;

public class Leetcode437 {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    public int pathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }

    private int solve(TreeNode root, int sum) {
        if(root == null) return 0;
        if(sum == 0) return 1;

        int ways = 0;
        if(root.val <= sum){
            ways += solve(root.left, sum - root.val) + solve(root.right, sum - root.val);
        }
        return ways;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        Leetcode437 leetcode437 = new Leetcode437();
        System.out.println(leetcode437.pathSum(root, 8));
    }
}
