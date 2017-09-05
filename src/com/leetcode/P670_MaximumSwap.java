package com.leetcode;

/**
 * Created by xiaoyuan on 05/09/2017.
 */
public class P670_MaximumSwap {

    public int maximumSwap(int num) {

        String numStr = "" + num;

        int ans = num;
        char[] arr = numStr.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j++) {
                StringBuilder sb = new StringBuilder(numStr);

                char ch = arr[i];
                sb.setCharAt(i, arr[j]);
                sb.setCharAt(j, ch);

                ans = Math.max(ans, Integer.parseInt(sb.toString()));
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        int a = 1234234;
        char[] z = ("" + a).toCharArray();

        System.out.println(z[0]);

        z[0] = 'b';

        System.out.println(z[0]);

    }

}
