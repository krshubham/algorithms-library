package com.shubham.prep.misc;

import java.util.Arrays;

public class Main
{
    // `diff` ——> counter for loop from `i` to `j` in `A[]` (`diff` can be `1` or `-1`)

    // If the `diff` is 1, fill `aux[k]` with the maximum sum of subarray `A[0, k]`
    // If the `diff` is -1, fill `aux[k]` with the maximum sum of subarray `A[k, n-1]`
    // using Kadane’s algorithm

    public static void findMaxSumSubarray(int[] A, int[] aux, int i, int j,
                                          int diff)
    {
        int max_so_far = A[i];
        int max_ending_here = A[i];
        aux[i] = A[i];

        for (int k = i + diff; k != j; k += diff)
        {
            // update the maximum sum of subarray "ending" or "starting" at index `k`
            max_ending_here = Integer.max(A[k], max_ending_here + A[k]);

            // update the result if the current subarray sum is found to be greater
            max_so_far = Integer.max(max_so_far, max_ending_here);
            aux[k] = max_so_far;
        }
    }

    public static void fillArrays(int[] A, int[] left_max, int[] right_max,
                                  int[] left_min, int[] right_min, int n)
    {
        findMaxSumSubarray(A, left_max, 0, n - 1, 1);
        findMaxSumSubarray(A, right_max, n - 1, 0, -1);

        // negate `A[]` for finding the minimum sum of subarrays using
        // the same logic for finding the maximum sum of subarrays
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }

        findMaxSumSubarray(A, left_min, 0, n - 1, 1);
        findMaxSumSubarray(A, right_min, n - 1, 0, -1);

        // negate `left_min[]` and `right_min[]` to get the minimum sum of subarrays
        for (int i = 0; i < n; i++) {
            left_min[i] = -left_min[i];
        }

        System.out.println(Arrays.toString(left_min));

        for (int i = 0; i < n; i++) {
            right_min[i] = -right_min[i];
        }

        // restore the sign of `A[]`
        for (int i = 0; i < n; i++) {
            A[i] = -A[i];
        }
    }

    // Find the maximum absolute difference between the sum of elements of
    // two non-overlapping subarrays in a given array
    public static int findMaxAbsDiff(int[] A, int n)
    {
        // `left_max[i]` stores maximum sum of subarray in `A(0, i)`
        // `right_max[i]` stores maximum sum of subarray in `A(i, n-1)`
        // `left_min[i]` stores minimum sum of subarray in `A(0, i)`
        // `right_min[i]` stores minimum sum of subarray in `A(i, n-1)`

        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int[] left_min = new int[n];
        int[] right_min = new int[n];

        fillArrays(A, left_max, right_max, left_min, right_min, n);

        // stores the maximum absolute difference
        int max_abs_diff = Integer.MIN_VALUE;

        // do for each index `i` in the array
        for (int i = 0; i < n - 1; i++)
        {
            int abs_diff = Integer.max(Math.abs(left_max[i] - right_min[i+1]),
                    Math.abs(left_min[i] - right_max[i+1]));
            max_abs_diff = Integer.max(max_abs_diff, abs_diff);
        }

        return max_abs_diff;
    }

    public static void main(String[] args)
    {
        int[] A = { -3, -2, 6, -3, 5, -9, 3, 4, -1, -8, 2 };

        System.out.print("The maximum absolute difference is "
                + findMaxAbsDiff(A, A.length));
    }
}
