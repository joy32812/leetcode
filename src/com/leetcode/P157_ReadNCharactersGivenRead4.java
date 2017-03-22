package com.leetcode;

/**
 * Created by xiaoyuan on 22/03/2017.
 */
public class P157_ReadNCharactersGivenRead4 {

    private boolean available;
    private String last;


    private boolean al;

    private int read4(char[] buf) {
        if (al == true) {return 0;}

        al = true;
        buf[0] = 'a';
        buf[1] = 'b';
        buf[2] = 'c';
        buf[3] = 'd';
        return 4;
    }

    public int read(char[] buf, int n) {
        if (last == null) {
            last = "";
            available = true;
        }

        if (!available) {
            if (last.length() > 0) {
                int cnt = Math.min(n, last.length());
                StringBuilder sb = new StringBuilder(last.substring(0,Math.min(n, last.length())));
                last = last.substring(Math.min(n, last.length()));

                for (int i = 0; i < sb.length(); i++) {buf[i] = sb.charAt(i);}
                return cnt;
            }
            return 0;
        }

        int cnt = Math.min(n, last.length());
        StringBuilder sb = new StringBuilder(last);

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

        for (int i = 0; i < Math.min(cnt, n); i++) {
            buf[i] = sb.charAt(i);
        }

        last = sb.substring(Math.min(n, cnt));
        return Math.min(n, cnt);
    }

    public static void main(String[] args) {
        P157_ReadNCharactersGivenRead4 obj = new P157_ReadNCharactersGivenRead4();

        char[] buf = new char[1];
        int num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);

        buf = new char[1];
        num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);

        buf = new char[1];
        num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);

        buf = new char[1];
        num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);

        buf = new char[1];
        num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);

        buf = new char[1];
        num = obj.read(buf, 1);
        System.out.println(num);
        System.out.println(buf[0]);
    }

}
