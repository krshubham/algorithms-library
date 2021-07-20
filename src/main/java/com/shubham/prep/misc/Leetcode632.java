package com.shubham.prep.misc;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode632 {

    // A class to store a heap node
    static class Node implements Comparable {
        // `value` stores the element
        private int value;

        // `listNum` stores the list number of the element
        private int listNum;

        // `index` stores the column number of the list from which element was taken
        private int index;

        Node(int value, int listNum, int index) {
            this.value = value;
            this.listNum = listNum;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getListNum() {
            return listNum;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return value - node.value;
        }
    }

    // A simple Pair class in Java
    static class Pair<U, V> {
        private final U first;      // first field of a pair
        private final V second;     // second field of a pair

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    // Function to compute the minimum range that includes at least one element
    // from each of the given `M` lists
    public static Pair<Integer, Integer> findMinimumRange(List<List<Integer>> list) {
        // `high` will be the maximum element in a heap
        int high = Integer.MIN_VALUE;

        // stores minimum and maximum elements found so far in a heap
        Pair<Integer, Integer> p = new Pair(0, Integer.MAX_VALUE);

        // create an empty min-heap
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // push the first element of each list into the min-heap
        // along with the list number and their index in the list
        for (int i = 0; i < list.size(); i++) {
            pq.add(new Node(list.get(i).get(0), i, 0));
            high = Integer.max(high, list.get(i).get(0));
        }

        // run till the end of any list is reached
        while (true) {
            // remove the root node
            Node top = pq.poll();

            // retrieve root node information from the min-heap
            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();

            // update `low` and `high` if a new minimum is found
            if (high - low < p.getSecond() - p.getFirst()) {
                p = new Pair(low, high);
            }

            // return on reaching the end of any list
            if (j == list.get(i).size() - 1) {
                return p;
            }

            // take the next element from the "same" list and
            // insert it into the min-heap
            pq.add(new Node(list.get(i).get(j + 1), i, j + 1));

            // update high if the new element is greater
            high = Integer.max(high, list.get(i).get(j + 1));
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1,2,3)
        );

        Pair<Integer, Integer> p = findMinimumRange(list);
        System.out.println("The minimum range is " + p.getFirst() +
                "–" + p.getSecond());
    }
}
