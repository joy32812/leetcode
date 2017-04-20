package com.leetcode;

/**
 * Created by xiaoyuan on 20/04/2017.
 */
public class P287_FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            int cnt = 0;
            for (int d : nums) {
                if (d <= m) {cnt++;}
            }

            if (cnt > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }


}
