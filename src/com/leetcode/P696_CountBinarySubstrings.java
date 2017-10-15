package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 15/10/2017.
 */
public class P696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        List<Integer> ones = new ArrayList<>();
        List<Integer> cnts = new ArrayList<>();
        char last = '#';
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch != last) {
                if (last != '#') {
                    ones.add((last - '0'));
                    cnts.add(cnt);
                }

                last = ch;
                cnt = 1;
            } else {
                cnt ++;
            }
        }

        ones.add((last - '0'));
        cnts.add(cnt);


        int ans = 0;
        for (int i = 1; i < ones.size(); i++) {
            ans += Math.min(cnts.get(i - 1), cnts.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P696_CountBinarySubstrings().countBinarySubstrings("00110011"));
        System.out.println(new P696_CountBinarySubstrings().countBinarySubstrings("10101"));
    }

}
