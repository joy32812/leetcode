package com.leetcode;

/**
 * Created by xiaoyuan on 29/03/2017.
 */
public class P190_ReverseBits {


    public int reverseBits(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            if ((n & 1) > 0) {
                ans += 1;
            }
            n >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P190_ReverseBits().reverseBits(43261596));
    }

}
