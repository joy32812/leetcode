package com.leetcode;

/**
 * Created by xiaoyuan on 11/05/2017.
 */
public class P338_CountingBits {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            ans[i] = 1 + ans[i & (i - 1)];
        }

        for (int i = 0; i < ans.length; i ++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new P338_CountingBits().countBits(5));
    }

}
