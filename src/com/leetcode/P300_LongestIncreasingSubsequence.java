package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by xiaoyuan on 24/04/2017.
 */
public class P300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> dp = new ArrayList<>();
        for (int d : nums) {
            if (dp.size() == 0 || dp.get(dp.size() - 1) < d) {
                dp.add(d);
            } else {
                int i = Collections.binarySearch(dp, d);
                if (i < 0) {i = - (i + 1);}

                dp.set(i, d);
            }
        }

        return dp.size();

    }

    public static void main(String[] args) {
        System.out.println(new P300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

}
