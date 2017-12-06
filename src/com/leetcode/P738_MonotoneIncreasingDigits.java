package com.leetcode;

/**
 * Created by xiaoyuan on 06/12/2017.
 */
public class P738_MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {

        int ans = N;
        while (true) {
            int tmp = getMono(ans);
            if (tmp == ans) break;
            ans = tmp;
        }

        return ans;

    }

    private int getMono(int n) {
        String s = "" + n;

        for (int i = 0; i < s.length() - 1; i++) {

            int a = Integer.parseInt("" + s.charAt(i));
            int b = Integer.parseInt("" + s.charAt(i + 1));

            if (a > b) {

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) sb.append(s.charAt(j));
                sb.append("" + (a - 1));
                for (int j = i + 1; j < s.length(); j++) sb.append('9');

                return Integer.parseInt(sb.toString());
            }
        }

        return n;
    }

}
