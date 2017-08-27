package com.leetcode;

/**
 * Created by xiaoyuan on 27/08/2017.
 */
public class P665_Non_decreasingArray {

    public boolean checkPossibility(int[] nums) {

        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt ++;
                if (cnt >= 2) {return false;}

                boolean okay = false;
                // modify i
                if (i == 0) {
                    okay = true;
                } else if (nums[i - 1] <= nums[i + 1]) {
                    okay = true;
                }


                if (okay) {continue;}
                // modify i + 1
                if (i + 1 == nums.length - 1) {okay = true;}
                else if (nums[i] <= nums[i + 2]) {
                    okay = true;
                }

                if (!okay) {return false;}
            }
        }

        return true;
    }

}
