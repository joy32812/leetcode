package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P625_MinimumFactorization {

    public int smallestFactorization(int a) {
        if (a == 1) {return 1;}

        List<Integer> list = new ArrayList<>();
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                list.add(i);
                a /= i;
            }
        }

        if (list.size() >= 40) {return 0;}
        if (a > 1) {return 0;}

        list.sort((x, y) -> (x - y));

        long val = 0;
        for (int d : list) {
            val = val * 10 + d;
        }

        return val > Integer.MAX_VALUE ? 0 : (int)val;
    }

}
