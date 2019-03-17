package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P1015_NumbersWith1RepeatedDigit {


    /**
     * count the number without repeated digits
     * 1. count the number less then len(N)
     * 2. count the number with the same len, but with prefix
     * @param N
     * @return
     */
    public int numDupDigitsAtMostN(int N) {
        int ans = 0;
        String str = "" + N;
        int len = str.length();

        for (int i = 1; i < len; i++) {
            ans += getAll(i);
        }


        String prefix = "";
        for (int i = 0; i < str.length(); i++) {
            int now = Integer.parseInt("" + str.charAt(i));

            for (int j = (prefix.length() == 0 ? 1 : 0); j < now; j++) {
                ans += count(prefix + j, len);
            }

            prefix = prefix + now;
        }

        ans += check(N);

        return N - ans;
    }

    private int check(int n) {
        String s = "" + n;
        Set<String> nowSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (nowSet.contains("" + ch)) return 0;
            nowSet.add("" + ch);
        }

        return 1;
    }

    private int count(String s, int len) {
        Set<String> nowSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (nowSet.contains("" + ch)) return 0;
            nowSet.add("" + ch);
        }

        int size = nowSet.size();
        int left = len - size;

        int now = 10 - size;
        int ans = 1;
        for (int i = 0; i < left; i++) {
            ans = ans * now;
            now --;
        }

        return ans;
    }

    private int getAll(int x) {
        int ans = 9;
        int now = 9;

        for (int i = 1; i < x; i++) {
            ans *= now;
            now --;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(20));
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(100));
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(1000));
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(21));
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(22));
        System.out.println(new P1015_NumbersWith1RepeatedDigit().numDupDigitsAtMostN(23));
    }

}
