package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 28/02/2017.
 * + - . e E 0 1 2 3 4 5 6 7 8 9
 *
 * ugly Code
 *
 * so many situation!!
 */
public class P65_ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        int cntE = 0;
        int cntP = 0;
        int posE = -1;
        int posP = -1;

        List<Integer> addPos = new ArrayList<Integer>();
        List<Integer> subPos = new ArrayList<Integer>();


        for (int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            if(!(ch == 'e' || ch == 'E' || (ch >= '0' && ch <= '9') || ch == '.' || ch == '+' || ch == '-')) {
                return false;
            }
            if (ch == 'e' || ch == 'E') {
                cntE ++;
                posE = i;
            }
            if (ch == '.') {
                cntP ++;
                posP = i;
            }

            if (ch == '+') {
                addPos.add(i);
            }
            if (ch == '-') {
                subPos.add(i);
            }
        }

        if (cntE >= 2) {
            return false;
        }
        if (cntP >= 2) {
            return false;
        }

        String beforeE = "";
        String afterE = "";
        if (cntE == 0) {
            beforeE = s;
        } else {
            if (posP != -1 && posP > posE) {
                return false;
            }
            if (posE == s.length() - 1) {
                return false;
            }
            beforeE = s.substring(0, posE);
            afterE = s.substring(posE + 1);
        }

        if (beforeE.length() == 0) {
            return false;
        }

        if (posP != -1 && beforeE.length() == 1) {
            return false;
        }


        int cntBefore = 0;
        int cntAfter = 0;
        for (int i = 0; i < beforeE.length(); i++) {
            char ch = beforeE.charAt(i);
            if (ch == '+' || ch == '-') {
                cntBefore ++;
            } else {
                break;
            }
        }

        if (cntBefore == beforeE.length()) {
            return false;
        }
        if (cntP > 0 && cntBefore + 1 == beforeE.length()) {
            return false;
        }

        for (int i = 0; i < afterE.length(); i++) {
            char ch = afterE.charAt(i);
            if (ch == '+' || ch == '-') {
                cntAfter ++;
            } else {
                break;
            }
        }



        if (cntE > 0 && cntAfter == afterE.length()) {
            return false;
        }


        if (cntAfter + cntBefore != addPos.size() + subPos.size()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P65_ValidNumber().isNumber(" +-. "));
        System.out.println(new P65_ValidNumber().isNumber(" -1. "));
        System.out.println(new P65_ValidNumber().isNumber(" 3 "));
        System.out.println(new P65_ValidNumber().isNumber(" -1e9- "));
        System.out.println(new P65_ValidNumber().isNumber(" ++2e9 "));
        System.out.println(new P65_ValidNumber().isNumber(" +-342e-9+ "));


        System.out.println(new P65_ValidNumber().isNumber(" e9 "));
        System.out.println(new P65_ValidNumber().isNumber(" .e1 "));
        System.out.println(new P65_ValidNumber().isNumber(" e "));


        System.out.println(new P65_ValidNumber().isNumber("0"));
        System.out.println(new P65_ValidNumber().isNumber(" 0.1"));
        System.out.println(new P65_ValidNumber().isNumber("abc"));
        System.out.println(new P65_ValidNumber().isNumber("1 a"));
        System.out.println(new P65_ValidNumber().isNumber("2e10"));


        System.out.println(new P65_ValidNumber().isNumber(" 1. 23 "));
        System.out.println(new P65_ValidNumber().isNumber("1.0e"));
        System.out.println(new P65_ValidNumber().isNumber("23.234e23"));
        System.out.println(new P65_ValidNumber().isNumber("23e2.2"));
    }

}
