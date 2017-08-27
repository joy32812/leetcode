package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 27/08/2017.
 */
public class P667_BeautifulArrangementII {

    public int[] constructArray(int n, int k) {

        int[] ks = new int[n];
        int now = 0;
        k++;
        for (int i = 0; i < k; i+= 2) {
            ks[i] = ++now;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (ks[i] > 0) {continue;}
            ks[i] = ++now;
        }

        for (int i = k; i < n; i++) {
            ks[i] = ++now;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ks[i] + " ");
        }
        System.out.println();

        return ks;
    }

    public static void main(String[] args) {
        System.out.println(new P667_BeautifulArrangementII().constructArray(10, 5));
    }

}
