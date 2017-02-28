package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 */
public class P67_AddBinary {

    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m == 0) {return b;}
        if (n == 0) {return a;}

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int x = m - 1, y = n - 1;
        while (true) {
            if (x < 0 && y < 0) {
                break;
            }

            int aa = 0;
            if (x >= 0) {
                aa = Integer.parseInt("" + a.charAt(x));
                x--;
            }

            int bb = 0;
            if (y >= 0) {
                bb = Integer.parseInt("" + b.charAt(y));
                y--;
            }

            int sum = aa + bb + carry;
            int v = sum % 2;
            carry = sum / 2;
            sb.append(v);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new P67_AddBinary().addBinary("11", "10"));
    }

}
