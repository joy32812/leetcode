package com.leetcode;

public class P812_LargestTriangleArea {

    /**
     * area = sqrt(p * (p - a) * (p - b) * (p - c))
     * p = (a + b + c)/2
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, getArea(points[i], points[j], points[k]));
                }
            }
        }

        return ans;
    }

    private double getArea(int[] p1, int[] p2, int[] p3) {
        double a = getSide(p1, p2);
        double b = getSide(p1, p3);
        double c = getSide(p2, p3);

        if (a + b <= c || a + c <= b || b + c <= a) return 0.0;

        double p = (a + b + c) / 2.0;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private double getSide(int[] s, int[] t) {
        return Math.sqrt(0.0 + (s[0] - t[0]) * (s[0] - t[0]) + (s[1] - t[1]) * (s[1] - t[1]));
    }


    public static void main(String[] args) {
        System.out.println(new P812_LargestTriangleArea().largestTriangleArea(new int[][]{
                {35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}
        }));
    }

}
