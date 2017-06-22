package com.leetcode;

/**
 * Created by xiaoyuan on 22/06/2017.
 */
public class P507_PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {return false;}
        int sqrtNum = (int)Math.sqrt(1.0 + num);
        sqrtNum = Math.min(sqrtNum, num - 1);

        int total = 0;
        for (int i = 1; i <= sqrtNum; i++) {
            if (num % i != 0) {continue;}
            int a = i;
            int b = num / a;
            if (a > b) {break;}
            if (a == b) {total += a;break;}
            if (a != num) total += a;
            if (b != num) total += b;
        }

        return total == num;
    }

    public static void main(String[] args) {
        System.out.println(new P507_PerfectNumber().checkPerfectNumber(28));
    }

}
