package com.leetcode;

public class P1014_CapacityToShipPackagesWithinDDays {

    /**
     * binary search
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {

        int max = 0;
        int total = 0;
        for (int d : weights) {
            total += d;
            max = Math.max(max, d);
        }

        int l = max;
        int r = total + 1;

        while (l < r) {

            int m = (l + r) / 2;
            if (okay(weights, D, m)) r = m;
            else l = m + 1;

        }

        return l;
    }

    private boolean okay(int[] weights, int D, int m) {

        int total = 0;
        int day = 0;
        for (int i = 0; i < weights.length; i++) {
            if (total + weights[i] > m) {
                day ++;
                total = weights[i];
            } else {
                total += weights[i];
            }
        }

        day ++;

        return day <= D;
    }


    public static void main(String[] args) {

        System.out.println(new P1014_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new P1014_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(new P1014_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

}
