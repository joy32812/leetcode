package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P442_FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int real = nums[i];
            if (real > n) {real -= n;}

            int pos = real - 1;
            if (nums[pos] > n) {
                ans.add(real);
            } else {
                nums[pos] += n;
            }
        }

        return ans;
    }

}
