package com.shubham.prep.graph;

import java.util.*;

public class Leetcode133 {
    public boolean canFinish(int n, int[][] prerequisites) {
        return false;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> copy = new HashMap<>();
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        copy.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            Node clonedCurr = copy.get(curr);
            if(curr.neighbors != null) {
                for(Node child: curr.neighbors) {
                    Node clonedChild = copy.get(child);
                    if(clonedChild == null) {
                        queue.add(child);
                        clonedChild = new Node(child.val, new ArrayList<>());
                        copy.put(child, clonedChild);
                    }
                    clonedCurr.neighbors.add(clonedChild);
                }
            }
        }
        return copy.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Leetcode133 leetcode133 = new Leetcode133();
        leetcode133.cloneGraph(node1);
    }
}
