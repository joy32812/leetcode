package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P1029_TwoCityScheduling {

    /**
     * Greedy
     * sort by costA - costB
     * send first N to A
     * last N to B
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {

        List<int[]> data = new ArrayList<>();

        for (int[] c : costs) {
            data.add(new int[]{c[0], c[1], c[0] - c[1]});
        }
        data.sort((Comparator.comparingInt(a -> a[2])));

        int ans = 0;

        int n = costs.length / 2;

        for (int i = 0; i < costs.length; i++) {
            if (i < n) ans += data.get(i)[0];
            else ans += data.get(i)[1];
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new P1029_TwoCityScheduling().twoCitySchedCost(new int[][]{
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        }));
    }

}
