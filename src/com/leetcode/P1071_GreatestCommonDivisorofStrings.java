package com.leetcode;

public class P1071_GreatestCommonDivisorofStrings {


    /**
     * much elegant way
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals("")) return str2;
        if (str1.length() > str2.length()) return gcdOfStrings(str2, str1);
        if (!str2.substring(0, str1.length()).equals(str1)) return "";

        return gcdOfStrings(str2.substring(str1.length()), str1);
    }


    public String gcdOfStrings2(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        String ans = "";

        for (int i = 1; i <= Math.min(m, n); i++) {
            if (m % i != 0 || n % i != 0) continue;;
            String s = str1.substring(0, i);
            String t = str2.substring(0, i);
            if (!s.equals(t)) return ans;

            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int j = 0; ;j++) {
                sb.append(s);
                if (sb.length() > m && sb.length() > n) break;
                if (sb.toString().equals(str1)) cnt++;
                if (sb.toString().equals(str2)) cnt++;
            }

            if (cnt == 2) ans = s;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P1071_GreatestCommonDivisorofStrings().gcdOfStrings("ABCABC", "ABC"));
    }

}
