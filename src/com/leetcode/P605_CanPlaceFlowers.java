package com.leetcode;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {return true;}

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {continue;}

            if (okay(flowerbed, i - 1) && okay(flowerbed, i + 1)) {
                n--;
                flowerbed[i] = 1;
                if (n == 0) {return true;}
            }
        }

        return false;
    }

    private boolean okay(int[] flowerbed, int p) {
        if (p < 0 || p >= flowerbed.length) {return true;}

        return flowerbed[p] == 0;
    }

}
