package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P728_SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (okay(i)) ans.add(i);
        }

        return ans;
    }

    private boolean okay(int x) {
        int now = x;

        while (x > 0) {
            int z = x % 10;
            if (z == 0) return false;
            if (now % z != 0) return false;

            x /= 10;
        }

        return true;
    }

}
