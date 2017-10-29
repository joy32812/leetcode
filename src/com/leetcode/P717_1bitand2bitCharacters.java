package com.leetcode;

/**
 * Created by xiaoyuan on 29/10/2017.
 */
public class P717_1bitand2bitCharacters {

    public boolean isOneBitCharacter(int[] bits) {

        int n = bits.length;
        if (bits[n - 1] == 1) return false;

        for (int i = 0; i < bits.length; i++) {
            if (i == n - 1) return true;
            if (bits[i] == 1) {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P717_1bitand2bitCharacters().isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

}
