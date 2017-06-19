package com.leetcode;

/**
 * Created by xiaoyuan on 19/06/2017.
 */
public class P504_Base7 {

    public String convertToBase7(int num) {
        if (num == 0) {return "0";}

        String flag = num >= 0 ? "" : "-";
        if (num < 0) {num = -num;}

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        return flag + sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new P504_Base7().convertToBase7(100));
        System.out.println(new P504_Base7().convertToBase7(-7));
    }

}
