package com.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class P902_NumbersAtMostNGivenDigitSet {

    /**
     * 1. get the number for value with len < len(N)
     * 2. get the number for value with len == len(N)
     * @param D
     * @param N
     * @return
     */
    public int atMostNGivenDigitSet(String[] D, int N) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (String d : D) treeSet.add(Integer.parseInt(d));

        int size = treeSet.size();

        int ans = 0;
        int len = (""  + N).length();

        for (int i = 1; i < len; i++) {
            ans += getNumByLen(i, size);
        }


        String nstr = "" + N;
        boolean hasAll = true;
        for (int i = 0; i < len; i++) {
            int digit = Integer.parseInt("" + nstr.charAt(i));

            int lessNum = getLessNum(treeSet, digit);
            ans += lessNum * getNumByLen(len - i - 1, size);

            if (!treeSet.contains(digit)) {
                hasAll = false;
                break;
            }
        }

        if (hasAll) ans++;
        return ans;
    }

    private int getNumByLen(int len, int size) {
        return (int) Math.pow(size, len);
    }

    private int getLessNum(TreeSet<Integer> treeSet, int digit) {
        int cnt = 0;
        for (int d : treeSet) {
            if (d < digit) cnt ++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new P902_NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println(new P902_NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 77));
        System.out.println(new P902_NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 76));
    }

}
