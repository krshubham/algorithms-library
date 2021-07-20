package com.shubham.prep.misc;

import java.util.List;

public class AllocateBooks {
    public int books(List<Integer> A, int B) {
        long sum = 0;
        if (A.size() < B)
            return -1;

        for (Integer integer : A) sum += integer;

        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(A,mid, B)) {
                result = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    private boolean check(List<Integer> nums, int mid, int k) {
        int studentsRequired = 1;
        int curr_sum = 0;

        // iterate over all books
        for (Integer num : nums) {
            if (num > mid)
                return false;

            if (curr_sum + num > mid) {
                studentsRequired++;
                curr_sum = num;


                if (studentsRequired > k)
                    return false;
            }
            else
                curr_sum += num;
        }
        return true;
    }

    public static void main(String[] args) {
        AllocateBooks allocateBooks = new AllocateBooks();
        System.out.println(allocateBooks.books(List.of(12, 34, 67, 90), 2));
    }
}
