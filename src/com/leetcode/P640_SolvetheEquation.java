package com.leetcode;

/**
 * Created by xiaoyuan on 17/07/2017.
 */
public class P640_SolvetheEquation {

    public String solveEquation(String equation) {

        String[] eqs = equation.replace(" ", "").split("=");
        int[] left = getValue(eqs[0]);
        int[] right = getValue(eqs[1]);

        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        }
        if (left[0] == right[0] && left[1] != right[1]) {
            return "No solution";
        }

        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    private int[] getValue(String s) {
        int a = 0;
        int b = 0;

        int i = 0;
        while (i < s.length()) {
            int j = i;
            int flag = 1;
            if (s.charAt(j) == '+') {
                j++;
            } else if (s.charAt(j) == '-') {
                flag = -1;
                j++;
            }
            int now = Integer.MAX_VALUE;
            for (; j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-'; j++) {
                if (s.charAt(j) == 'x') {
                    break;
                }
                if (now == Integer.MAX_VALUE) {now = 0;}
                now = now * 10 + (s.charAt(j) - '0');
            }

            if (j < s.length() && s.charAt(j) == 'x') {
                if (now == Integer.MAX_VALUE) {now = 1;}
                a += now * flag;
                j++;
            } else {
                b += now * flag;
            }

            i = j;
        }

        return new int[]{a, b};
    }


    public static void main(String[] args) {
        System.out.println(new P640_SolvetheEquation().solveEquation("0x=0"));
        System.out.println(new P640_SolvetheEquation().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new P640_SolvetheEquation().solveEquation("x=x"));
        System.out.println(new P640_SolvetheEquation().solveEquation("2x=x"));
        System.out.println(new P640_SolvetheEquation().solveEquation("2x+3x-6x=x+2"));
    }
}
