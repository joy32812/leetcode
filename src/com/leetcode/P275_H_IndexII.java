package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 17/04/2017.
 */
public class P275_H_IndexII {

    public int hIndex(int[] citations) {

        int ans = 0;
        int N = citations.length;
        for (int i = N; i >= 0; i--) {
            if (okay(citations, i)) {
                ans = i;
                break;
            }
        }


        return ans;
    }

    private boolean okay(int[] citations, int x) {
        int pos = citations.length - x;

        if (pos < citations.length) {
            if (citations[pos] < x) {return false;}
        }

        if (pos > 0) {
            if (citations[pos - 1] > x) {return false;}
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P275_H_IndexII().hIndex(new int[]{1,1}));
    }

}
