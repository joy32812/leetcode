package com.leetcode;

/**
 * Created by xiaoyuan on 17/03/2017.
 */
public class P137_SingleNumberII {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((1<<i)&nums[j]) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 == 1) {
                ans += (1 << i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P137_SingleNumberII().singleNumber(new int[]{-5, 2, 2, 2, 3, 3, 3}));
        outBinary(-1);
        outBinary(-2);
    }

    private static void outBinary(int a) {
        System.out.printf("%s", Integer.toBinaryString(a));
        System.out.println();
    }


}
