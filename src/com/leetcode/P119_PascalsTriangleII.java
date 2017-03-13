package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 13/03/2017.
 */
public class P119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<Integer>();
        int k = rowIndex;
        tmp.add(1);

        long ai = k;
        long bi = 1;
        long now = ai / bi;

        for (int i = 1; i <= k; i++) {
            tmp.add((int)now);
            ai --;
            bi ++;

            now = now * ai / bi;
        }
        return tmp;
    }
}
