package com.shubham.prep.misc;

public class MaximumAbsoluteDifferenceSubarrays {

    private void kadane(int[] arr, int[] aux,int start, int end, int difference) {
        int k = start;
        int local = arr[start];
        int sum = arr[start];
        aux[k] = arr[start];
        k += difference;
        for(int i = start+difference; i != end; i+=difference) {
            sum = Math.max(sum + arr[i], arr[i]);
            local = Math.max(sum, local);
            aux[k] = local;
            k += difference;
        }
    }

    private int maximumAbsDifference(int[] arr) {
        int n = arr.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        int[] left_min = new int[n];
        int[] right_min = new int[n];

        kadane(arr, left_max, 0, n-1,1);
        kadane(arr, right_max, n-1,0,-1);
        for(int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }
        kadane(arr, left_min, 0, n-1, 1);
        kadane(arr, right_min, n-1, 0, -1);
        for(int i = 0; i < n; i++) {
            left_min[i] = -left_min[i];
            right_min[i] = -right_min[i];
            arr[i] = -arr[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++) {
            ans = Math.max(ans, Math.max(left_max[i] - right_min[i+1], left_min[i] - right_max[i+1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumAbsoluteDifferenceSubarrays maximumAbsoluteDifferenceSubarrays = new MaximumAbsoluteDifferenceSubarrays();
        int[] A = { -3, -2, 6, -3, 5, -9, 3, 4, -1, -8, 2 };
        System.out.println(maximumAbsoluteDifferenceSubarrays.maximumAbsDifference(A));
    }
}
