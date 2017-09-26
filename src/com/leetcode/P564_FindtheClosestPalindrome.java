package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 26/09/2017.
 */
public class P564_FindtheClosestPalindrome {

    long ans;
    long dist;
    long longN;
    public String nearestPalindromic(String n) {
        longN = Long.parseLong(n);
        if (n.length() == 1) return "" + (longN - 1);

        ans = 0;
        dist = Long.MAX_VALUE;

        checkLonger(n);
        checkShorter(n);

        char[] chars = n.toCharArray();
        dfs(chars, 0, chars.length - 1);

        return "" + ans;
    }

    private void dfs(char[] chars, int l, int r) {
        if (l > r) {
            StringBuilder sb = new StringBuilder();
            int len = chars.length;
            for (int i = 0; i < len / 2; i++) {
                sb.append(chars[i]);
            }

            StringBuilder sbReverse = new StringBuilder(sb.toString()).reverse();


            long now = 0;
            if (len % 2 == 1) {
                now = Long.parseLong(sb.toString() + "" + chars[len / 2] + sbReverse.toString());
            } else {
                now = Long.parseLong(sb.toString() + "" + sbReverse.toString());
            }

            checkNow(now);

            return;
        }

        char[] copy = Arrays.copyOf(chars, chars.length);

        if (chars[l] < '9') {
            chars[l] = (char)(chars[l] + 1);
            for (int i = l + 1; i < r; i++) chars[i] = '0';

            dfs(chars, l + 1, r - 1);
            chars = copy;
        }

        dfs(chars, l + 1, r - 1);

        if (chars[l] > '0') {
            chars[l] = (char)(chars[l] - 1);
            for (int i = l + 1; i < r; i++) chars[i] = '9';
            dfs(chars, l + 1, r - 1);
            chars = copy;
        }
    }


    private void checkNow(Long now) {

        long nowDist = Math.abs(now - longN);
        if (nowDist == 0) return;

        if (dist > nowDist) {
            dist = nowDist;
            ans = now;
        }
        else if (dist == nowDist && ans > now) {
            dist = nowDist;
            ans = now;
        }
    }

    private void checkShorter(String n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length() - 1; i++) {
            sb.append("9");
        }

        long now = Long.parseLong(sb.toString());
        checkNow(now);
    }

    private void checkLonger(String n) {
        StringBuilder sb = new StringBuilder("1");
        int len = n.length();
        for (int i = 0; i < len - 1; i++) sb.append("0");
        if (len - 1 > 0) sb.append("1");

        long now = Long.parseLong(sb.toString());
        checkNow(now);
    }

    public static void main(String[] args) {
//        System.out.println(new P564_FindtheClosestPalindrome().nearestPalindromic("99"));
//        System.out.println(new P564_FindtheClosestPalindrome().nearestPalindromic("123"));
        System.out.println(new P564_FindtheClosestPalindrome().nearestPalindromic("8000000"));
    }
}
