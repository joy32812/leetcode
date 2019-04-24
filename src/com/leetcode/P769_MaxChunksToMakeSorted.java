package com.leetcode;

public class P769_MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {

        int ans = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            if (max <= i) ans ++;
        }

        return ans;
    }

}
