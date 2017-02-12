package com.leetcode;

/**
 * Created by xiaoyuan on 12/02/2017.
 * 划分为子问题
 * 需要证明
 */
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {1, 3, 5, 7, 9, 4};
        System.out.println(new ContainerWithMostWater11().maxArea(heights));
    }
}
