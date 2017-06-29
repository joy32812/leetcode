package com.leetcode;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P555_SplitConcatenatedStrings {

    public String splitLoopedString(String[] strs) {
        String ans = "";

        for (int i = 0; i < strs.length; i++) {
            String tmp = work(strs, i);
            if (ans.compareTo(tmp) < 0) {
                ans = tmp;
            }
        }

        return ans;

    }

    private String work(String[] strs, int x) {
        StringBuilder sb = new StringBuilder();

        int len = strs.length;
        for (int i = 1; i < len; i++) {
            int p = (x + len + i) % len;
            String s = strs[p];
            String reversS = new StringBuilder(s).reverse().toString();
            if (s.compareTo(reversS) < 0) {
                sb.append(reversS);
            } else {
                sb.append(s);
            }
        }

        String ans = "";
        for (int i = 0; i < strs[x].length(); i++) {
            String tmp = strs[x].substring(i) + sb.toString() + strs[x].substring(0, i);
            if (ans.compareTo(tmp) < 0) {ans = tmp;}

            String reverS = new StringBuilder(strs[x]).reverse().toString();
            tmp = reverS.substring(i) + sb.toString() + reverS.substring(0, i);
            if (ans.compareTo(tmp) < 0) {ans = tmp;}
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P555_SplitConcatenatedStrings().splitLoopedString(new String[]{"yzy", "aba"}));
    }

}
