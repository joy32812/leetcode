package com.leetcode;

/**
 * Created by xiaoyuan on 25/05/2017.
 */
public class P393_UTF8Validation {

    public boolean validUtf8(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int num = getNum(data[i]);
            if (num > 4) {return false;}

            if (num == 0) {continue;}
            if (num == 1) {return false;}

            if (i + num - 1 >= data.length) {return false;}
            if (!check(data, i, num)) {return false;}
            i = i + num - 1;
        }

        return true;
    }

    private boolean check(int[] data, int p, int num) {
        for (int i = p + 1; i < p + num; i++) {
            if ((data[i] & (1 << 7)) != 0 && (data[i] & (1 << 6)) == 0) {

            } else {
                return false;
            }
        }
        return true;
    }

    private int getNum(int x) {

        int num = 0;
        for (int i = 7; i >= 0; i --) {
            if ((x & ( 1 << i)) != 0) {num++;}
            else {
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new P393_UTF8Validation().validUtf8(new int[]{145}));
        System.out.println(new P393_UTF8Validation().validUtf8(new int[]{197, 130, 1}));
        System.out.println(new P393_UTF8Validation().validUtf8(new int[]{235, 140, 4}));
    }

}
