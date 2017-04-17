package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 17/04/2017.
 */
public class P274_H_Index {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);

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
        System.out.println(new P274_H_Index().hIndex(new int[]{1,1}));
    }

}
