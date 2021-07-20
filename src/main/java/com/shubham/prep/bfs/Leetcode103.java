package com.shubham.prep.bfs;

import java.util.*;

public class Leetcode103 {
    private static class TreeNode {
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
    private static class LevelOrderTreeNode {
        TreeNode node;
        int level;

        public LevelOrderTreeNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<LevelOrderTreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean flag = true;
        queue.addFirst(new LevelOrderTreeNode(root, 0));
        while(!queue.isEmpty()) {
            if(flag) {
                LevelOrderTreeNode curr = queue.poll();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Leetcode103 leetcode103 = new Leetcode103();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        leetcode103.zigzagLevelOrder(root);
    }
}
