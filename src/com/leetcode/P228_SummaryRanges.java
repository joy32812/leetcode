package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {return ans;}

        int begin = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                int last = nums[i - 1];
                StringBuilder sb = new StringBuilder("" + begin);
                if (last != begin) {
                    sb.append("->" + last);
                }
                ans.add(sb.toString());

                if (i < nums.length) {
                    begin = nums[i];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P228_SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7}));
    }

}
