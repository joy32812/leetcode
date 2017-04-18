package com.leetcode;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P278_FirstBadVersion {

    boolean isBadVersion(int version) {
        boolean a[] = {true, true, true, true};
        return a[version];
    }

    public int firstBadVersion(int n) {

        long l = 1, r = n;
        while (l < r) {
            long m = (l + r) / 2;
            if (isBadVersion((int)m) == true) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (int)r;
    }

    public static void main(String[] args) {
        System.out.println(new P278_FirstBadVersion().firstBadVersion(3));
    }

}
