package com.leetcode;

/**
 * Created by xiaoyuan on 12/06/2017.
 */
public class P485_MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        int ans = 0;

        int cnt = 0;
        for (int d : nums) {
            if (d == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }

        ans = Math.max(ans, cnt);

        return ans;
    }


}
