package com.shubham.cp.codechef.medium;

import java.util.HashMap;
import java.util.Scanner;

public class coins {
    private static final HashMap<Integer, Integer> dp = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp.put(1, 1);
        try {
            for(int i = 0; i < 10; i++) {
                int x = sc.nextInt();
                System.out.println(solve(x));
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static int solve(int x) {
        if(x > 0) {
            int ans = 1 + Math.max(solve(x/2), Math.max(solve(x/3), solve(x/4)));
        }
        return 0;
    }
}