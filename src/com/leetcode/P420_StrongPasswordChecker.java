package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 30/08/2017.
 */
public class P420_StrongPasswordChecker {

    public int strongPasswordChecker(String s) {

        int needA = 1;
        int needB = 1;
        int needC = 1;
        List<Integer> repeats = new ArrayList<>();

        char lastCh = ' ';
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {needA = 0;}
            if (Character.isLowerCase(ch)) {needB = 0;}
            if (Character.isDigit(ch)) {needC = 0;}


            if (lastCh == ch) {
                cnt++;
            } else {
                if (cnt > 0) {repeats.add(cnt);}

                lastCh = ch;
                cnt = 1;
            }
        }
        if (cnt > 0) {repeats.add(cnt);}

        int totalMissing = needA + needB + needC;
        int ans = 0;
        if (s.length() < 6) {
            ans += totalMissing + Math.max(0, 6 - s.length() - totalMissing);
        } else {
            int overLen = Math.max(0, s.length() - 20);
            int leftOver = 0;
            ans += overLen;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < repeats.size() && overLen > 0; i++) {
                    int num = repeats.get(i);
                    if (num < 3 || num % 3 != (k - 1)) {continue;}

                    num -= Math.min(overLen, k);
                    overLen -= k;
                    repeats.set(i, num);
                }
            }


            for (int i = 0; i < repeats.size(); i++) {
                int num = repeats.get(i);
                if (num >= 3 && overLen > 0) {
                    int need = num - 2;
                    num -= overLen;

                    overLen -= need;
                }

                if (num >= 3) {leftOver += num / 3;}
            }

            ans += Math.max(leftOver, totalMissing);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P420_StrongPasswordChecker().strongPasswordChecker("aaaaa"));
        System.out.println(new P420_StrongPasswordChecker().strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
