package com.leetcode;

/**
 * Created by xiaoyuan on 13/06/2017.
 */
public class P458_PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int ans = 0;
        while ((int)Math.pow((minutesToTest / minutesToDie + 1), ans) < buckets) {
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P458_PoorPigs().poorPigs(1000, 15, 60));
        System.out.println(new P458_PoorPigs().poorPigs(7, 2, 4));
    }

}
