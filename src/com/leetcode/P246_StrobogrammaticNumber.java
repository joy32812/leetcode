package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 12/04/2017.
 */
public class P246_StrobogrammaticNumber {

    private Map<Character, Character> charMap;

    public boolean isStrobogrammatic(String num) {
        charMap = new HashMap<>();
        charMap.put('0', '0');
        charMap.put('1', '1');
        charMap.put('8', '8');
        charMap.put('6', '9');
        charMap.put('9', '6');

        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            char lch = num.charAt(l);
            char rch = num.charAt(r);
            if (charMap.get(lch) == null || charMap.get(rch) == null) {return false;}
            if (!(charMap.get(lch) == rch && charMap.get(rch) == lch)) {return false;}
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P246_StrobogrammaticNumber().isStrobogrammatic("69"));
    }

}
