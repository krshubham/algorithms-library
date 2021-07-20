package com.shubham.prep.search;

public class LowerBound {
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        int ans = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return nums[mid];
            }
            if(nums[mid] < target) {
                low = mid + 1;
            }
            if(nums[mid] > target) {
                ans = nums[mid];
                high = mid - 1;
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                ans = nums[mid];
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LowerBound lowerBound = new LowerBound();
        System.out.println(lowerBound.lowerBound(new int[]{5,5,5,6,6,6,7,7}, 6));
        System.out.println(lowerBound.upperBound(new int[]{5,5,5,6,6,6,7,7}, 6));
    }
}
