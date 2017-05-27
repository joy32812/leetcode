package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 27/05/2017.
 */
public class P400_NthDigit {

    public int findNthDigit(int n) {

        long tens = 1;
        long total = 0;
        int i = 1;
        int left = n;
        for (; ;i++) {
            total += 9 * tens * i;
            if (total >= n) {break;}
            left -= 9 * tens * i;
            tens *= 10;
        }

        left--;

        long a = tens + (left / i);
        long b = left % i;

        List<Long> list = new ArrayList<>();
        while (a > 0) {
            list.add(a % 10);
            a /= 10;
        }
        Collections.reverse(list);

        return list.get((int)(b)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new P400_NthDigit().findNthDigit(99));
        System.out.println(new P400_NthDigit().findNthDigit(100));
        System.out.println(new P400_NthDigit().findNthDigit(101));
    }

}
