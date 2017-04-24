package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 24/04/2017.
 */
public class P296_BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {return 0;}

        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }

        return getMin(X) + getMin(Y);

    }

    private int getMin(List<Integer> list) {

        Collections.sort(list);

        int l = 0;
        int r = list.size() - 1;
        int ans = 0;
        while (l < r) {
            ans += (list.get(r) - list.get(l));
            r--;
            l++;
        }

        return ans;
    }

}
