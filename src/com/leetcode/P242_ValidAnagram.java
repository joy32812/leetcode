package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 09/04/2017.
 */
public class P242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {return false;}
        if (s.length() != t.length()) {return false;}

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for (int i = 0; i < sCharArray.length; i++) {
            if (sCharArray[i] != tCharArray[i]) {return false;}
        }

        return true;
    }

}
