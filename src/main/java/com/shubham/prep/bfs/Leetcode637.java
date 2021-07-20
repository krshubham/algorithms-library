package com.shubham.prep.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode637 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<LevelOrderTreeNode> queue = new LinkedList<>();
        queue.add(new LevelOrderTreeNode(root, 0));
        int sum = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            LevelOrderTreeNode curr = queue.poll();
            sum += curr.node.val;
            cnt++;
            if(curr.node.left != null) {
                queue.add(new LevelOrderTreeNode(curr.node.left, curr.level + 1));
            }
            if(curr.node.right != null) {
                queue.add(new LevelOrderTreeNode(curr.node.right, curr.level + 1));
            }
            if(queue.size() == 0) {
                res.add((double)sum/(double)cnt);
                sum = 0;
                cnt = 0;
                continue;
            }
            if(queue.size() > 0 && curr.level < queue.peek().level) {
                res.add((double)sum/(double)cnt);
                sum = 0;
                cnt = 0;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode637 leetcode637 = new Leetcode637();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(leetcode637.averageOfLevels(root));
    }
}
