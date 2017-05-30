package com.leetcode;

/**
 * Created by xiaoyuan on 30/05/2017.
 */
public class P408_ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        int a = 0;
        int b = 0;
        while (true) {
            if (a == word.length() && b == abbr.length()) {return true;}

            if (a == word.length() || b == abbr.length()) {break;}

            char chA = word.charAt(a);
            char chB = abbr.charAt(b);

            if (!Character.isDigit(chB)) {
                if (chA != chB) {break;}
                a++;
                b++;
                continue;
            }

            if (Integer.parseInt("" + chB) == 0) {break;}

            int tmp = 0;
            while (Character.isDigit(chB)) {
                tmp = tmp * 10 + Integer.parseInt("" + chB);
                b++;
                if (b == abbr.length()) {break;}
                chB = abbr.charAt(b);
            }
            a += tmp;
        }

        return false;
    }

}
