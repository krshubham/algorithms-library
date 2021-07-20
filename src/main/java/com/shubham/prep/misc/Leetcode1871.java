package com.shubham.prep.misc;

//TODO
public class Leetcode1871 {
    private boolean[] visited = new boolean[100005];
    public boolean canReach(String s, int minJump, int maxJump) {
        return solve(s, minJump, maxJump, minJump,maxJump);
    }

    private boolean solve(String s, int min, int max, int start, int end) {
        return false;
    }
}
