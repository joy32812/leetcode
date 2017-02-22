package com.leetcode;

/**
 * Created by xiaoyuan on 22/02/2017.
 * 暴力,直接搞!
 */
public class P38_CountAndSay {

    public String countAndSay(int n) {
        String last = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < last.length(); j++) {
                if (j == 0 || last.charAt(j) != last.charAt(j - 1)) {
                    count = 1;
                } else if (last.charAt(j) == last.charAt(j - 1)) {
                    count++;
                }

                if (j == last.length() - 1 || last.charAt(j) != last.charAt(j + 1)) {
                    sb.append(count + "" + last.charAt(j));
                }
            }

            last = sb.toString();
        }

        return last;
    }

    public static void main(String[] args) {
        System.out.println(new P38_CountAndSay().countAndSay(10));
    }

}
