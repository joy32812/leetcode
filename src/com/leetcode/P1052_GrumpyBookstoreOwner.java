package com.leetcode;

public class P1052_GrumpyBookstoreOwner {


    /**
     * medium
     * use presum and slide window
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int[] presum = new int[n];
        int[] total = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) sum += customers[i];
            presum[i] = sum;

            total[i] = (i - 1 >= 0 ? total[i - 1] : 0) + customers[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i + X > n) break;

            ans = Math.max(ans, getValue(presum, 0, i - 1) + getValue(total, i, i + X - 1) + getValue(presum, i + X, n - 1));
        }

        return ans;
    }

    private int getValue(int[] sum, int l, int r) {
        return (r >= 0 && r < sum.length ? sum[r] : 0) - (l - 1 >= 0 && l - 1 < sum.length ? sum[l - 1] : 0);
    }


    public static void main(String[] args) {
        System.out.println(new P1052_GrumpyBookstoreOwner().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

}
