package com.leetcode;

public class P868_BinaryGap {

    public int binaryGap(int N) {

        String s = Integer.toBinaryString(N);

        int ans = 0;

        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                if (last != -1) ans = Math.max(ans, i - last);
                last = i;
            }
        }

        return ans;
    }

}
