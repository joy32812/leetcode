package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 06/04/2017.
 */
public class P221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {return 0;}

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m][n];
        for (int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') {
                    sum[i][j] += 1 +  (i > 0 ? sum[i - 1][j] : 0);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= n; j++) {
                int h = (j == n) ? 0 : sum[i][j];

                if (stack.isEmpty() || h >= sum[i][stack.peek()]) {
                    stack.push(j);
                } else {
                    int tpIndex = stack.pop();
                    int d = Math.min(sum[i][tpIndex], stack.isEmpty() ? j : j - stack.peek() - 1);
                    ans = Math.max(ans, d * d);
                    j--;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                "0001".toCharArray(),
                "1101".toCharArray(),
                "1111".toCharArray(),
                "0111".toCharArray(),
                "0111".toCharArray(),
//                "10100".toCharArray(),
//                "10111".toCharArray(),
//                "11111".toCharArray(),
//                "10010".toCharArray()
        };
        System.out.println(new P221_MaximalSquare().maximalSquare(matrix));
    }

}
