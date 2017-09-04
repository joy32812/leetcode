package com.leetcode;

import java.util.Map;

/**
 * Created by xiaoyuan on 01/09/2017.
 */

public class P440_KthSmallestinLexicographicalOrder {

    int N;
    StringBuilder sb;
    public int findKthNumber(int n, int k) {

        N = n;
        sb = new StringBuilder();

        work(n, k, 1, getBitNum(n));

        return Integer.parseInt(sb.toString());
    }

    private void work(int n, int k, int b, int bitNum) {
        if (k <= 0) {return;}

        int maxPosNum = getMaxPosNum(n);

        int total = 0;
        for (int i = b; i <= 9; i++) {

            int add = getNumBeginWith(i, n, bitNum);
            total += add;
            if (total >= k) {
                sb.append(i);

                total -= add;
                k -= total;
                k --;


                work(n - maxPosNum * ((int)(Math.pow(10, bitNum - 1))), k, 0, bitNum - 1);
                break;
            }
        }

    }

    // the number for integer <= n and begin with x
    public int getNumBeginWith(int x, int n, int bitNum) {
        int res = 0;
        int maxPosNum = getMaxPosNum(n);
        for (int i = 1; i < bitNum; i++) {
            res += (int)(Math.pow(10, i - 1));
        }

        int z = N;
        for (int i = 1; i < bitNum; i++) {
            z /= 10;
        }

        int now = Integer.parseInt(sb.toString() + x);

        if (now == z) {
            res += n - maxPosNum * ((int)(Math.pow(10, bitNum - 1))) + 1;
        } else if (now < z) {
            res += (int)(Math.pow(10, bitNum - 1));
        }

        return res;
    }

    private int getMaxPosNum(int n) {
        int res = 0;
        while (n > 0) {
            res = n;
            n /= 10;
        }
        return res;
    }

    private int getBitNum(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        System.out.println(new P440_KthSmallestinLexicographicalOrder().findKthNumber(100, 100));
//        System.out.println(new P440_KthSmallestinLexicographicalOrder().findKthNumber(1, 1));
//        System.out.println(new P440_KthSmallestinLexicographicalOrder().findKthNumber(10, 3));
        System.out.println(new P440_KthSmallestinLexicographicalOrder().findKthNumber(13, 2));
        System.out.println(new P440_KthSmallestinLexicographicalOrder().findKthNumber(13324, 234));
    }

}
