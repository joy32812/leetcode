package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 26/03/2017.
 *
 * CARE:
 * 1. negative
 * 2. overflow
 * 3. zero
 */
public class P166_FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        boolean neg = false;
        if ((0l + numerator) * (0l + denominator) < 0) {
            neg = true;
        }


        long num = numerator;
        long den = denominator;

        num = Math.abs(num);
        den = Math.abs(den);


        long a = num / den;
        long b = num % den;

        if (b == 0) {
            return (neg ? "-" : "") + a;
        }

        List<Long> list = new ArrayList<Long>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (true) {
            b *= 10;
            long m = b / den;
            long n = b % den;

            String key = m + "_" + n;

            if (n == 0) {
                StringBuilder sb = new StringBuilder("" + a + ".");
                for (int i = 0; i < list.size(); i++) {sb.append(list.get(i));}
                sb.append(m);
                return (neg ? "-" : "") + sb.toString();
            } else {
                if (map.containsKey(key)) {
                    int p = map.get(key);
                    StringBuilder sb = new StringBuilder("" + a + ".");
                    for (int i = 0; i < p; i++) {sb.append(list.get(i));}

                    sb.append("(");
                    for (int i = p; i < list.size(); i++) {sb.append(list.get(i));}
                    sb.append(")");
                    return (neg ? "-" : "") + sb.toString();
                } else {
                    list.add(m);
                    map.put(key, list.size() - 1);
                }
            }

            b = n;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P166_FractiontoRecurringDecimal().fractionToDecimal(-2147483648, 1));
        System.out.println(new P166_FractiontoRecurringDecimal().fractionToDecimal(-1, 3333));
        System.out.println(new P166_FractiontoRecurringDecimal().fractionToDecimal(-50, 8));
        System.out.println(new P166_FractiontoRecurringDecimal().fractionToDecimal(2, 1));
        System.out.println(new P166_FractiontoRecurringDecimal().fractionToDecimal(98, 99));
    }
}
