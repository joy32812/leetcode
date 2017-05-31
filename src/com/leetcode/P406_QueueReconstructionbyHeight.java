package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 31/05/2017.
 */
public class P406_QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {return a[1] - b[1];}
            return b[0] - a[0];
        });

        int[][] ans = new int[n][2];

        for (int i = 0; i < n; i++) {
            int h = people[i][0];
            int p = people[i][1];

            for (int j = i; j > p; j--) {
                ans[j][0] = ans[j - 1][0];
                ans[j][1] = ans[j - 1][1];
            }

            ans[p][0] = h;
            ans[p][1] = p;
        }


        return ans;
    }



}
