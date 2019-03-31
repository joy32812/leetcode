package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1028_ConverttoBaseN2 {

    public String baseNeg2(int N) {
        if (N == 0) return "0";


        StringBuilder sb = new StringBuilder();

        List<long[]> range = new ArrayList<>();
        long[] last = new long[]{1l, 0l, 1l};
        range.add(last);

        long now = 1;

        long min = 0l;
        long max = 1l;

        int size = 50;

        for (int i = 0; i < size; i++) {
            now = now * 2 * -1;

            long[] current = new long[]{now, min + now, max + now};
            range.add(current);

            min = Math.min(min, current[1]);
            max = Math.max(max, current[2]);
        }

        boolean[] ans = new boolean[size];

        long n = N;
        while (n != 0) {
            for (int i = 0; i < size; i++) {
                long[] current = range.get(i);
                if (n >= current[1] && n <= current[2]) {
                    ans[i] = true;
                    n -= current[0];
                    break;
                }
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            if (sb.length() == 0) {
                if (ans[i]) sb.append("1");
            } else {
                if (ans[i]) sb.append("1");
                else sb.append("0");
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
//        System.out.println(new AA2().baseNeg2(2));
//        System.out.println(new AA2().baseNeg2(3));
//        System.out.println(new AA2().baseNeg2(4));
//        System.out.println(new AA2().baseNeg2(5));
        System.out.println(new P1028_ConverttoBaseN2().baseNeg2(1000000000));
    }

}
