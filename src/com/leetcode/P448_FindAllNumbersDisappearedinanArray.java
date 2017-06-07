package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 08/06/2017.
 */
public class P448_FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int d = nums[i];
            if (d > n) {d -= n;}

            if (nums[d - 1] <= n) {nums[d - 1] += n;}
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
