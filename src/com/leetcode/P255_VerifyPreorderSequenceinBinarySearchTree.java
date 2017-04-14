package com.leetcode;

/**
 * Created by xiaoyuan on 14/04/2017.
 */
public class P255_VerifyPreorderSequenceinBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        return okay(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean okay(int[] arr, int l, int r, int min, int max) {
        for (int i = l; i <= r; i++) {
            if (arr[i] < min || arr[i] > max) {return false;}
        }
        if (l > r) {return true;}

        int m = l + 1;
        for (; m <= r; m++) {
            if (arr[m] > arr[l]) {break;}
        }

        return okay(arr, l + 1, m - 1, min, arr[l]) && okay(arr, m, r, arr[l], max);
    }

}
