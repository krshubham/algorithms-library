package com.shubham.prep.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int direction = 0;
        int top = 0;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        while (top < bottom && left < right) {
            if(direction == 0) {
                for(int i = left; i < right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction++;
            }
            else if(direction == 1) {
                for(int i = top; i < bottom; i++) {
                    result.add(matrix[i][right-1]);
                }
                right--;
                direction++;
            }
            else if(direction == 2) {
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[bottom-1][i]);
                }
                bottom--;
                direction++;
            }
            else if(direction == 3) {
                for(int i = bottom-1; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction++;
            }
            direction = direction%4;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode54 leetcode54 = new Leetcode54();
        List<Integer> list = leetcode54.spiralOrder(new int[][]{{1,2},{5,6}, {9,10}, {11,12},{13,14}});
        list.forEach(System.out::println);
    }
}
