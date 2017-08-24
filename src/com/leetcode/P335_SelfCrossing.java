package com.leetcode;

/**
 * Created by xiaoyuan on 24/08/2017.
 */
public class P335_SelfCrossing {

    public boolean isSelfCrossing(int[] x) {

        if (x == null || x.length < 4) {return false;}

        for (int i = 3; i < x.length; i++) {
            if (i >= 3) {
                if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {return true;}
            }

            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {return true;}
            }


            if (i >= 5) {
                if (x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 3] >= x[i - 1] && x[i] + x[i - 4] >= x[i - 2] && x[i - 2] >= x[i - 4]) {
                    return true;
                }
            }
        }

        return false;
    }

}
