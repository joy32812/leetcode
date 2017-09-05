package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 05/09/2017.
 */
public class P672_BulbSwitcherII {

    public int flipLights(int n, int m) {
        if (n > 6) n = 6;

        int[] xor = {
                Integer.parseInt("111111", 2) & ((1 << n) - 1),
                Integer.parseInt("101010", 2) & ((1 << n) - 1),
                Integer.parseInt("010101", 2) & ((1 << n) - 1),
                Integer.parseInt("001001", 2) & ((1 << n) - 1),
        };

        Set<Integer> nowSet = new HashSet<>();
        nowSet.add((1 << n) - 1);

        for (int i = 0; i < m; i++) {
            Set<Integer> tmpSet = new HashSet<>();

            for (int d : nowSet) {
                for (int x : xor) {
                    tmpSet.add(d ^ x);
                }
            }

            nowSet = tmpSet;
        }

        return nowSet.size();
    }

    public static void main(String[] args) {
        System.out.println(new P672_BulbSwitcherII().flipLights(1, 1));
        System.out.println(new P672_BulbSwitcherII().flipLights(2, 1));
        System.out.println(new P672_BulbSwitcherII().flipLights(3, 1));
        System.out.println(new P672_BulbSwitcherII().flipLights(180, 929));
    }

}
