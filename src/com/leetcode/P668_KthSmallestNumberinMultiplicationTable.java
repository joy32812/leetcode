package com.leetcode;

/**
 * Created by xiaoyuan on 23/09/2017.
 */
public class P668_KthSmallestNumberinMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {

        int l = 1;
        int r = m * n + 1;

        while (l < r) {
            int mid = (l + r) / 2;

            int num = getNum(mid, m, n);

            if (num < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;

    }

    private int getNum(int mid, int m, int n) {
        int num = 0;
        for (int i = 1; i <= m; i++) {
            int x = mid / i;
            if (x == 0) return num;

            num += Math.min(x, n);
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(new P668_KthSmallestNumberinMultiplicationTable().findKthNumber(45, 12, 471));
        System.out.println(new P668_KthSmallestNumberinMultiplicationTable().findKthNumber(3, 3, 5));
        System.out.println(new P668_KthSmallestNumberinMultiplicationTable().findKthNumber(2, 3, 6));
    }

}
