package com.shubham.prep.misc;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = 0;
        int m = A.size();
        int n = B.size();
        ArrayList<Integer> res = new ArrayList<>();
        while(i < m && j < n) {
            if(A.get(i).equals(B.get(j))) {
                res.add(A.get(i));
                i++;
                j++;
            } else if(A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        System.out.println(intersectionOfSortedArrays.intersect(List.of(10000000), List.of(10000000)));

        List<Integer> list1 = List.of(10000000);
        List<Integer> list2 = List.of(10000000);
        System.out.println(list1.get(0) == list2.get(0));
    }
}
