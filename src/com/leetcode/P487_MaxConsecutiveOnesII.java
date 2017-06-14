package com.leetcode;

/**
 * Created by xiaoyuan on 14/06/2017.
 */
public class P487_MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;

        int lastOnes = 0;
        int nowCnt = 0;

        int zeroValue = 0;

        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                ans = Math.max(ans, lastOnes + nowCnt + zeroValue);
                if (i < nums.length) {
                    zeroValue = 1;
                }
                lastOnes = nowCnt;
                nowCnt = 0;

            } else {
                nowCnt++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P487_MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(new P487_MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
    }

}
