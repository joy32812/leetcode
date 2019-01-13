package com.leetcode;

public class P972_EqualRationalNumbers {


    public boolean isRationalEqual(String S, String T) {

        String x = normal(S);
        String y = normal(T);

        return check(x, y);
    }

    private boolean check(String x, String y) {

        String[] xSplit = x.split("\\.");
        String[] ySplit = y.split("\\.");

        if (!xSplit[0].equals(ySplit[0])) return false;

        String xFra = (xSplit.length == 1 || xSplit[1] == null) ? "" : xSplit[1];
        String yFra = (ySplit.length == 1 || ySplit[1] == null) ? "" : ySplit[1];

        if (xFra.equals(yFra)) return true;

        int len = Math.max(xFra.length(), yFra.length());

        int cnt = 0;
        for (int i = 0; i < 50; i++) {
            char ch = xFra.length() <= i ? '0' : xFra.charAt(i);
            char cy = yFra.length() <= i ? '0' : yFra.charAt(i);

            if (ch != cy) return false;

            if (ch == cy) cnt++;
        }

        return true;
//        return cnt > len * 99 / 100;
    }

    private String normal(String s) {

        String now = s;
        if (s.indexOf("(") > -1) {
            int p = s.indexOf("(");
            String pre = s.substring(0, p);
            String repeat = s.substring(p + 1, s.length() - 1);

            StringBuilder sb = new StringBuilder(pre);
            for (int i = 0; i < 100; i++) {
                sb.append(repeat);
            }

            int cnt = 0;
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) != '9') break;
                cnt++;
            }

            if (cnt > 50) {
                for (int i = sb.length() - 1; i >= 0; i--) {
                    if (sb.charAt(i) == '.') continue;

                    if (sb.charAt(i) == '9') sb.setCharAt(i, '0');
                    else {
                        sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                        break;
                    }
                }
            }

            now = sb.toString();
        }

        if (now.indexOf(".") == -1) now = now + ".";

        return now;
    }


    public static void main(String[] args) {

        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("8.123(4567)", "8.123(4566)"));
        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("0", "0."));
        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("0.(52)", "0.5(25)"));
        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("0.1666(6)", "0.166(66)"));
        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("0.9(9)", "1"));
        System.out.println(new P972_EqualRationalNumbers().isRationalEqual("0.9(9)", "1."));

    }

}
