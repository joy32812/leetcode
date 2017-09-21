package com.leetcode;

/**
 * Created by xiaoyuan on 21/09/2017.
 */
public class P483_SmallestGoodBase {

    public String smallestGoodBase(String n) {

        long num = Long.parseLong(n);
        for (int i = 63; i >= 2; i--) {

            long l = Math.max(2l, (long)(Math.pow(num, 1.0 / i)));
            long r = (long)(Math.pow(num, 1.0 / (i - 1)));

            if (r < 2) continue;

            while (l <= r) {
                long m = (l + r) / 2;

                long z = 0l;
                long base = 1;
                for (int k = 0; k < i; k++) {
                    z += base;
                    base *= m;
                    if (z > num) {
                        l = m + 1;
                        break;
                    }
                }
                if (z == num) {return "" + m;}

                if (z < num) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return "" + (num - 1);
    }


    public static void main(String[] args) {
        System.out.println(new P483_SmallestGoodBase().smallestGoodBase("13"));

        System.out.println(new P483_SmallestGoodBase().smallestGoodBase("3"));
        System.out.println(new P483_SmallestGoodBase().smallestGoodBase("4681"));
        System.out.println(new P483_SmallestGoodBase().smallestGoodBase("1000000000000000000"));
    }
}
