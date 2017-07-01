package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P604_DesignCompressedStringIterator {

    String s;
    List<Character> charList;
    List<Integer> numList;
    int pos;
    int num;
    public P604_DesignCompressedStringIterator(String compressedString) {
        s = compressedString;

        charList = new ArrayList<>();
        numList = new ArrayList<>();

        int i = 0;
        while (i < compressedString.length()) {
            char ch = compressedString.charAt(i);

            int cnt = 0;
            i++;
            while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
                cnt = cnt * 10 + (compressedString.charAt(i) - '0');
                i++;
            }
            if (cnt > 0) {
                charList.add(ch);
                numList.add(cnt);
            }
        }

        pos = 0;
        num = 0;
    }

    public char next() {
        if (!hasNext()) {return ' ';}

        char ch = charList.get(pos);
        num++;

        if (num == numList.get(pos)) {
            pos++;
            num = 0;
        }

        return ch;
    }

    public boolean hasNext() {
        return pos < charList.size();
    }

}
