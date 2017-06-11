package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P482_LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {

        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') {continue;}

            sb.append(S.charAt(i));
            cnt++;

            if (cnt == K) {
                cnt = 0;
                sb.append('-');
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {sb.deleteCharAt(sb.length() - 1);}

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    }


}
