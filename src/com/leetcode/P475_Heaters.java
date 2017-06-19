package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P475_Heaters {

    private int[] House;
    private int[] Heate;

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length <= 1) {return 0;}

        House = houses;
        Heate = heaters;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int l = 0;
        int r = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);

        while (l < r) {
            int m = (l + r) / 2;

            if (!okay(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r;
    }

    private boolean okay(int m) {

        int p = 0;
        for (int i = 0; i < House.length; i++) {
            while (p < Heate.length && House[i] > Heate[p]) {p++;}

            boolean okay = false;
            if (p < Heate.length && House[i] + m >= Heate[p]) {
                okay = true;
            }

            if (p - 1 >= 0 && Heate[p -1] + m >= House[i]) {
                okay = true;
            }

            if (!okay) {return false;}
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P475_Heaters().findRadius(new int[]{1, 5}, new int[]{10}));
    }

}
