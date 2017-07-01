package com.leetcode;

import java.math.BigInteger;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P592_FractionAdditionandSubtraction {

    public String fractionAddition(String expression) {

        long[] now = {0, 1, 0};
        int pos = 0;

        while ((int)now[2] < expression.length()) {
            long[] next = getNextNumber(expression, (int)now[2]);
            now = add(now, next);
        }

        return now[0] + "/" + now[1];

    }

    private long[] add(long[] now, long[] next) {

        long up = now[0] * next[1] + now[1] * next[0];
        long down = now[1] * next[1];

        long gcd = new BigInteger("" + up).gcd(new BigInteger("" + down)).longValue();

        return new long[]{up / gcd, down / gcd, next[2]};
    }

    private long[] getNextNumber(String s, int p) {

        int flag = 1;
        int from = p;
        if (s.charAt(p) == '+') {
            flag = 1;
            from = p + 1;
        } else if (s.charAt(p) == '-') {
            flag = -1;
            from = p + 1;
        }


        long up = 0;
        while (from < s.length() && Character.isDigit(s.charAt(from))) {
            up = up * 10 + (s.charAt(from) - '0');
            from++;
        }
        up = up * flag;

        from++;
        long down = 0;
        while (from < s.length() && Character.isDigit(s.charAt(from))) {
            down = down * 10 + (s.charAt(from) - '0');
            from++;
        }

        return new long[]{up, down, from};
    }

    public static void main(String[] args) {
        System.out.println(new P592_FractionAdditionandSubtraction().fractionAddition("-1/2+1/2"));
        System.out.println(new P592_FractionAdditionandSubtraction().fractionAddition("-1/2+1/2+1/3"));
        System.out.println(new P592_FractionAdditionandSubtraction().fractionAddition("1/3-1/2"));
    }

}
