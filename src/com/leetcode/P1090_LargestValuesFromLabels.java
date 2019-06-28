package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1090_LargestValuesFromLabels {

    /**
     * easy
     * use cntMap to record the number used
     * @param values
     * @param labels
     * @param num_wanted
     * @param use_limit
     * @return
     */
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        int n = values.length;
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i] = new int[]{values[i], labels[i]};
        }

        Arrays.sort(data, (a, b) -> (b[0] - a[0]));

        Map<Integer, Integer> cntMap = new HashMap<>();

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i ++) {
            int v = data[i][0];
            int l = data[i][1];

            if (cntMap.getOrDefault(l, 0) >= use_limit) continue;

            ans += v;
            cntMap.put(l, cntMap.getOrDefault(l, 0) + 1);

            cnt ++;
            if (cnt >= num_wanted) break;

        }

        return ans;
    }

}
