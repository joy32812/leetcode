package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 24/03/2017.
 * carefull: overflow!!!
 */
public class P163_MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        return work(nums, lower, upper);
    }
    public List<String> work(int[] nums, long lower, long upper) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (d < lower) {
                continue;
            } else if (d == lower) {
                lower++;
            } else {
                if (d < upper) {
                    long l = lower;
                    long r = d - 1;
                    StringBuilder sb = new StringBuilder("" + l);
                    if (l < r) {
                        sb.append("->" + r);
                    }
                    result.add(sb.toString());

                    lower = d + 1;
                } else if (d == upper) {
                    long l = lower;
                    long r = d - 1;


                    StringBuilder sb = new StringBuilder("" + l);
                    if (l < r) {
                        sb.append("->" + r);
                    }
                    result.add(sb.toString());

                    lower = upper + 1;
                    break;
                } else {
                    long l = lower;
                    long r = upper;
                    StringBuilder sb = new StringBuilder("" + l);
                    if (l < r) {
                        sb.append("->" + r);
                    }
                    result.add(sb.toString());

                    lower = upper + 1;
                    break;
                }
            }
        }

        if (lower <= upper) {
            long l = lower;
            long r = upper;
            StringBuilder sb = new StringBuilder("" + l);
            if (l < r) {
                sb.append("->" + r);
            }
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{2147483647}, 0, 2147483647));
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 99}, 0, 99));
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(new P163_MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }

}
