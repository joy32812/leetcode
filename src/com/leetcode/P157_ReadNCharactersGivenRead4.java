package com.leetcode;

/**
 * Created by xiaoyuan on 22/03/2017.
 */
public class P157_ReadNCharactersGivenRead4 {

    private boolean available;
    private String last;

    private int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        if (last == null) {
            last = "";
            available = true;
        }

        if (!available) {
            if (last.length() > 0) {
                for (int i = 0; i < last.length(); i++) {buf[i] = last.charAt(i);}
                last = "";
                return buf.length;
            }
            return 0;
        }

        int cnt = Math.min(n, last.length());
        StringBuilder sb = new StringBuilder(last.substring(0,Math.min(n, last.length())));
        last = last.substring(Math.min(n, last.length()));

        char[] buffer = new char[4];
        while (cnt < n) {
            int num = read4(buffer);
            for (int i = 0; i < num; i++) {sb.append(buffer[i]);}
            cnt += num;
            if (num < 4) {
                available = false;
                break;
            }
        }

        for (int i = 0; i < cnt; i++) {
            buf[i] = sb.charAt(i);
        }
        last = sb.substring(Math.min(n, cnt));
        return Math.min(n, cnt);
    }

}
