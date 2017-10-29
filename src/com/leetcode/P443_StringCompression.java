package com.leetcode;

/**
 * Created by xiaoyuan on 29/10/2017.
 */
public class P443_StringCompression {

    public int compress(char[] chars) {

        int ans = 0;
        int n = chars.length;
        char lastCh = chars[0];
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            char ch = chars[i];
            if (ch == lastCh) {
                cnt++;
            } else {
                if (cnt > 1) {
                    sb.append(lastCh);
                    sb.append(cnt);
                    int now = 0;
                    while (cnt > 0) {
                        cnt /= 10;
                        now ++;
                    }

                    ans += now + 1;
                } else {
                    sb.append(lastCh);
                    ans++;
                }

                lastCh = ch;
                cnt = 1;
            }
        }


        if (cnt > 1) {
            sb.append(lastCh);
            sb.append(cnt);
            int now = 0;
            while (cnt > 0) {
                cnt /= 10;
                now ++;
            }
            ans += now + 1;
        } else {
            sb.append(lastCh);
            ans ++;
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P443_StringCompression().compress(new char[]{'a', 'b', 'c'}));
        System.out.println(new P443_StringCompression().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(new P443_StringCompression().compress(new char[]{'a'}));
        System.out.println(new P443_StringCompression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

}
