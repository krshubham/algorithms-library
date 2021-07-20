package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        int k = 0;
        for(int i = 1; i < n; i++) {
            if(!a.get(i).equals(a.get(k))) {
                a.set(k+1, a.get(i));
                k++;
            }
        }
        while(a.size() > k+1) {
            a.remove(k+1);
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        ArrayList<Integer> a = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ));
        removeDuplicates.removeDuplicates(a);
    }
}
