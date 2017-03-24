package com.leetcode;

/**
 * Created by xiaoyuan on 24/03/2017.
 */
public class P162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {return 0;}

        int l = 0, r = nums.length - 1;
        while (true) {
            int m = (l + r) / 2;
            if (okay(nums, m)) {return m;}

            if (m - 1 >= 0 && nums[m] < nums[m - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }

    private boolean okay(int[] nums, int m) {
        if (m - 1 >= 0 && nums[m] < nums[m - 1]) {return false;}
        if (m + 1 < nums.length && nums[m] < nums[m + 1]) {return false;}
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new P162_FindPeakElement().findPeakElement(new int[]{1}));
        System.out.println(new P162_FindPeakElement().findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(new P162_FindPeakElement().findPeakElement(new int[]{2, 1}));
        System.out.println(new P162_FindPeakElement().findPeakElement(new int[]{1, 2, 3, 1}));

    }

}
