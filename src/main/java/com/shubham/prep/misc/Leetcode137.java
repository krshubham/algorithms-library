package com.shubham.prep.misc;

public class Leetcode137 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int x = (1 << i);
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j]&x) == 0) {
                    sum++;
                }
            }
            if((sum%3) != 0) {
                result |= x;
            }
        }
        return result;
    }
    static int getSingle(int arr[], int n)
    {
        int ones = 0, twos = 0;

        int common_bit_mask;

        // Let us take the example of
        // {3, 3, 2, 3} to understand
        // this
        for (int i = 0; i < n; i++) {

        /* The expression "one & arr[i]" gives the bits that
        are there in both 'ones' and new element from arr[].
        We add these bits to 'twos' using bitwise OR

        Value of 'twos' will be set as 0, 3, 3 and 1 after
        1st, 2nd, 3rd and 4th iterations respectively */
            twos = twos | (ones & arr[i]);

        /* XOR the new bits with previous 'ones' to get all
        bits appearing odd number of times

        Value of 'ones' will be set as 3, 0, 2 and 3 after
        1st, 2nd, 3rd and 4th iterations respectively */
            ones = ones ^ arr[i];

        /* The common bits are those bits which appear third
        time So these bits should not be there in both
        'ones' and 'twos'. common_bit_mask contains all
        these bits as 0, so that the bits can be removed
        from 'ones' and 'twos'

        Value of 'common_bit_mask' will be set as 00, 00, 01
        and 10 after 1st, 2nd, 3rd and 4th iterations
        respectively */
            common_bit_mask = ~(ones & twos);

        /* Remove common bits (the bits that appear third
        time) from 'ones'

        Value of 'ones' will be set as 3, 0, 0 and 2 after
        1st, 2nd, 3rd and 4th iterations respectively */
            ones &= common_bit_mask;

        /* Remove common bits (the bits that appear third
        time) from 'twos'

        Value of 'twos' will be set as 0, 3, 1 and 0 after
        1st, 2nd, 3rd and 4th itearations respectively */
            twos &= common_bit_mask;

            // uncomment this code to see intermediate values
            // printf (" %d %d n", ones, twos);
        }

        return ones;
    }

    public static void main(String[] args) {
        Leetcode137 leetcode137 = new Leetcode137();
        System.out.println(leetcode137.singleNumber(new int[]{2,2,2,1}));
        System.out.println(getSingle(new int[]{2,2,2,1}, 4));
    }
}
