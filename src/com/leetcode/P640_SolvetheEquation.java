package com.leetcode;

/**
 * Created by xiaoyuan on 17/07/2017.
 */
public class P640_SolvetheEquation {

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] left = getValue(split[0]);
        int[] right = getValue(split[1]);


        int coeff = left[0] - right[0];
        int val = right[1] - left[1];

        if (coeff == 0) {
            if (val == 0) return "Infinite solutions";
            return "No solution";
        }

        return "x=" + (val / coeff);
    }

    private int[] getValue(String s) {
        if (s.length() == 0) return new int[]{0, 0};

        int numX = 0;
        int val = 0;

        if (s.indexOf('+') >= 0) {
            String[] sp = s.split("[+]");
            for (String subs : sp) {
                int[] now = getValue(subs);
                numX += now[0];
                val += now[1];
            }

            return new int[]{numX, val};
        }


        if (s.indexOf("-") >= 0) {
            String[] sp = s.split("[-]");
            int[] now = getValue(sp[0]);
            numX += now[0];
            val += now[1];

            for (int i = 1; i < sp.length; i++) {
                now = getValue(sp[i]);
                numX -= now[0];
                val -= now[1];
            }
            return new int[]{numX, val};
        }

        if (s.charAt(s.length() - 1) == 'x') return new int[]{s.length() > 1 ? Integer.parseInt(s.substring(0, s.length() - 1)) : 1, 0};
        return new int[]{0, Integer.parseInt(s)};
    }


    public static void main(String[] args) {
        System.out.println(new P640_SolvetheEquation().solveEquation("x+5-3+x=6+x-2"));
    }
}
