package com.leetcode;

import java.util.Arrays;

public class P869_ReorderedPowerof2 {

    public boolean reorderedPowerOf2(int N) {

        long now = 1;
        for (int i = 0; i < 32; i++) {
            now = 1 << i;

            if (okay(now, N)) return true;
        }
        return false;
    }


    private boolean okay(long now, long n) {

        char[] achar = ("" + now).toCharArray();
        Arrays.sort(achar);

        char[] bchar = ("" + n).toCharArray();
        Arrays.sort(bchar);

        return (new String(achar)).equals(new String(bchar));
    }

    public static void main(String[] args) {
        System.out.println(new P869_ReorderedPowerof2().reorderedPowerOf2(512));
        System.out.println(new P869_ReorderedPowerof2().reorderedPowerOf2(125));
    }


}
