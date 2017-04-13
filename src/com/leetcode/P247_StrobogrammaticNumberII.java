package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P247_StrobogrammaticNumberII {

    private List<String> ans;

    public List<String> findStrobogrammatic(int n) {
        ans = new ArrayList<>();

        int[] mapArr = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, -1};
        dfs(mapArr, 0, n - 1, "", "");

        return ans;
    }

    private void dfs(int[] mapArr, int l, int r, String start, String end) {
        if (l > r) {
            ans.add(start + end);
            return;
        }

        if (l == r) {
            for (int i = 0; i < mapArr.length; i++) {
                if (mapArr[i] < 0) {continue;}
                if (mapArr[i] != i) {continue;}
                dfs(mapArr, l + 1, r - 1, start + i, end);
            }
        } else {
            for (int i = 0; i < mapArr.length; i++) {
                if (l == 0 && i == 0) {continue;}
                if (mapArr[i] < 0) {continue;}
                dfs(mapArr, l + 1, r - 1, start + i, mapArr[i] + end);
                if (i != mapArr[i]) {
                    dfs(mapArr, l + 1, r - 1, start + mapArr[i], i + end);
                }
            }
        }
    }

}
