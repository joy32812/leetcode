package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 05/03/2017.
 *
 * like P84, same algorithm use stack
 * O(n^2)
 */
public class P85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
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
                    ans = Math.max(ans, sum[i][tpIndex] * (stack.isEmpty() ? j : j - stack.peek() - 1));
                    j--;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        char[][] martix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(new P85_MaximalRectangle().maximalRectangle(martix));
    }

}
