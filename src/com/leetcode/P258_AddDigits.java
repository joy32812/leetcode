package com.leetcode;

/**
 * Created by xiaoyuan on 14/04/2017.
 */
public class P258_AddDigits {

    public int addDigits(int num) {
        while (true) {
            if (num < 10) {return num;}

            int tmp = 0;
            while (num > 0) {
                tmp += (num % 10);
                num /= 10;
            }
            num = tmp;

            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        System.out.println(new P258_AddDigits().addDigits(Integer.MAX_VALUE));
    }

}
