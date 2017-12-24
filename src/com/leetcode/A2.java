package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2 {

    public List<String> ipToCIDR(String ip, int range) {
        List<String> ans = new ArrayList<>();

        long begin = ip2long(ip);
        long end = begin + range - 1;
        long now = begin;
        while (now <= end) {
            String bits = Long.toBinaryString(now);

            int num = 0;
            for (int i = bits.length() - 1; i >= 0; i--) {
                if (bits.charAt(i) == '1' || now + (1 << num + 1) - 1 > end) {
                    break;
                }
                num++;
            }

            String res = long2ip(now) + "/" + (32 - num);
            ans.add(res);

            now = now +  (1 << num);
        }


        return ans;
    }

    private long ip2long(String ip) {
        long res = 0;
        String[] ss = ip.split("\\.");

        for (int i = 0; i < 4; i++) {
            res = res * 256 + Integer.parseInt(ss[i]);
        }

        return res;
    }

    private String long2ip(long n) {
        String[] ss = new String[4];
        for (int i = 3; i >= 0; i--) {
            ss[i] = "" +  n % 256;
            n = n / 256;
        }

        return String.join(".", ss);
    }





    public static void main(String[] args) {
        System.out.println(new A2().ipToCIDR("255.0.0.7", 10));
    }

}
