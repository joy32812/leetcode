package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 28/05/2017.
 */
public class P401_BinaryWatch {

    public List<String> readBinaryWatch(int num) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 1024; i++) {
            int bitNum = Integer.bitCount(i);
            if (bitNum != num) {continue;}

            int hour = getHour(i);
            int minute = getMinute(i);

            if (hour > 11 || minute > 59) {continue;}

            ans.add(hour + ":" + (minute <= 9 ? "0" : "") + minute);
        }

        return ans;
    }

    private int getMinute(int bitNum) {
        return bitNum & ((1 << 6) - 1);
    }

    private int getHour(int bitNum) {
        bitNum >>= 6;
        return bitNum;
    }


    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
    }
}
