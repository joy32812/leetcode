package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P468_ValidateIPAddress {

    public String validIPAddress(String IP) {

        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";

        return "Neither";
    }


    private boolean isIPv4(String ip) {
        String[] str = (ip + "#").split("\\.");
        if (str.length != 4) {return false;}
        str[str.length - 1] = str[str.length - 1].substring(0, str[str.length - 1].length() - 1);

        for (int i = 0; i < str.length; i++) {
            int now = 0;
            String s = str[i];
            if (s.length() == 0 || s.length() > 3) {return false;}

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!Character.isDigit(ch)) {return false;}
                if (j == 0 && s.length() != 1 && Integer.parseInt(ch + "") == 0) {return false;}

                now = now * 10 + (ch - '0');
            }
            if (now > 255) { return false;}
        }


        return true;
    }

    private boolean isIPv6(String ip) {
        String[] str = (ip + "#").toLowerCase().split(":");
        if (str.length != 8) {return false;}
        str[str.length - 1] = str[str.length - 1].substring(0, str[str.length - 1].length() - 1);

        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            if (s.length() == 0 || s.length() > 4) {return false;}

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (Character.isDigit(ch)) {continue;}
                if (ch >= 'a' && ch <= 'f') {continue;}
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new P468_ValidateIPAddress().validIPAddress("172.16.254.1"));
        System.out.println(new P468_ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(new P468_ValidateIPAddress().validIPAddress("172.16.254.1"));
        System.out.println(new P468_ValidateIPAddress().validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

}
