package com.shubham.prep.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Leetcode218 {
    private static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int height;
        boolean start;

        public BuildingPoint(int x, int height, boolean start) {
            this.x = x;
            this.height = height;
            this.start = start;
        }

        @Override
        public int compareTo(BuildingPoint that) {
            if(this.x == that.x) {
                /*
                If the x coordinates are same, then:
                1. if both of them are start, then larger height comes first;
                2. If both of them are end, then lower height is to be picked
                3. If one is start and another is end, then start should appear before.
                 */
                if(that.start && this.start) {
                    //both of them are start
                    return that.height - this.height;
                } else if(!that.start && !this.start) {
                    //both of them are end
                    return this.height - that.height;
                } else if(this.start) {
                    return this.height - that.height;
                } else {
                    return that.height - this.height;
                }
            }
            return this.x - that.x;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        BuildingPoint[] points = new BuildingPoint[n*2];
        int i = 0;
        for(var building: buildings) {
            points[i] = new BuildingPoint(building[0], building[2], true);
            points[i+1] = new BuildingPoint(building[1], building[2], false);
            i += 2;
        }
        Arrays.sort(points);
        TreeMap<Integer, Integer> heap = new TreeMap<>();
        heap.put(0, 1);

        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(var point: points) {
            if(point.start) {
                heap.compute(point.height, (key, val) -> {
                    if(val != null) return val + 1;
                    return 1;
                });
            } else {
                heap.compute(point.height, (key, val) -> {
                    if(val != null && val == 1) return null;
                    return val-1;
                });
            }

            int currMax = heap.lastKey();

            if(prev != currMax) {
                res.add(List.of(point.x, currMax));
                prev = currMax;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int [][] buildings = {{2,9,10}, {3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        Leetcode218 leetcode218 = new Leetcode218();
        leetcode218.getSkyline(buildings);
    }
}
