package com.shubham.cp.codeforces;

import java.util.Arrays;
import java.util.Scanner;

class A189 {
    private static int[] dp = new int[4005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Arrays.fill(dp, -1);

        int res = solve(n , a, b, c);
        System.out.println(res);
        sc.close();
    }

    private static int solve(int n, int a, int b, int c) {
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];

        int x = Integer.MIN_VALUE,y = Integer.MIN_VALUE,z = Integer.MIN_VALUE;
        if(n >= a) {
            x = solve(n-a,a, b, c);
        }
        if(n >= b) {
            y = solve(n-b, a, b, c);
        }
        if(n >= c) {
            z = solve(n-c, a, b, c);
        }
        return dp[n] = 1 + Math.max(x, Math.max(y,z));
    }
}
