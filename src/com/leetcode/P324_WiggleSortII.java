package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 07/05/2017.
 */
public class P324_WiggleSortII {

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {sorted[i] = nums[i];}
        Arrays.sort(sorted);

        int cnt = 0;
        for (int i = (n - 1) % 2 == 0 ? n - 1 : n - 2; i >= 0; i -= 2) {
            nums[i] = sorted[cnt++];
        }

        for (int i = (n - 1) % 2 == 0 ? n - 2 : n - 1; i >= 0; i -= 2) {
            nums[i] = sorted[cnt++];
        }
    }

}
