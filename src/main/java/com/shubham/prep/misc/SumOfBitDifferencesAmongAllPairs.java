package com.shubham.prep.misc;

public class SumOfBitDifferencesAmongAllPairs {

    private int sumBitDifferences(int[] arr, int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if((arr[j] & (1<<i)) != 0) {
                    count++;
                }
            }
            ans += (count * (n-count))*2;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfBitDifferencesAmongAllPairs sumOfBitDifferencesAmongAllPairs = new SumOfBitDifferencesAmongAllPairs();
        System.out.println(sumOfBitDifferencesAmongAllPairs.sumBitDifferences(new int[]{1,3,5}, 3));
    }
}
