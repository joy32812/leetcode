package com.leetcode;

/**
 * Created by xiaoyuan on 27/02/2017.
 */
public class P55_JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];

        canJump[0] = true;
        int lastPos = 1;

        for (int i = 0; i < nums.length; i++) {
            if (canJump[i]) {
                int minPos = Math.max(lastPos, i + 1);
                int maxPos = Math.min(nums.length - 1, i + nums[i]);

                for (int j = minPos; j <= maxPos; j++) {
                    canJump[j] = true;
                }

                if (lastPos < maxPos + 1) {
                    lastPos = maxPos + 1;
                }
                if (lastPos >= nums.length) {
                    break;
                }
            }
        }

        return canJump[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(new P55_JumpGame().canJump(nums1));
        System.out.println(new P55_JumpGame().canJump(nums2));

    }

}
